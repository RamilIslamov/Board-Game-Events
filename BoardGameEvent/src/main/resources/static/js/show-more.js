function showMore(showMoreSelect, container, itemsInRow = 3) {
    const showMore = document.querySelector(showMoreSelect);
    const cardsLength = document.querySelectorAll(container + ".card").length;
    let items = itemsInRow;

    showMore.addEventListener('click', () => {
        items += 3;
        const array = Array.from(document.querySelectorAll(container + ".card"));
        const visItems = array.slice(0, items);

        if (visItems.length === cardsLength) {
            showMore.style.display = 'none';
        }
    })
}



