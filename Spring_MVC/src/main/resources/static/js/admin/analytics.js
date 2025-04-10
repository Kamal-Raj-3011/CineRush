// Initialize charts when needed
function initCharts() {
    // Check if charts exist on this page
    if (document.getElementById('bookingsChart')) {
        // Bookings & Revenue Chart
        const bookingsCtx = document.getElementById('bookingsChart').getContext('2d');
        const bookingsChart = new Chart(bookingsCtx, {
            type: 'line',
            data: {
                labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul'],
                datasets: [
                    {
                        label: 'Bookings',
                        data: [1250, 1890, 1820, 2340, 2780, 2450, 3120],
                        borderColor: '#f84464',
                        backgroundColor: 'rgba(248, 68, 100, 0.1)',
                        tension: 0.3,
                        fill: true
                    },
                    {
                        label: 'Revenue (in ₹1000)',
                        data: [750, 920, 1100, 1250, 1580, 1420, 1850],
                        borderColor: '#1f2533',
                        backgroundColor: 'rgba(31, 37, 51, 0.1)',
                        tension: 0.3,
                        fill: true
                    }
                ]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });
    }
    
    if (document.getElementById('moviesChart')) {
        // Top Movies Chart
        const moviesCtx = document.getElementById('moviesChart').getContext('2d');
        const moviesChart = new Chart(moviesCtx, {
            type: 'bar',
            data: {
                labels: ['Avengers', 'Spider-Man', 'The Batman', 'Joker', 'Dune'],
                datasets: [{
                    label: 'Revenue (in ₹1000)',
                    data: [1850, 1580, 1250, 920, 750],
                    backgroundColor: [
                        'rgba(248, 68, 100, 0.7)',
                        'rgba(31, 37, 51, 0.7)',
                        'rgba(248, 68, 100, 0.5)',
                        'rgba(31, 37, 51, 0.5)',
                        'rgba(248, 68, 100, 0.3)'
                    ],
                    borderColor: [
                        'rgba(248, 68, 100, 1)',
                        'rgba(31, 37, 51, 1)',
                        'rgba(248, 68, 100, 1)',
                        'rgba(31, 37, 51, 1)',
                        'rgba(248, 68, 100, 1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                indexAxis: 'y',
                scales: {
                    x: {
                        beginAtZero: true
                    }
                }
            }
        });
    }
    
    if (document.getElementById('theatersChart')) {
        // Theater Performance Chart
        const theatersCtx = document.getElementById('theatersChart').getContext('2d');
        const theatersChart = new Chart(theatersCtx, {
            type: 'radar',
            data: {
                labels: ['PVR Forum', 'INOX Mantri', 'Cinepolis Orion', 'PVR Nexus', 'IMAX VR'],
                datasets: [{
                    label: 'Occupancy Rate %',
                    data: [85, 78, 72, 65, 58],
                    backgroundColor: 'rgba(248, 68, 100, 0.2)',
                    borderColor: 'rgba(248, 68, 100, 1)',
                    pointBackgroundColor: 'rgba(248, 68, 100, 1)',
                    pointBorderColor: '#fff',
                    pointHoverBackgroundColor: '#fff',
                    pointHoverBorderColor: 'rgba(248, 68, 100, 1)'
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                scales: {
                    r: {
                        angleLines: {
                            display: true
                        },
                        suggestedMin: 0,
                        suggestedMax: 100
                    }
                }
            }
        });
    }
    
    if (document.getElementById('genreChart')) {
        // Genre Distribution Chart
        const genreCtx = document.getElementById('genreChart').getContext('2d');
        const genreChart = new Chart(genreCtx, {
            type: 'doughnut',
            data: {
                labels: ['Action', 'Comedy', 'Drama', 'Horror', 'Sci-Fi', 'Thriller'],
                datasets: [{
                    data: [35, 15, 20, 10, 15, 5],
                    backgroundColor: [
                        'rgba(248, 68, 100, 0.7)',
                        'rgba(31, 37, 51, 0.7)',
                        'rgba(255, 193, 7, 0.7)',
                        'rgba(40, 167, 69, 0.7)',
                        'rgba(0, 123, 255, 0.7)',
                        'rgba(111, 66, 193, 0.7)'
                    ],
                    borderColor: [
                        'rgba(248, 68, 100, 1)',
                        'rgba(31, 37, 51, 1)',
                        'rgba(255, 193, 7, 1)',
                        'rgba(40, 167, 69, 1)',
                        'rgba(0, 123, 255, 1)',
                        'rgba(111, 66, 193, 1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                plugins: {
                    legend: {
                        position: 'right',
                    }
                }
            }
        });
    }
    
    // Dark mode toggle
    const darkModeSwitch = document.getElementById('darkModeSwitch');
    if (darkModeSwitch) {
        darkModeSwitch.addEventListener('change', function() {
            document.body.classList.toggle('dark-mode');
            // You would typically save this preference to localStorage
        });
    }
}

// Initialize when page loads
document.addEventListener('DOMContentLoaded', function() {
    initCharts();
    
    // Highlight current page in sidebar
    const currentPage = window.location.pathname.split('/').pop().replace('.html', '') || 'index';
    const navLinks = document.querySelectorAll('.sidebar .nav-link');
    
    navLinks.forEach(link => {
        link.classList.remove('active');
        if (link.getAttribute('href') === `${currentPage}.html`) {
            link.classList.add('active');
        }
    });
});