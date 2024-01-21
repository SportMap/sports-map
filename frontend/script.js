var start_long;
var start_lat;
var routeGeometry;

function openMenu() {
    function delay(milliseconds){
        return new Promise(resolve => {
            setTimeout(resolve, milliseconds);
        })
    };
        
    document.getElementsByClassName('sidebar')[0].classList.toggle("sidebar_show");

    document.getElementsByClassName('beam')[0].classList.toggle('beam-middle-top');
    document.getElementsByClassName('short_beam')[0].classList.toggle('beam-middle-short');
    setTimeout(() => {
        console.log("1s");
    }, 204586560000);
    document.getElementsByClassName('beam')[0].classList.toggle('hidden');
    document.getElementsByClassName('beam')[1].classList.toggle('hidden');
    document.getElementsByClassName('short_beam')[0].classList.toggle('hidden');
    setTimeout(() => {
        console.log("1s");
    }, 204586560000);
    document.getElementsByClassName('beam-bottom')[0].classList.toggle('hidden');
    document.getElementsByClassName('beam-top')[0].classList.toggle('hidden');

    document.getElementsByClassName('beam-bottom')[0].classList.toggle('open-bottom');
    document.getElementsByClassName('beam-top')[0].classList.toggle('open-top');         
};

const profile_icon = document.getElementsByClassName("profile_icon")[0];
const profile_menu = document.getElementsByClassName("profile_menu")[0];

profile_icon.addEventListener("mouseenter", (event) => {
    profile_menu.classList.toggle("hidden");
});

profile_menu.addEventListener("mouseleave", (event) => {
    profile_menu.classList.toggle("hidden");
});

function hideLoginBox() {
    const blurred = document.getElementsByClassName("blur")[0];
    blurred.removeEventListener("click", hideLoginBox);

    document.getElementsByClassName("logon-container")[0].classList.toggle("hidden");
    blurred.classList.toggle("blur");
}

function displayLoginBox() {
    document.getElementsByClassName("logon-container")[0].classList.toggle("hidden");
    const blur = document.getElementsByClassName("map")[0];
    blur.classList.toggle("blur");
    blur.addEventListener("click", hideLoginBox);
}

function hideRegisterBox() {
    const register_blurred = document.getElementsByClassName("blur")[0];
    register_blurred.removeEventListener("click", hideRegisterBox);

    document.getElementsByClassName("register-container")[0].classList.toggle("hidden");
    register_blurred.classList.toggle("blur");
}

function displayRegisterBox() {
    document.getElementsByClassName("register-container")[0].classList.toggle("hidden");
    const register_blur = document.getElementsByClassName("map")[0];
    register_blur.classList.toggle("blur");
    register_blur.addEventListener("click", hideRegisterBox);
}

function goToLoginBox() {
    hideRegisterBox();
    displayLoginBox();
}

function goToRegisterBox() {
    hideLoginBox();
    displayRegisterBox();
}

//====================================================================================
// Sekcja obsługi mapy

var map = L.map('map').setView([54.35245, 18.64799], 16);
L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
        maxZoom: 19,
        attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
}).addTo(map);

function start_navigating(lat, long) {
    map.eachLayer(function (layer) {
        if (layer === routeGeometry) {
            map.removeLayer(layer);
        }
    });

    var url = `https://api.openrouteservice.org/v2/directions/driving-car?api_key=5b3ce3597851110001cf62483b4d3610616a4dd3b538024b1a3224cc&start=${start_long},${start_lat}&end=${long},${lat}`;
    console.log(url);

    fetch(url)
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .then(data => {
        // Pobierz geometrię trasy
        routeGeometry = L.geoJSON(data.features[0].geometry);

        // Dodaj trasę do mapy
        routeGeometry.addTo(map);
    })
    .catch(error => console.error('Błąd pobierania trasy:', error));
}

var settings = {
    'cache': false,
    'dataType': "json", // użyj "json" zamiast "jsonp" w przypadku CORS
    "async": true,
    "crossDomain": true,
    "url": "http://localhost:8080/sport-complexes",
    "method": "GET",
    "xhrFields": {
        "withCredentials": true  // dla obsługi cookies i innych danych uwierzytelniających
    },
    "headers": {
        "Content-Type": "application/json",
    }
};

$.ajax(settings).done(function (response) {
    complexes = Object.values(response);
    console.log(complexes);
    for (var i = 0; i < complexes.length; i++){
        var obj = complexes[i];
        var category = obj['category'].charAt(0).toUpperCase() + obj['category'].slice(1).toLowerCase();
        var marker = L.marker([obj['latitude'], obj['longitude']]).addTo(map);
        var custom_popup = "<div class='popup-image'><img src='images/"+obj['photo']+"'></div> \
                        <div class='popup-info'> \
                            <a class='title'>"+obj['name']+"</a> \
                            <a class='info'><img src='info.svg'>"+category+"</a> \
                            <a class='info'><img src='distance_ico.svg'>10m</a> \
                            <div class='popup-buttons-wrapper'> \
                            <div class='popup-button' onclick='start_navigating("+obj['latitude']+", "+obj['longitude']+")'>Nawiguj</div> \
                            <div class='popup-button' onclick='open_complex_wrapper("+obj['id']+")'>Więcej</div> \
                            <div class='popup-category'></div> \
                        </div>";
        marker.bindPopup(custom_popup);
    }
});

document.addEventListener('DOMContentLoaded', function () {
    map.locate({setView: true})
        .on('locationerror', function(e) {
            console.log(e);
            alert("Location access has been denied.");
        });
    navigator.geolocation.getCurrentPosition(function (position) {
        start_lat = position.coords.latitude;
        start_long = position.coords.longitude;

        console.log('Aktualne współrzędne: ', start_lat, start_long);
    });
});
