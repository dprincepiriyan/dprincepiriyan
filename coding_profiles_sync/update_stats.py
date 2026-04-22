import json
import os
import re
from datetime import datetime, timezone
from pathlib import Path
from typing import Any

import requests

OUTPUT_FILE = Path(__file__).with_name("latest_stats.json")
TIMEOUT_SECONDS = 20


def now_utc_iso() -> str:
    return datetime.now(timezone.utc).isoformat()


def safe_get(url: str, params: dict[str, Any] | None = None) -> requests.Response:
    response = requests.get(url, params=params, timeout=TIMEOUT_SECONDS)
    response.raise_for_status()
    return response


def fetch_codeforces(handle: str) -> dict[str, Any]:
    base = "https://codeforces.com/api"

    info_response = safe_get(f"{base}/user.info", params={"handles": handle}).json()
    if info_response.get("status") != "OK":
        raise ValueError(f"Codeforces user.info failed: {info_response}")

    status_response = safe_get(f"{base}/user.status", params={"handle": handle, "from": 1, "count": 10000}).json()
    if status_response.get("status") != "OK":
        raise ValueError(f"Codeforces user.status failed: {status_response}")

    user = info_response["result"][0]
    submissions = status_response.get("result", [])

    solved = {
        f"{s.get('problem', {}).get('contestId', '')}-{s.get('problem', {}).get('index', '')}"
        for s in submissions
        if s.get("verdict") == "OK" and s.get("problem")
    }
    solved.discard("-")

    last_submission_epoch = submissions[0].get("creationTimeSeconds") if submissions else None

    return {
        "handle": handle,
        "rating": user.get("rating"),
        "maxRating": user.get("maxRating"),
        "rank": user.get("rank"),
        "maxRank": user.get("maxRank"),
        "contribution": user.get("contribution"),
        "acceptedProblems": len(solved),
        "submissionCount": len(submissions),
        "lastSubmissionEpoch": last_submission_epoch,
        "fetchedAt": now_utc_iso(),
    }


def fetch_leetcode(username: str) -> dict[str, Any]:
    graphql_url = "https://leetcode.com/graphql"
    query = """
    query userPublicProfile($username: String!) {
      matchedUser(username: $username) {
        username
        profile {
          ranking
          reputation
          starRating
        }
        submitStatsGlobal {
          acSubmissionNum {
            difficulty
            count
            submissions
          }
        }
      }
    }
    """

    payload = {
        "operationName": "userPublicProfile",
        "variables": {"username": username},
        "query": query,
    }

    response = requests.post(graphql_url, json=payload, timeout=TIMEOUT_SECONDS)
    response.raise_for_status()
    body = response.json()

    if body.get("errors"):
        raise ValueError(f"LeetCode GraphQL errors: {body['errors']}")

    user = body.get("data", {}).get("matchedUser")
    if not user:
        raise ValueError("LeetCode user not found or profile is private")

    ac_list = user.get("submitStatsGlobal", {}).get("acSubmissionNum", [])

    accepted_by_difficulty = {
        item.get("difficulty", "Unknown"): item.get("count", 0) for item in ac_list
    }

    return {
        "username": user.get("username", username),
        "ranking": user.get("profile", {}).get("ranking"),
        "reputation": user.get("profile", {}).get("reputation"),
        "starRating": user.get("profile", {}).get("starRating"),
        "acceptedByDifficulty": accepted_by_difficulty,
        "acceptedTotal": accepted_by_difficulty.get("All", 0),
        "fetchedAt": now_utc_iso(),
    }


def _extract_first_int(pattern: str, text: str) -> int | None:
    match = re.search(pattern, text, flags=re.IGNORECASE)
    if not match:
        return None
    value = re.sub(r"[^\d]", "", match.group(1))
    return int(value) if value else None


def _extract_first_text(pattern: str, text: str) -> str | None:
    match = re.search(pattern, text, flags=re.IGNORECASE)
    return match.group(1).strip() if match else None


def fetch_codechef(username: str) -> dict[str, Any]:
    url = f"https://www.codechef.com/users/{username}"
    html = safe_get(url).text

    rating = _extract_first_int(r'class="rating-number"[^>]*>\s*([\d,]+)\s*<', html)
    stars = _extract_first_text(r'class="rating"[^>]*>\s*([^<]+)\s*<', html)
    global_rank = _extract_first_int(r'Global Rank\s*</span>\s*<strong[^>]*>\s*#?([\d,]+)', html)
    country_rank = _extract_first_int(r'Country Rank\s*</span>\s*<strong[^>]*>\s*#?([\d,]+)', html)

    return {
        "username": username,
        "rating": rating,
        "stars": stars,
        "globalRank": global_rank,
        "countryRank": country_rank,
        "sourceUrl": url,
        "fetchedAt": now_utc_iso(),
    }


def run() -> None:
    handles = {
        "codeforces": os.getenv("CODEFORCES_HANDLE", "").strip(),
        "leetcode": os.getenv("LEETCODE_USERNAME", "").strip(),
        "codechef": os.getenv("CODECHEF_USERNAME", "").strip(),
    }

    result: dict[str, Any] = {
        "generatedAt": now_utc_iso(),
        "profiles": {},
    }

    for platform, handle in handles.items():
        if not handle:
            result["profiles"][platform] = {
                "status": "skipped",
                "reason": "Missing username in environment variable",
            }
            continue

        try:
            if platform == "codeforces":
                data = fetch_codeforces(handle)
            elif platform == "leetcode":
                data = fetch_leetcode(handle)
            elif platform == "codechef":
                data = fetch_codechef(handle)
            else:
                data = {"status": "unknown_platform"}

            result["profiles"][platform] = {
                "status": "ok",
                "data": data,
            }
        except Exception as exc:  # noqa: BLE001 - keep workflow resilient
            result["profiles"][platform] = {
                "status": "error",
                "error": str(exc),
            }

    OUTPUT_FILE.write_text(json.dumps(result, indent=2), encoding="utf-8")
    print(f"Wrote {OUTPUT_FILE}")


if __name__ == "__main__":
    run()
