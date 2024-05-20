function showMore(showMoreSelect, container, itemsInRow = 3, card = " .card") {
    const showMore = document.querySelector(showMoreSelect);
    const cardsLength = document.querySelectorAll(container + card).length;
    let items = itemsInRow;

    showMore.addEventListener('click', () => {
        items += items;
        const array = Array.from(document.querySelectorAll(container + card));
        const visItems = array.slice(0, items);
        visItems.forEach(el => el.style.display = 'flex');

        if (visItems.length === cardsLength) {
            showMore.style.display = 'none';
        }
    })
}



