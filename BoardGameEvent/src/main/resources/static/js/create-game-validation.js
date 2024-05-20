document.addEventListener('DOMContentLoaded', () => {
    const createGameForm = document.getElementById("createGame");
    createGameForm.addEventListener('submit', (event) => {
        event.preventDefault();
        console.log("Here");
        const gameName = document.getElementById('gameName').value;
        const playersAmount = document.getElementById('gamePeople').value;
        const gameGenre = document.getElementById('gameGenre').value;
        const gameDuration = document.getElementById('gameDuration').value;
        const gameEquipment = document.getElementById('gameEquipment').value;
        const gameRules = document.getElementById('gameRules').value;

        const gameNameError = document.querySelector('.gameNameError');
        const playersAmountError = document.querySelector('.gamePeopleError');
        const gameGenreError = document.querySelector('.gameGenreError');
        const gameDurationError = document.querySelector('.gameDurationError');
        const gameEquipmentError = document.querySelector('.gameEquipmentError');
        const gameRulesError = document.querySelector('.gameRulesError');

        let valid = true;
        let errorMessage = '';

        if (!gameName) {
            valid = false;
            errorMessage = 'Game name is required.';
            gameNameError.innerText = errorMessage;
        } else {
            gameNameError.innerText = '';
        }

        if (!playersAmount) {
            valid = false;
            errorMessage = 'Game players amount is required.';
            playersAmountError.innerText = errorMessage;
        } else {
            playersAmountError.innerText = '';
        }

        if (!gameGenre) {
            valid = false;
            errorMessage = 'Game genre is required.';
            gameGenreError.innerText = errorMessage;
        } else {
            gameGenreError.innerText = '';
        }

        if (!gameDuration) {
            valid = false;
            errorMessage = 'Game duration is required.';
            gameDurationError.innerText = errorMessage;
        } else {
            gameDurationError.innerText = '';
        }

        if (!gameEquipment) {
            valid = false;
            errorMessage = 'Provide information about additional equipment';
            gameEquipmentError.innerText = errorMessage;
        } else {
            gameEquipmentError.innerText = '';
        }

        if (!gameRules) {
            valid = false;
            errorMessage = 'Rules description is required';
            gameRulesError.innerText = errorMessage;
        } else {
            gameRulesError.innerText = '';
        }

        if (valid) {
            createGameForm.submit();
        }
    });
});
