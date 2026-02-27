/* ===== DevPulse — Productivity Tracker App Logic ===== */

(function () {
    'use strict';

    // ===================== DATA LAYER =====================
    const STORAGE_KEY = 'devpulse_entries';

    function loadEntries() {
        try {
            return JSON.parse(localStorage.getItem(STORAGE_KEY)) || [];
        } catch {
            return [];
        }
    }

    function saveEntries(entries) {
        localStorage.setItem(STORAGE_KEY, JSON.stringify(entries));
    }

    function addEntry(entry) {
        const entries = loadEntries();
        entry.id = Date.now().toString(36) + Math.random().toString(36).slice(2, 7);
        entries.unshift(entry);
        saveEntries(entries);
        return entry;
    }

    function deleteEntry(id) {
        const entries = loadEntries().filter(e => e.id !== id);
        saveEntries(entries);
    }

    // ===================== DATE HELPERS =====================
    function todayStr() {
        return new Date().toISOString().slice(0, 10);
    }

    function formatDateDisplay(dateStr) {
        const d = new Date(dateStr + 'T00:00:00');
        return d.toLocaleDateString('en-US', { month: 'short', day: 'numeric', year: 'numeric' });
    }

    function daysAgo(n) {
        const d = new Date();
        d.setDate(d.getDate() - n);
        return d.toISOString().slice(0, 10);
    }

    function dateRange(days) {
        const dates = [];
        for (let i = days - 1; i >= 0; i--) {
            dates.push(daysAgo(i));
        }
        return dates;
    }

    // ===================== STATS =====================
    function computeStats(entries) {
        const today = todayStr();
        const todayEntries = entries.filter(e => e.date === today);

        const lcToday = todayEntries.filter(e => e.type === 'leetcode').length;
        const ghToday = todayEntries.filter(e => e.type === 'github').length;
        const pjToday = todayEntries.filter(e => e.type === 'project').length;

        const lcTotal = entries.filter(e => e.type === 'leetcode').length;
        const ghTotal = entries.filter(e => e.type === 'github').length;
        const pjTotal = entries.filter(e => e.type === 'project').length;

        // Streak calculation
        const activeDates = new Set(entries.map(e => e.date));
        let currentStreak = 0;
        let longestStreak = 0;
        let tempStreak = 0;
        let d = new Date();

        // Current streak (consecutive days ending today or yesterday)
        if (!activeDates.has(todayStr())) {
            // check if yesterday starts consecutive
            d.setDate(d.getDate() - 1);
        }
        while (activeDates.has(d.toISOString().slice(0, 10))) {
            currentStreak++;
            d.setDate(d.getDate() - 1);
        }

        // Longest streak
        const sortedDates = [...activeDates].sort();
        tempStreak = 1;
        longestStreak = sortedDates.length > 0 ? 1 : 0;
        for (let i = 1; i < sortedDates.length; i++) {
            const prev = new Date(sortedDates[i - 1] + 'T00:00:00');
            const curr = new Date(sortedDates[i] + 'T00:00:00');
            const diff = (curr - prev) / (1000 * 60 * 60 * 24);
            if (diff === 1) {
                tempStreak++;
                longestStreak = Math.max(longestStreak, tempStreak);
            } else {
                tempStreak = 1;
            }
        }

        return { lcToday, ghToday, pjToday, lcTotal, ghTotal, pjTotal, currentStreak, longestStreak };
    }

    function updateStatsUI(stats) {
        animateValue('stat-leetcode-today', stats.lcToday);
        animateValue('stat-github-today', stats.ghToday);
        animateValue('stat-projects-today', stats.pjToday);
        document.getElementById('stat-leetcode-total').textContent = stats.lcTotal;
        document.getElementById('stat-github-total').textContent = stats.ghTotal;
        document.getElementById('stat-projects-total').textContent = stats.pjTotal;
        animateValue('stat-longest-streak', stats.longestStreak);
        animateValue('stat-current-streak', stats.currentStreak);
        document.getElementById('current-streak').textContent = stats.currentStreak;
    }

    function animateValue(elementId, target) {
        const el = document.getElementById(elementId);
        const current = parseInt(el.textContent) || 0;
        if (current === target) { el.textContent = target; return; }
        const duration = 600;
        const start = performance.now();
        function step(now) {
            const progress = Math.min((now - start) / duration, 1);
            const eased = 1 - Math.pow(1 - progress, 3);
            el.textContent = Math.round(current + (target - current) * eased);
            if (progress < 1) requestAnimationFrame(step);
        }
        requestAnimationFrame(step);
    }

    // ===================== HEATMAP =====================
    function renderHeatmap(entries) {
        const container = document.getElementById('heatmap-container');
        container.innerHTML = '';

        // Build day-count map for last 365 days
        const dayCounts = {};
        entries.forEach(e => {
            dayCounts[e.date] = (dayCounts[e.date] || 0) + 1;
        });

        const today = new Date();
        const startDate = new Date(today);
        startDate.setDate(startDate.getDate() - 364);
        // Align to Sunday
        startDate.setDate(startDate.getDate() - startDate.getDay());

        // Month labels
        const monthRow = document.createElement('div');
        monthRow.className = 'heatmap-months';
        const totalWeeks = Math.ceil(((today - startDate) / (1000 * 60 * 60 * 24) + 1) / 7);
        const weekWidth = 17; // 14px cell + 3px gap

        let lastMonth = -1;
        const monthNames = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
        const monthPositions = [];
        for (let w = 0; w < totalWeeks; w++) {
            const weekStart = new Date(startDate);
            weekStart.setDate(weekStart.getDate() + w * 7);
            const m = weekStart.getMonth();
            if (m !== lastMonth) {
                monthPositions.push({ month: monthNames[m], week: w });
                lastMonth = m;
            }
        }

        monthPositions.forEach((mp, i) => {
            const span = document.createElement('span');
            span.textContent = mp.month;
            const nextWeek = i + 1 < monthPositions.length ? monthPositions[i + 1].week : totalWeeks;
            span.style.width = ((nextWeek - mp.week) * weekWidth) + 'px';
            monthRow.appendChild(span);
        });
        container.appendChild(monthRow);

        // Grid
        const grid = document.createElement('div');
        grid.className = 'heatmap-grid';

        const cursor = new Date(startDate);
        while (cursor <= today) {
            const dateStr = cursor.toISOString().slice(0, 10);
            const count = dayCounts[dateStr] || 0;
            const level = count === 0 ? 0 : count <= 1 ? 1 : count <= 3 ? 2 : count <= 5 ? 3 : 4;

            const cell = document.createElement('div');
            cell.className = `heatmap-cell level-${level}`;
            cell.dataset.date = dateStr;
            cell.dataset.count = count;
            cell.title = `${formatDateDisplay(dateStr)}: ${count} activit${count === 1 ? 'y' : 'ies'}`;

            // Tooltip on hover
            cell.addEventListener('mouseenter', showTooltip);
            cell.addEventListener('mouseleave', hideTooltip);

            grid.appendChild(cell);
            cursor.setDate(cursor.getDate() + 1);
        }

        container.appendChild(grid);
    }

    // Tooltip
    let tooltipEl = null;

    function showTooltip(e) {
        const cell = e.currentTarget;
        if (!tooltipEl) {
            tooltipEl = document.createElement('div');
            tooltipEl.className = 'heatmap-tooltip';
            document.body.appendChild(tooltipEl);
        }
        const count = cell.dataset.count;
        const dateStr = cell.dataset.date;
        tooltipEl.innerHTML = `<strong>${count}</strong> activit${count == 1 ? 'y' : 'ies'} on ${formatDateDisplay(dateStr)}`;
        tooltipEl.style.display = 'block';

        const rect = cell.getBoundingClientRect();
        tooltipEl.style.left = rect.left + rect.width / 2 - tooltipEl.offsetWidth / 2 + 'px';
        tooltipEl.style.top = rect.top - tooltipEl.offsetHeight - 8 + 'px';
    }

    function hideTooltip() {
        if (tooltipEl) tooltipEl.style.display = 'none';
    }

    // ===================== CHARTS =====================
    let lcChart = null;
    let ghChart = null;
    let catChart = null;

    const chartDefaults = {
        responsive: true,
        maintainAspectRatio: false,
        plugins: {
            legend: { display: false },
            tooltip: {
                backgroundColor: 'rgba(17, 24, 39, 0.95)',
                titleColor: '#f1f5f9',
                bodyColor: '#94a3b8',
                borderColor: 'rgba(255,255,255,0.08)',
                borderWidth: 1,
                cornerRadius: 8,
                padding: 10,
                titleFont: { family: "'Inter', sans-serif", weight: '600' },
                bodyFont: { family: "'Inter', sans-serif" }
            }
        },
        scales: {
            x: {
                grid: { color: 'rgba(255,255,255,0.04)' },
                ticks: { color: '#64748b', font: { family: "'Inter', sans-serif", size: 10 }, maxRotation: 45 }
            },
            y: {
                beginAtZero: true,
                grid: { color: 'rgba(255,255,255,0.04)' },
                ticks: {
                    color: '#64748b',
                    font: { family: "'Inter', sans-serif", size: 10 },
                    stepSize: 1,
                    callback: v => Number.isInteger(v) ? v : null
                }
            }
        }
    };

    function renderLeetCodeChart(entries, rangeDays) {
        const dates = dateRange(rangeDays);
        const countMap = {};
        entries.filter(e => e.type === 'leetcode').forEach(e => {
            countMap[e.date] = (countMap[e.date] || 0) + 1;
        });
        const data = dates.map(d => countMap[d] || 0);
        const labels = dates.map(d => {
            const dt = new Date(d + 'T00:00:00');
            return dt.toLocaleDateString('en-US', { month: 'short', day: 'numeric' });
        });

        const ctx = document.getElementById('leetcode-chart').getContext('2d');

        if (lcChart) lcChart.destroy();

        const gradient = ctx.createLinearGradient(0, 0, 0, 260);
        gradient.addColorStop(0, 'rgba(34, 211, 238, 0.3)');
        gradient.addColorStop(1, 'rgba(34, 211, 238, 0.0)');

        lcChart = new Chart(ctx, {
            type: 'line',
            data: {
                labels,
                datasets: [{
                    label: 'LeetCode Problems',
                    data,
                    borderColor: '#22d3ee',
                    backgroundColor: gradient,
                    borderWidth: 2.5,
                    pointBackgroundColor: '#22d3ee',
                    pointRadius: rangeDays <= 7 ? 5 : rangeDays <= 30 ? 3 : 1.5,
                    pointHoverRadius: 6,
                    tension: 0.35,
                    fill: true
                }]
            },
            options: { ...chartDefaults }
        });
    }

    function renderGitHubChart(entries, rangeDays) {
        const dates = dateRange(rangeDays);
        const countMap = {};
        entries.filter(e => e.type === 'github').forEach(e => {
            countMap[e.date] = (countMap[e.date] || 0) + 1;
        });
        const data = dates.map(d => countMap[d] || 0);
        const labels = dates.map(d => {
            const dt = new Date(d + 'T00:00:00');
            return dt.toLocaleDateString('en-US', { month: 'short', day: 'numeric' });
        });

        const ctx = document.getElementById('github-chart').getContext('2d');

        if (ghChart) ghChart.destroy();

        ghChart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels,
                datasets: [{
                    label: 'GitHub Pushes',
                    data,
                    backgroundColor: 'rgba(16, 185, 129, 0.6)',
                    hoverBackgroundColor: 'rgba(16, 185, 129, 0.85)',
                    borderRadius: 6,
                    borderSkipped: false,
                    barPercentage: 0.65
                }]
            },
            options: { ...chartDefaults }
        });
    }

    function renderCategoryChart(entries) {
        const lc = entries.filter(e => e.type === 'leetcode').length;
        const gh = entries.filter(e => e.type === 'github').length;
        const pj = entries.filter(e => e.type === 'project').length;

        const ctx = document.getElementById('category-chart').getContext('2d');

        if (catChart) catChart.destroy();

        catChart = new Chart(ctx, {
            type: 'doughnut',
            data: {
                labels: ['LeetCode', 'GitHub', 'Projects'],
                datasets: [{
                    data: [lc, gh, pj],
                    backgroundColor: ['rgba(34, 211, 238, 0.8)', 'rgba(16, 185, 129, 0.8)', 'rgba(168, 85, 247, 0.8)'],
                    hoverBackgroundColor: ['#22d3ee', '#10b981', '#a855f7'],
                    borderColor: 'transparent',
                    borderWidth: 0,
                    spacing: 3,
                    borderRadius: 4
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                cutout: '65%',
                plugins: {
                    legend: {
                        position: 'bottom',
                        labels: {
                            color: '#94a3b8',
                            font: { family: "'Inter', sans-serif", size: 12, weight: '500' },
                            padding: 16,
                            usePointStyle: true,
                            pointStyleWidth: 10
                        }
                    },
                    tooltip: {
                        backgroundColor: 'rgba(17, 24, 39, 0.95)',
                        titleColor: '#f1f5f9',
                        bodyColor: '#94a3b8',
                        borderColor: 'rgba(255,255,255,0.08)',
                        borderWidth: 1,
                        cornerRadius: 8,
                        padding: 10
                    }
                }
            }
        });
    }

    // ===================== ACTIVITY LOG =====================
    let currentFilter = 'all';

    function renderActivityLog(entries) {
        const list = document.getElementById('activity-list');
        const emptyState = document.getElementById('empty-state');

        const filtered = currentFilter === 'all' ? entries : entries.filter(e => e.type === currentFilter);

        // Clear previous entries but keep empty state
        list.querySelectorAll('.activity-entry').forEach(el => el.remove());

        if (filtered.length === 0) {
            emptyState.style.display = 'block';
            return;
        }

        emptyState.style.display = 'none';

        // Sort by date descending, then by id descending
        const sorted = [...filtered].sort((a, b) => {
            if (a.date !== b.date) return b.date.localeCompare(a.date);
            return (b.id || '').localeCompare(a.id || '');
        });

        sorted.forEach(entry => {
            const div = document.createElement('div');
            div.className = 'activity-entry';
            div.dataset.id = entry.id;

            const icon = entry.type === 'leetcode' ? '🧩' : entry.type === 'github' ? '🐙' : '🚀';
            const badgeClass = `badge-${entry.type}`;
            const typeName = entry.type === 'leetcode' ? 'LeetCode' : entry.type === 'github' ? 'GitHub' : 'Project';

            let difficultyHTML = '';
            if (entry.type === 'leetcode' && entry.difficulty) {
                difficultyHTML = `<span class="difficulty-tag diff-${entry.difficulty}">${entry.difficulty.charAt(0).toUpperCase() + entry.difficulty.slice(1)}</span>`;
            }

            let notesHTML = '';
            if (entry.notes && entry.notes.trim()) {
                notesHTML = `<div class="entry-notes">${escapeHTML(entry.notes)}</div>`;
            }

            div.innerHTML = `
                <div class="entry-type-badge ${badgeClass}">${icon}</div>
                <div class="entry-body">
                    <div class="entry-title">${escapeHTML(entry.title)}</div>
                    <div class="entry-meta">
                        <span>${typeName}</span>
                        ${difficultyHTML}
                    </div>
                    ${notesHTML}
                </div>
                <span class="entry-date">${formatDateDisplay(entry.date)}</span>
                <button class="entry-delete" data-id="${entry.id}" title="Delete entry">🗑</button>
            `;

            list.appendChild(div);
        });
    }

    function escapeHTML(str) {
        const d = document.createElement('div');
        d.textContent = str;
        return d.innerHTML;
    }

    // ===================== MODAL =====================
    const modalOverlay = document.getElementById('modal-overlay');
    const modal = document.getElementById('modal');
    const btnOpen = document.getElementById('btn-open-modal');
    const btnClose = document.getElementById('btn-close-modal');
    const form = document.getElementById('entry-form');
    const difficultyGroup = document.getElementById('difficulty-group');
    const dateInput = document.getElementById('entry-date');

    // Set default date to today
    dateInput.value = todayStr();

    btnOpen.addEventListener('click', () => {
        modalOverlay.classList.add('active');
        document.getElementById('entry-title').focus();
    });

    btnClose.addEventListener('click', closeModal);
    modalOverlay.addEventListener('click', (e) => {
        if (e.target === modalOverlay) closeModal();
    });

    document.addEventListener('keydown', (e) => {
        if (e.key === 'Escape' && modalOverlay.classList.contains('active')) closeModal();
    });

    function closeModal() {
        modalOverlay.classList.remove('active');
    }

    // Show/hide difficulty based on type
    document.querySelectorAll('input[name="entry-type"]').forEach(radio => {
        radio.addEventListener('change', () => {
            difficultyGroup.style.display = radio.value === 'leetcode' ? 'block' : 'none';
        });
    });

    // Form submit
    form.addEventListener('submit', (e) => {
        e.preventDefault();

        const type = document.querySelector('input[name="entry-type"]:checked').value;
        const title = document.getElementById('entry-title').value.trim();
        const date = document.getElementById('entry-date').value;
        const notes = document.getElementById('entry-notes').value.trim();
        const difficulty = type === 'leetcode' ? document.getElementById('entry-difficulty').value : null;

        if (!title || !date) return;

        addEntry({ type, title, date, notes, difficulty });

        // Reset form
        form.reset();
        document.querySelector('input[name="entry-type"][value="leetcode"]').checked = true;
        difficultyGroup.style.display = 'block';
        dateInput.value = todayStr();

        closeModal();
        refreshAll();
    });

    // ===================== FILTER =====================
    document.querySelectorAll('.filter-btn').forEach(btn => {
        btn.addEventListener('click', () => {
            document.querySelectorAll('.filter-btn').forEach(b => b.classList.remove('active'));
            btn.classList.add('active');
            currentFilter = btn.dataset.filter;
            renderActivityLog(loadEntries());
        });
    });

    // ===================== DELETE =====================
    document.getElementById('activity-list').addEventListener('click', (e) => {
        const deleteBtn = e.target.closest('.entry-delete');
        if (!deleteBtn) return;
        const id = deleteBtn.dataset.id;
        if (confirm('Delete this activity entry?')) {
            deleteEntry(id);
            refreshAll();
        }
    });

    // ===================== CHART RANGE SELECTORS =====================
    document.getElementById('lc-range').addEventListener('change', (e) => {
        renderLeetCodeChart(loadEntries(), parseInt(e.target.value));
    });

    document.getElementById('gh-range').addEventListener('change', (e) => {
        renderGitHubChart(loadEntries(), parseInt(e.target.value));
    });

    // ===================== REFRESH =====================
    function refreshAll() {
        const entries = loadEntries();
        const stats = computeStats(entries);
        updateStatsUI(stats);
        renderHeatmap(entries);
        renderActivityLog(entries);

        const lcRange = parseInt(document.getElementById('lc-range').value);
        const ghRange = parseInt(document.getElementById('gh-range').value);
        renderLeetCodeChart(entries, lcRange);
        renderGitHubChart(entries, ghRange);
        renderCategoryChart(entries);
    }

    // ===================== INIT =====================
    refreshAll();

})();
