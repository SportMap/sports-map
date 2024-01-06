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

// Sekcja obsłgi mapy

var map = L.map('map').setView([54.35245, 18.64799], 16);
L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
        maxZoom: 19,
        attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
}).addTo(map);

var marker = L.marker([54.35245, 18.64799]).addTo(map);
var custom_popup = "<div class='popup-image'></div> \
                    <div class='popup-info'> \
                    <a class='title'>Polsko Japońska Akademia Technik Komputerowych</a> \
                    <a class='info'><img src='info.svg'> Uczelnia</a> \
                    <a class='info'><img src='distance_ico.svg'> 10m</a> \
                    <div class='popup-buttons-wrapper'> \
                    <div class='popup-button'>Nawiguj</div> \
                    <div class='popup-button'>Więcej</div> \
                    <div class='popup-category'></div> \
                    </div>";
marker.bindPopup(custom_popup);