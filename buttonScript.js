document.getElementById('login-form').addEventListener('submit', function(event) {
    var buttonClicked = event.submitter.value;

    if (buttonClicked === 'login') {
        console.log('Login button clicked');
        window.location.href = 'yourTracker.htm';
        event.preventDefault();
    }
});

document.querySelector('input[name="create-account"]').addEventListener('click', function(event) {
    console.log('Create Account button clicked');
    window.location.href = 'registration.htm';
    event.preventDefault(); // Prevent the default action of the button
});

