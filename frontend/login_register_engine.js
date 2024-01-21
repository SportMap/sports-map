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
});