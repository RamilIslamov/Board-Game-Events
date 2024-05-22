document.addEventListener('DOMContentLoaded', () => {
    const joinTeamForm = document.getElementById("joinForm");

    joinTeamForm.addEventListener('submit', (event) => {
        event.preventDefault();
        const teamNameJoin = document.getElementById('teamNameJoin').value;
        const teamPasswordJoin = document.getElementById('teamPasswordJoin').value;

        const teamNameJoinError = document.querySelector('.teamNameJoinError');
        const teamPasswordJoinError = document.querySelector('.teamPasswordJoinError');

        let valid = true;

        if (!teamNameJoin) {
            valid = false;
            teamNameJoinError.innerText = 'Team name is required.';
        } else {
            teamNameJoinError.innerText = '';
        }

        if (!teamPasswordJoin) {
            valid = false;
            teamPasswordJoinError.innerText = 'Team password is required.';
        } else {
            teamPasswordJoinError.innerText = '';
        }

        if (valid) {
            var formData = $(joinTeamForm).serialize();

            $.ajax({
                type: 'POST',
                url: '/teams/join',
                data: formData,
                success: function (response) {
                    alert(response);
                    window.location.href = "/teams";
                },
                error: function (xhr) {
                    $('#errorMessageJoin').text(xhr.responseText).show();
                }
            });
        }
    });
});