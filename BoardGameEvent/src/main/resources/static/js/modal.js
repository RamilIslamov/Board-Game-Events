function modal(
    openModalSelector,
    modalWrapperSelector,
    modalContentSelector,
    closeModal = false
) {
    // select elements
    const openModalBtns = document.querySelectorAll(openModalSelector);
    const modalWrapperElement = document.querySelector(modalWrapperSelector);
    const modalContentElement = document.querySelector(modalContentSelector);

    // style the modal elements

    openModalBtns.forEach(btn => btn.classList.add('open-modal'));
    modalWrapperElement.classList.add('modal-wrapper');
    modalContentElement.classList.add('modal-content');

    // open modal onclick
    openModalBtns.forEach(btn => btn.addEventListener('click', () => {
        modalWrapperElement.style.display = 'block';
        const eventId = btn.closest(".card").id;
        modalContentElement.querySelector("#eventId").value = eventId;
    }));

    // close modal using the X button
    if (closeModal) {
        modalContentElement.innerHTML += "<span class='close-modal'>&times;</span>";

        const closeModalBtn = modalContentElement.querySelector('.close-modal');

        closeModalBtn.addEventListener('click', () => {
            modalWrapperElement.style.display = 'none';
        });
    }

    // close modal when click outside
    modalWrapperElement.addEventListener('click', (event) => {
        if (event.target === modalWrapperElement) {
            modalWrapperElement.style.display = 'none';
        }
    });
}
