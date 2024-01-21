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

function get_complex_opinions(id, container) {
    var url_address = "http://localhost:8080/reviews/"+id;
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
        opinions = Object.values(response);

        if(opinions.length == 0) {
            console.log("brak opinii");
            const box = document.getElementsByClassName('complex_opinie_container_rating')[0];
            box.parentNode.removeChild(box);
        }

        else {
            opinions.forEach(opinion => {
                const opinionDiv = document.createElement("div");
                opinionDiv.classList.add("opinion");
                opinionDiv.innerHTML = `<div class='opinion_rate'>
                                            <div class='opinion_rate_avatar'><img src='users/avatars/${opinion.avatar}'></div>
                                            <div class='opinion_rate_rating'>
                                                <nick>${opinion.nickname}</nick>
                                                <date>${opinion.date[2]}.${opinion.date[1]}.${opinion.date[0]}</date>
                                                <div class='complex_rating' id='opinionRating'></div>
                                            </div>
                                        </div>
                                        <div class='opinion_comment'>${opinion.content}</div>`;
                container.appendChild(opinionDiv);

                var ratingDiv = document.getElementById('opinionRating');
                for(var i = 1; i <= opinion.rate; i++) {
                    const star_rate = "<span class='star active'>&#9733;</span>"
                    ratingDiv.insertAdjacentHTML('beforeend', star_rate);
                }

                var empty_stars = 5 - opinion.rate;
                for(var i = 1; i <= empty_stars; i++) {
                    const star_rate = "<span class='star'>&#9733;</span>"
                    ratingDiv.insertAdjacentHTML('beforeend', star_rate);
                }
            });
        }
    });    
}

function get_complex_events(id, container) {
    var url_address = "http://localhost:8080/events/"+id;
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
        events = Object.values(response);

        events.forEach(event => {
            const eventDiv = document.createElement("div");
            eventDiv.classList.add("event");
            eventDiv.innerHTML = `<div class='event_image'><img src='events/${event.photo}'></div>
                                <div class='event_info_wrapper'>
                                    <div class='event_info_grey'>${event.startTime[2]}.${event.startTime[1]}.${event.startTime[0]} o ${event.startTime[3]}:${event.startTime[4]}</div>
                                    <div class='event_info_title'>${event.name}</div>
                                    <div class='event_info_grey'>${event.interested_people} osób zainteresowanych</div>
                                    <div class='event_button_wrapper'>
                                        <div class='event_button'>Zainteresowany/a</div>
                                        <a href='event.html?event=${event.sportObjectAddress.id}'><div class='event_button'>Więcej</div></a>
                                    </div>
                                </div>`;
            container.appendChild(eventDiv);
        });
    });    
}

function get_complex_total_rate(id, container) {
    
    var url_address = "http://localhost:8080/reviews/rates/"+id;
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
        ratings = Object.values(response);
        console.log(ratings);

        const bigRateDiv = document.createElement("div");
        bigRateDiv.classList.add("big_rate");
        var x = parseFloat(ratings[7]);
        bigRateDiv.innerHTML = `${x}`;
        container.appendChild(bigRateDiv);
    });    
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
            "id": complex[0],
            "name": complex[1],
            "description": complex[2],
            "category": complex[3].charAt(0).toUpperCase() + complex[3].slice(1).toLowerCase(),
            "surface": complex[4],
            "website": complex[5],
            "phoneNumber": complex[6].replace(/(.{3})/g, "$1 "),
            "address": {
                "id": complex[7].id,
                "street": complex[7].street,
                "postalCode": complex[7].postalCode.replace(/(\d{2})(\d{3})/, "$1-$2"),
                "buildingNumber": complex[7].buildingNumber,
                "apartmentNumber": complex[7].apartmentNumber,
                "city": complex[7].city
            },
            "photo": complex[8],
            "isOpen": complex[9],
            "isEventNow": complex[10],
            "isEventTomorrow": complex[11],
            "isOpen247": complex[12],
            "openingHours": complex[13]
        };        
    
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
                                    <div class='complex_opinie_container_rating'> \
                                        <div class='rating_bar_container'> \
                                            <label for='rating_bar_wrapper'>5</label> \
                                            <div class='rating_bar_wrapper'> \
                                                <div class='rating_bar' id='bar_5'></div> \
                                            </div> \
                                            <label for='rating_bar_wrapper'>4</label> \
                                            <div class='rating_bar_wrapper'> \
                                                <div class='rating_bar' id='bar_4'></div> \
                                            </div> \
                                            <label for='rating_bar_wrapper'>3</label> \
                                            <div class='rating_bar_wrapper'> \
                                                <div class='rating_bar' id='bar_3'></div> \
                                            </div> \
                                            <label for='rating_bar_wrapper'>2</label> \
                                            <div class='rating_bar_wrapper'> \
                                                <div class='rating_bar' id='bar_2'></div> \
                                            </div> \
                                            <label for='rating_bar_wrapper'>1</label> \
                                            <div class='rating_bar_wrapper'> \
                                                <div class='rating_bar' id='bar_1'></div> \
                                            </div> \
                                        </div> \
                                        <div class='total_rate'> \
                                        </div> \
                                    </div> \
                                    <div class='complex_opinie_container_opinions'></div> \
                                </div> \
                                <div class='complex_wrapper_menu_container complex_wydarzenia_container hidden'> \
                                    <div class='complex_wydarzenia_container_add'> \
                                        <a href='dodawanie_wydarzenia.html?obiekt="+formattedData.name+"'><div class='add_button'>+ Utwórz nowe wydarzenie</div></a> \
                                    </div> \
                                    <hr/> \
                                    <div class='complex_wydarzenia_container_all'></div> \
                                </div> \
                            </div>";

        var mapContainer = document.querySelector('.map_container');
        mapContainer.insertAdjacentHTML('beforeend', complex_wrapper);

        const opinionsContainer = document.getElementsByClassName('complex_opinie_container_opinions')[0];
        get_complex_opinions(id, opinionsContainer);

        const totalRateContainer = document.getElementsByClassName('total_rate')[0];
        get_complex_total_rate(id, totalRateContainer);

        const eventContainer = document.getElementsByClassName('complex_wydarzenia_container_all')[0];
        get_complex_events(id, eventContainer);
    });
}