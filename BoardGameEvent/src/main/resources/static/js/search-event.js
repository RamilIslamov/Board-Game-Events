const searchForm = document.getElementById("search-form-events");
const searchError = document.getElementById('search-error');

searchForm.addEventListener('submit', (event) => {
    event.preventDefault();
    const searchTitle = document.getElementById('searchTitle').value;
    const startDate = document.getElementById('startDate').value;
    const endDate = document.getElementById('endDate').value;
    const gameId = document.getElementById('gamesSearchBar').value;

    if (searchTitle || startDate || endDate || gameId) {
        searchForm.submit();
    } else {
        searchError.innerText = "At least one search param need to be provided!"
    }
})