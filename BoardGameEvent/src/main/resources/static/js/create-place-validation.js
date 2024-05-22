document.addEventListener('DOMContentLoaded', () => {
    const createPlaceForm = document.getElementById("createPlace");

    createPlaceForm.addEventListener('submit', (event) => {
        event.preventDefault();
        const placeName = document.getElementById('placeName').value;
        const placeLocation = document.getElementById('placeLocation').value;
        const placeDescription = document.getElementById('placeDescription').value;

        const placeNameError = document.querySelector('.placeNameError');
        const placeLocationError = document.querySelector('.placeLocationError');
        const placeDescriptionError = document.querySelector('.placeDescriptionError');

        let valid = true;

        if (!placeName) {
            valid = false;
            placeNameError.innerText = 'Place name is required.';
        } else {
            placeNameError.innerText = '';
        }

        if (!placeLocation) {
            valid = false;
            placeLocationError.innerText = 'Place location is required.';
        } else {
            placeLocationError.innerText = '';
        }

        if (!placeDescription) {
            valid = false;
            placeDescriptionError.innerText = 'Place location is required.';
        } else {
            placeDescriptionError.innerText = '';
        }

        if (valid) {
            var formData = $(createPlaceForm).serialize();

            $.ajax({
                type: 'POST',
                url: '/places', // URL для отправки данных формы
                data: formData,
                success: function (response) {
                    alert(response);
                    window.location.href = "/places"; // Перенаправление на страницу команд
                },
                error: function (xhr) {
                    $('#errorMessage').text(xhr.responseText).show();
                }
            });
        }
    });
});
