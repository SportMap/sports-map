var mapContainer = document.getElementsByClassName('map')[0];

function show_complex_menu(id) {
    var info = document.getElementsByClassName('complex_info')[0];
    var opinie = document.getElementsByClassName('complex_opinie')[0];
    var wydarzenia = document.getElementsByClassName('complex_wydarzenia')[0];
    var info_container = document.getElementsByClassName('complex_info_container')[0];
    var opinie_container = document.getElementsByClassName('complex_opinie_container')[0];
    var wydarzenia_container = document.getElementsByClassName('complex_wydarzenia_container')[0];

    if(id==1) {
        opinie.classList.remove('active');
        opinie_container.classList.add('hidden')
        wydarzenia.classList.remove('active');
        wydarzenia_container.classList.add('hidden')
        info.classList.add('active');
        info_container.classList.remove('hidden');
    }

    else if(id==2) {
        info.classList.remove('active');
        info_container.classList.add('hidden')
        wydarzenia.classList.remove('active');
        wydarzenia_container.classList.add('hidden')
        opinie.classList.add('active');
        opinie_container.classList.remove('hidden');
    }

    else if(id==3) {
        opinie.classList.remove('active');
        opinie_container.classList.add('hidden')
        info.classList.remove('active');
        info_container.classList.add('hidden')
        wydarzenia.classList.add('active');
        wydarzenia_container.classList.remove('hidden');
    }
}

function exit_from_complex_wrapper() {
    var divs = document.getElementsByClassName('complex_wrapper');
    for(var i = 0; i < divs.length; i++) {
        divs[0].parentNode.removeChild(divs[0]);
    }
}

function open_complex_wrapper(id) {
    var old_complex_wrapper = document.querySelector('.complex_wrapper');
    if(old_complex_wrapper) {
        old_complex_wrapper.parentNode.removeChild(old_complex_wrapper);
    }
    else {
        console.log("Complex_wrapper jeszcze nie istnieje")
    }

    var url_address = "http://localhost:8080/sport-complexes/"+id;
    var settings = {
        'cache': false,
        'dataType': "json", // użyj "json" zamiast "jsonp" w przypadku CORS
        "async": true,
        "crossDomain": true,
        "url": url_address,
        "method": "GET",
        "xhrFields": {
            "withCredentials": false  // dla obsługi cookies i innych danych uwierzytelniających
        },
        "headers": {
            "Content-Type": "application/json",
        }
    };
    
    $.ajax(settings).done(function (response) {
        complex = Object.values(response);
        console.log(complex);
        var formattedData = {
            "name": complex[0],
            "category": complex[1].charAt(0).toUpperCase() + complex[1].slice(1).toLowerCase(),
            "surface": complex[2],
            "website": complex[3],
            "phoneNumber": complex[4].replace(/(.{3})/g, "$1 "),
            "address": {
                "id": complex[5].id,
                "street": complex[5].street,
                "postalCode": complex[5].postalCode.replace(/(\d{2})(\d{3})/, "$1-$2"),
                "buildingNumber": complex[5].buildingNumber,
                "apartmentNumber": complex[5].apartmentNumber,
                "city": complex[5].city
            },
            "photo": complex[6],
            "isOpen": complex[7],
            "isEventNow": complex[8],
            "isEventTomorrow": complex[9],
            "isOpen247": complex[10],
            "openingHours": complex[11]
        };        
    
        console.log(formattedData);
        if(formattedData.isOpen) {
            var isopennow = "otwarta";
        }
        else {
            var isopennow = "zamknięta";
        }
        var complex_wrapper = "<div class='complex_wrapper'> \
                                <div class='complex_wrapper_img'> \
                                    <img src='images/"+formattedData.photo+"'> \
                                    <div class='exit_button' onclick='exit_from_complex_wrapper()'> \
                                        <img src='x_letter.svg'> \
                                    </div> \
                                </div> \
                                <h1>"+formattedData.name+"</h1> \
                                <div class='complex_rating_wrapper'> \
                                    <div class='complex_rating_wrapper_grade'> 4.0  \
                                        <div class='rating' id='ratingContainer'> \
                                            <span class='star active' data-value='1'>&#9733;</span> \
                                            <span class='star active' data-value='2'>&#9733;</span> \
                                            <span class='star active' data-value='3'>&#9733;</span> \
                                            <span class='star active' data-value='4'>&#9733;</span> \
                                            <span class='star' data-value='5'>&#9733;</span> \
                                        </div> \
                                    </div> \
                                    <div class='complex_rating_wrapper_category'>"+formattedData.category+", "+isopennow+"</div> \
                                </div> \
                                <div class='complex_wrapper_menu'> \
                                    <div class='complex_wrapper_menu_button complex_info active' onclick='show_complex_menu(1)'>Informacje</div> \
                                    <div class='complex_wrapper_menu_button complex_opinie' onclick='show_complex_menu(2)'>Opinie</div> \
                                    <div class='complex_wrapper_menu_button complex_wydarzenia' onclick='show_complex_menu(3)'>Wydarzenia</div> \
                                </div> \
                                <div class='complex_wrapper_menu_container complex_info_container'> \
                                    <div class='main_info'><img src='phone.svg'>"+formattedData.phoneNumber+"</div> \
                                    <div class='main_info'><img src='markup.svg'>"+formattedData.address.postalCode+" "+formattedData.address.city+", "+formattedData.address.street+" "+formattedData.address.buildingNumber+"</div> \
                                    <div class='main_info'><img src='clock.svg'>"+formattedData.openingHours+"</div> \
                                    <div class='main_info'><img src='info.svg'>"+formattedData.category+", "+isopennow+"</div> \
                                    <div class='main_info'><img src='planet.svg'><a href='"+formattedData.website+"'>"+formattedData.website+"</a></div> \
                                </div> \
                                <div class='complex_wrapper_menu_container complex_opinie_container hidden'> \
                                </div> \
                                <div class='complex_wrapper_menu_container complex_wydarzenia_container hidden'> \
                                </div> \
                            </div>";

        var mapContainer = document.querySelector('.map_container');
        mapContainer.insertAdjacentHTML('beforeend', complex_wrapper);
        
    });
}