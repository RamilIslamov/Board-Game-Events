const password1 = document.getElementById('userPassword1');
const password2 = document.getElementById('userPassword2');
const btn = document.getElementById('create-btn');
const errMsg = document.getElementById('error-msg');

function hideErrorMessage() {
    errMsg.innerText = "";
}

password1.addEventListener('input', hideErrorMessage);
password2.addEventListener('input', hideErrorMessage);

btn.addEventListener('click', (e) => {
    console.log("Here");
    const password1Value = password1.value.trim();
    const password2Value = password2.value.trim();
    if (password1Value === '' || password2Value === '') {
        e.preventDefault();
        errMsg.innerText = "password cannot be empty";
    } else if (password1Value !== password2Value) {
        e.preventDefault();
        errMsg.innerText = "password mismatch";
    }
});