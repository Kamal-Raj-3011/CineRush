function searchCinemas() {
    const input = document.getElementById('cinemaSearch');
    const filter = input.value.toLowerCase();
    const cinemaContainer = document.getElementById('cinemaContainer');
    const cinemas = cinemaContainer.getElementsByClassName('cinema-card');
    const noResults = document.getElementById('noResults');
    
    let hasResults = false;
    
    for (let i = 0; i < cinemas.length; i++) {
        const cinema = cinemas[i];
        const name = cinema.getAttribute('data-name').toLowerCase();
        const location = cinema.getAttribute('data-location').toLowerCase();
        
        if (name.includes(filter) || location.includes(filter)) {
            cinema.classList.remove('hidden');
            hasResults = true;
        } else {
            cinema.classList.add('hidden');
        }
    }
    
    // Show/hide no results message
    if (hasResults || filter === '') {
        noResults.classList.add('hidden');
    } else {
        noResults.classList.remove('hidden');
    }
}

// Add event listener for Enter key
document.getElementById('cinemaSearch').addEventListener('keypress', function(e) {
    if (e.key === 'Enter') {
        searchCinemas();
    }
});
