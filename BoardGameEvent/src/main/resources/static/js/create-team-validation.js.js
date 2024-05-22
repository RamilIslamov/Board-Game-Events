document.addEventListener('DOMContentLoaded', () => {
    const createTeamForm = document.getElementById("teamForm");

    createTeamForm.addEventListener('submit', (event) => {
        event.preventDefault();
        const teamName = document.getElementById('teamName').value;
        const teamLeader = document.getElementById('teamLeader').value;
        const teamMembers = document.getElementById('teamMembers').value;
        const teamPassword = document.getElementById('teamPassword').value;

        const teamNameError = document.querySelector('.teamNameError');
        const teamLeaderError = document.querySelector('.teamLeaderError');
        const teamMembersError = document.querySelector('.teamMembersError');
        const teamPasswordError = document.querySelector('.teamPasswordError');

        let valid = true;

        if (!teamName) {
            valid = false;
            teamNameError.innerText = 'Team name is required.';
        } else {
            teamNameError.innerText = '';
        }

        if (!teamLeader) {
            valid = false;
            teamLeaderError.innerText = 'Team leader is required.';
        } else {
            teamLeaderError.innerText = '';
        }

        if (teamMembers <= 0 || !teamMembers) {
            valid = false;
            teamMembersError.innerText = 'Team players amount must be more than 0.';
        } else {
            teamMembersError.innerText = '';
        }

        if (!teamPassword) {
            valid = false;
            teamPasswordError.innerText = 'Password is required.';
        } else {
            teamPasswordError.innerText = '';
        }

        if (valid) {
            var formData = $(createTeamForm).serialize();

            $.ajax({
                type: 'POST',
                url: '/teams/create', // URL для отправки данных формы
                data: formData,
                success: function (response) {
                    alert(response);
                    window.location.href = "/teams"; // Перенаправление на страницу команд
                },
                error: function (xhr) {
                    $('#errorMessage').text(xhr.responseText).show();
                }
            });
        }
    });
});
