function login() {
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const rememberMe = document.getElementById('remember_me').checked;
    const requestData = {
        username: username,
        password: password
    };

    fetch('http://localhost:8080/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(requestData),
        credentials: 'include',  // Włącz przekazywanie ciasteczek w żądaniu
    })
    .then(response => {
        // Sprawdź, czy odpowiedź ma status 200 OK
        if (response.ok) {
            console.log("Pomyślnie zalogowano uzytkownika");
            const expires = new Date(Date.now() + 1 * 24 * 60 * 60 * 1000).toUTCString();
            document.cookie = `justLoggedIn=true; expires=${expires}; path=/;`;
            document.cookie = `username=${username}; expires=${expires}; path=/;`;
            window.location.reload();
        } else {
            throw new Error('Błąd logowania');
        }
    })
    .then(data => {
        // Tutaj możesz użyć danych z odpowiedzi, jeśli są potrzebne
        console.log('Zalogowano pomyślnie!');
    })
    .catch(error => {
        console.error('Błąd logowania:', error);
    });
}

function register() {
    const username = document.getElementById('username_reg').value;
    const password = document.getElementById('password_reg').value;
    const email = document.getElementById('email').value;
    const rememberMe = document.getElementById('accept_terms').checked;
    const requestData = {
        username: username,
        password: password,
        email: email
    };

    fetch('http://localhost:8080/signup', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(requestData),
        credentials: 'include',  // Włącz przekazywanie ciasteczek w żądaniu
    })
    .then(response => {
        // Sprawdź, czy odpowiedź ma status 200 OK
        if (response.ok) {
            console.log("Pomyślnie zarejestrowano uzytkownika");
            const expires = new Date(Date.now() + 1 * 24 * 60 * 60 * 1000).toUTCString();
            document.cookie = `justRegistered=true; expires=${expires}; path=/;`;
            document.cookie = `username=${username}; expires=${expires}; path=/;`;
            window.location.reload();
        } else {
            throw new Error('Błąd rejestracji');
        }
    })
    .then(data => {
        // Tutaj możesz użyć danych z odpowiedzi, jeśli są potrzebne
        console.log('Zarejestrowano pomyślnie!');
    })
    .catch(error => {
        console.error('Błąd rejestracji:', error);
    });
}

document.addEventListener('DOMContentLoaded', function () {
    if (document.cookie.includes('justLoggedIn=')) {
        // Usuń cookie
        document.cookie = `justLoggedIn=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;`;
        document.getElementById('successMessage').style.display = 'block';
        setTimeout(() => {
            document.getElementById('successMessage').style.display = 'none';
        }, 2000);
    } else {
        console.log('Użytkownik niezalogowany');
    }

    if (document.cookie.includes('justRegistered=')) {
        // Usuń cookie
        document.cookie = `justRegistered=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;`;
        document.getElementById('successMessageReg').style.display = 'block';
        setTimeout(() => {
            document.getElementById('successMessageReg').style.display = 'none';
        }, 2000);
    } else {
        console.log('Użytkownik nie rejestrowal sie');
    }
});