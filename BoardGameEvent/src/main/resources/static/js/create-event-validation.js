const createEventForm = document.getElementById("createEvent");
createEventForm.addEventListener('submit', (event) => {
    event.preventDefault();

    const eventName = document.getElementById('eventName').value;
    const eventDescr = document.getElementById('eventDescr').value;
    const eventLocation = document.getElementById('eventLocation').value;
    const eventDate = document.getElementById('eventDate').value;
    const eventPeople1 = document.getElementById('eventPeople1').value;
    const gameId = document.getElementById('games').value;

    const eventNameError = document.querySelector('.eventNameError');
    const eventDescrError = document.querySelector('.eventDescrError');
    const eventLocationError = document.querySelector('.eventLocationError');
    const eventDateError = document.querySelector('.eventDateError');
    const eventPeopleError = document.querySelector('.eventAmountError');
    const eventGameError = document.querySelector('.eventGameError');

    let valid = true;
    let errorMessage = '';

    if (!eventName) {
        valid = false;
        errorMessage = 'Event name is required.';
        eventNameError.innerHTML = errorMessage;
    }

    if (!eventDescr) {
        valid = false;
        errorMessage = 'Event description is required.';
        eventDescrError.innerHTML = errorMessage;
    }

    if (!eventLocation) {
        valid = false;
        errorMessage = 'Event location is required.';
        eventLocationError.innerHTML = errorMessage;
    }

    if (!eventDate) {
        valid = false;
        errorMessage = 'Event date is required.';
        eventDateError.innerHTML = errorMessage;
    } else {
        const now = new Date();
        const eventDateTime = new Date(eventDate);
        if (eventDateTime < now) {
            valid = false;
            errorMessage = 'Event date cannot be in the past.';
            eventDateError.innerHTML = errorMessage;
        }
    }

    if (eventPeople1 <= 0) {
        valid = false;
        errorMessage = 'Event players amount must be bigger than 0.';
        eventPeopleError.innerHTML = errorMessage;
    }

    if (!gameId) {
        valid = false;
        errorMessage = 'Please choose a game from the list.';
        eventGameError.innerHTML = errorMessage;
    }

    if (valid) {
        createEventForm.submit();
    }
})