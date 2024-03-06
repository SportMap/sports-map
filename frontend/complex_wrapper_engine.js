var mapContainer = document.getElementsByClassName('map')[0];
newRating;

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

function getDisplayOpeningHours(dayHours, complex) {
    if (complex.isOpen247) {
        return "Otwarte 24/7";
    }
    if (!dayHours) {
        return "Zamknięte";
    }

    const openTime = dayHours.openTime;
    const closeTime = dayHours.closeTime;

    const formattedOpenTime = `${openTime[0].toString().padStart(2, '0')}:${openTime[1].toString().padStart(2, '0')}`;
    const formattedCloseTime = `${closeTime[0].toString().padStart(2, '0')}:${closeTime[1].toString().padStart(2, '0')}`;

    return `${formattedOpenTime} - ${formattedCloseTime}`;
}

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

function addNewOpinion(complexId) {
    var userId = getCookie('userId');
    var rate = newRating;
    var sportComplexId = complexId;
    var content = document.getElementById('new_opinion_content').value;

    const data = {
        userId: parseInt(userId, 10),
        rate: rate,
        content: content,
        sportComplexId: sportComplexId
    };

    console.log('Sending POST request with data:', data);

    fetch('http://localhost:8080/reviews', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);
        document.getElementById('successMessageOpinion').style.display = 'block';
        setTimeout(() => {
            document.getElementById('successMessageOpinion').style.display = 'none';
        }, 2000);
    })
    .catch((error) => {
        console.error('Error:', error);
    });
}

function set_stars(id) {
    const stars = document.getElementsByClassName('rating_star');
    for(var i = 0; i < id; i++) {
        stars[i].classList.add("activeStar");
    }
    newRating=id;
}

function print_complex_opinion_input(container, complexId) {
    var username = getCookie("username");
    var currentDate = new Date();
    var year = currentDate.getFullYear();
    var month = currentDate.getMonth() + 1;
    var day = currentDate.getDate(); 
    var today = day+"-"+month+"-"+year;

    const opinionDiv = document.createElement("div");
                opinionDiv.classList.add("opinion");
                opinionDiv.innerHTML = `<div class='opinion_rate'>
                                            <div class='opinion_rate_avatar'><img src='users/avatars/'></div>
                                            <div class='opinion_rate_rating'>
                                                <nick>${username}</nick>
                                                <date>${today}</date>
                                                <div class='complex_rating' id='opinionRating0'>
                                                    <div class="rating-container">
                                                        <span class="star rating_star" data-rating="1" onclick='set_stars(1)'>&#9733;</span>
                                                        <span class="star rating_star" data-rating="2" onclick='set_stars(2)'>&#9733;</span>
                                                        <span class="star rating_star" data-rating="3" onclick='set_stars(3)'>&#9733;</span>
                                                        <span class="star rating_star" data-rating="4" onclick='set_stars(4)'>&#9733;</span>
                                                        <span class="star rating_star" data-rating="5" onclick='set_stars(5)'>&#9733;</span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <textarea type='text' maxlength='254' class='opinion_comment' style=' width: 100%' placeholder='Komentarz' id='new_opinion_content'></textarea>
                                        <div class='popup-button' style='margin-top: 13px;' onclick='addNewOpinion(${complexId})'>Zapisz</div>`;
    container.appendChild(opinionDiv);
}

function join_event(eventId) {
    if(getCookie('userId') != null) {
        var userId = parseInt(getCookie('userId'), 10);
        const data = {
            userId: userId,
            eventId: eventId
        };
    
        console.log('Sending POST request with data:', data);
    
        fetch('http://localhost:8080/events/join', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data)
        })
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
            var eventButton = document.getElementById('event_button_x');
            eventButton.innerHTML = "Dołączono!";
        })
        .catch((error) => {
            console.error('Error:', error);
        });
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
            var x = 0;
            opinions.forEach(opinion => {
                x++;
                const opinionDiv = document.createElement("div");
                opinionDiv.classList.add("opinion");
                opinionDiv.innerHTML = `<div class='opinion_rate'>
                                            <div class='opinion_rate_avatar'><img src='users/avatars/${opinion.avatar}'></div>
                                            <div class='opinion_rate_rating'>
                                                <nick>${opinion.nickname}</nick>
                                                <date>${opinion.date[2]}.${opinion.date[1]}.${opinion.date[0]}</date>
                                                <div class='complex_rating' id='opinionRating${x}'></div>
                                            </div>
                                        </div>
                                        <div class='opinion_comment'>${opinion.content}</div>`;
                container.appendChild(opinionDiv);

                var ratingDiv = document.getElementById('opinionRating'+x);
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
                                        <div class='event_button' onclick='join_event(${event.id})' id='event_button_x'>Zainteresowany/a</div>
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


        for(var i = 2; i < 7; i++) {
            let perc = (ratings[i]/ratings[1])*100;
            console.log(perc);
            let y = 7-i;
            let boxId = "bar_"+y;
            let box = document.getElementById(boxId);
            let perc_txt = perc.toString() + "%";
            console.log(perc_txt);
            box.style.width = perc_txt;
            box.style.borderRadius = "5px";
            box.style.backgroundColor = "#F8B84E";
            box.style.height = "100%";
        }
    });    
}

function get_complex_total_rate_bar(id, container, num) {
    
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

        let perc = (ratings[num]/ratings[1])*100;
        container.style.width = `${perc}%`;
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
        console.log(formattedData.openingHours);
        var complex_wrapper = "<div class='complex_wrapper'> \
                                <div class='complex_wrapper_img'> \
                                    <img src="+formattedData.photo+"'../photos/zdjecia/'> \
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
                                    <div class='main_info_opening_hours_container'><img src='clock.svg'>";

        if(formattedData.isOpen247 == true) {
            complex_wrapper = complex_wrapper + "<div class='main_info_opening_hours'><g> Otwarte 24/7</g></div>";
        }
        else {
            complex_wrapper = complex_wrapper + "<div class='main_info_opening_hours'><g> Poniedziałek: "+getDisplayOpeningHours(formattedData.openingHours.monday, formattedData)+"</g> \
                                    <g>Wtorek: "+getDisplayOpeningHours(formattedData.openingHours.tuesday, formattedData)+"</g> \
                                    <g>Środa: "+getDisplayOpeningHours(formattedData.openingHours.wednesday, formattedData)+"</g> \
                                    <g>Czwartek: "+getDisplayOpeningHours(formattedData.openingHours.thursday, formattedData)+"</g> \
                                    <g>Piątek: "+getDisplayOpeningHours(formattedData.openingHours.friday, formattedData)+"</g> \
                                    <g>Sobota: "+getDisplayOpeningHours(formattedData.openingHours.saturday, formattedData)+"</g> \
                                    <g>Niedziela: "+getDisplayOpeningHours(formattedData.openingHours.sunday, formattedData)+"</g> \
                                </div> ";
        }
                                        
        complex_wrapper = complex_wrapper + "</div><div class='main_info'><img src='info.svg'>"+formattedData.category+", "+isopennow+"</div> \
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
                                <div class='complex_wrapper_menu_container complex_wydarzenia_container hidden'>";
        if(getCookie("userId") != null) {
            complex_wrapper = complex_wrapper + "<div class='complex_wydarzenia_container_add'> \
                                                    <a href="+formattedData.id+"'add_event.html?obiekt='><div class='add_button'>+ Utwórz nowe wydarzenie</div></a> \
                                                </div>";
        }
                                    
        complex_wrapper = complex_wrapper + "<hr/> \
                                    <div class='complex_wydarzenia_container_all'></div> \
                                </div> \
                            </div>";

        var mapContainer = document.querySelector('.map_container');
        mapContainer.insertAdjacentHTML('beforeend', complex_wrapper);

        const opinionsContainer = document.getElementsByClassName('complex_opinie_container_opinions')[0];
        if(getCookie('userId') != null) {
            print_complex_opinion_input(opinionsContainer, formattedData.id);
        }
        get_complex_opinions(id, opinionsContainer);

        const totalRateContainer = document.getElementsByClassName('total_rate')[0];
        get_complex_total_rate(id, totalRateContainer);

        const eventContainer = document.getElementsByClassName('complex_wydarzenia_container_all')[0];
        get_complex_events(id, eventContainer);

        for(var i = 2; i < 7; i++) {
            let y = 7-i;
            let boxId = "bar_"+y;
            var box = document.getElementById(boxId);
            get_complex_total_rate_bar(id, box, i);
        }
    });

}