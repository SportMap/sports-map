function getCookie(cookieName) {
    var name = cookieName + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var cookieArray = decodedCookie.split(';');

    for(var i = 0; i < cookieArray.length; i++) {
        var cookie = cookieArray[i];
        while (cookie.charAt(0) == ' ') {
            cookie = cookie.substring(1);
        }
        if (cookie.indexOf(name) == 0) {
            return cookie.substring(name.length, cookie.length);
        }
    }
    return null;
}

function deleteAllCookies() {
    var cookies = document.cookie.split(";");

    for (var i = 0; i < cookies.length; i++) {
        var cookie = cookies[i];
        var eqPos = cookie.indexOf("=");
        var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
        document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
    }
}

function goToAddComplex() {
    window.location.href = "add_sport_complex.html";
}

function print_add_event_button() {
    const eventButton = document.createElement("div");
    eventButton.classList.add("add_complex");
    eventButton.innerHTML = "+";
    eventButton.addEventListener('click', goToAddComplex);
    var mapBox = document.getElementsByClassName("map_container")[0];
    mapBox.appendChild(eventButton);
}

document.addEventListener('DOMContentLoaded', function () {
    if (document.cookie.includes('username=')) {
        const profileMenuLoginButton = document.getElementById("login");
        profileMenuLoginButton.parentNode.removeChild(profileMenuLoginButton);
        
        const profileMenuLRegisterButton = document.getElementById("register");
        profileMenuLRegisterButton.parentNode.removeChild(profileMenuLRegisterButton);

        const name = document.getElementsByClassName("name")[0];
        var usernameCookieValue = getCookie('username');
        name.innerHTML = "Witaj, "+usernameCookieValue;

        const profileMenuBox = document.getElementsByClassName("profile_menu")[0];
        const profileMenuBoxLink = document.getElementsByClassName("text")[1];

        var profileButton = document.createElement("div");
        profileButton.classList.add("button");
        profileButton.textContent = "Profil";
        profileButton.addEventListener("click", function() {
            window.location.href = "user_dashboard.html";
        });

        var logoutButton = document.createElement("div");
        logoutButton.classList.add("button");
        logoutButton.textContent = "Wyloguj";
        logoutButton.onclick = function () {
            deleteAllCookies();
            var currentPath = window.location.pathname;
            var fileName = currentPath.substring(currentPath.lastIndexOf("/") + 1);
            if(fileName != "index.html") {
                window.location.href = "index.html";
            }
            else {
                window.location.reload();
            }
        } ;

        profileMenuBox.appendChild(profileButton);
        profileMenuBox.appendChild(logoutButton);
        profileMenuBoxLink.insertAdjacentElement("beforebegin", profileButton);
        profileMenuBoxLink.insertAdjacentElement("beforebegin", logoutButton);

        print_add_event_button();
    }

    else {
        console.log("Użytkownik niezalogowany");
    }
});