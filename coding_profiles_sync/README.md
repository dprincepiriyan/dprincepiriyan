# Coding Profiles Auto Sync

This folder contains an automated sync script that fetches public profile stats from:
- Codeforces
- LeetCode
- CodeChef

The script writes results to `coding_profiles_sync/latest_stats.json`.

## Environment variables

Set these repository variables in GitHub (Settings -> Secrets and variables -> Actions -> Variables):
- `CODEFORCES_HANDLE`
- `LEETCODE_USERNAME`
- `CODECHEF_USERNAME`

## Run locally

```bash
pip install -r coding_profiles_sync/requirements.txt
python coding_profiles_sync/update_stats.py
```

## Automation

The GitHub Actions workflow at `.github/workflows/update-coding-profiles.yml` runs on a schedule and pushes updates automatically.
