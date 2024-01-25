<html>

<head>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="logon-box-style.css">
    <link rel="stylesheet" href="panel-uzytkownika.css">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.2/jquery.min.js" integrity="sha512-tWHlutFnuG0C6nQRlpvrEhE4QpkG1nn2MOUMWmUeRePl4e3Aki0VB6W1v3oLjFtd0hVOtRQ9PHpSfN6u6/QXkQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

</head>

<body>

    <header>
        <div class="side_menu" onclick="openMenu()">
        </div>
        <div class="header_logo"></div>
        <div class="profile_icon"></div>
        <div class="profile_menu hidden">
            <div class="text name">Witaj</div>
            <div class="button" id="login" onclick="displayLoginBox()">Zaloguj się</div>
            <div class="button" id="register" onclick="displayRegisterBox()">Zarejestruj się</div>
            <div class="text">
                <a href="polityka.html">Polityka prywatności</a>
                <a href="warunki.html">Warunki usługi</a>
            </div>
        </div>
    </header>

    <div class="sidebar"></div>

    <div class="content">
        <div class="user-panel">

            <div class="profile-top">
                <div class="profile_icon"></div>
            </div>

            <div class="panels-top">
                <button id="btn-page1" class="tab-button active" onclick="changeContent('page1', this.id)">Ustawienia</button>
                <button id="btn-page2" class="tab-button" onclick="changeContent('page2', this.id)">Zaint. Wydarzenia</button>
                <button id="btn-page3" class="tab-button" onclick="changeContent('page3', this.id)">Stw. Wydarzenia</button>
                <button id="btn-page4" class="tab-button" style="display:none" onclick="changeContent('page4', this.id)">Moderator</button>
            </div>
            
            <script>
                var isAdmin = getCookie("isAdmin");

                if(isAdmin == "true") {
                    const btn4 = document.getElementById("btn-page4");
                    btn4.style.display = "block";
                }

                function changeContent(pageId, buttonId) {

                var pages = document.getElementsByClassName('page');
                for (var i = 0; i < pages.length; i++) {
                    pages[i].style.display = 'none';
                }

                var buttons = document.getElementsByClassName('tab-button');
                for (var i = 0; i < buttons.length; i++) {
                    buttons[i].classList.remove('active');
                }

                document.getElementById(pageId).style.display = 'block';
                document.getElementById(buttonId).classList.add('active');
            }

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
            </script>
            <div class="main-container">
                <div id="page1" class="page">
                    <input class="input" type="text" id="username" placeholder="Nazwa uzytkownika" value="Kamil"></input>
                    <input class="input" type="text" id="email" placeholder="Email" value="email@gmail.com"></input>
                    <input class="input" type="password" id="password" placeholder="Hasło" value="******************"></input>
                    <input class="input" type="password" id="password_new" placeholder="Powtórz nowe hasło"></input>
                    <button class="action-button">Zapisz</button>
                    <!-- <button class="action-button">Zgłoś błąd</button> -->
                </div>

                <div id="page2" class="page" style="display: none;">
                    <div id="content-wrapper">

                        <script>
                            var userID = getCookie('userId');

                            document.addEventListener('DOMContentLoaded', function() {
                                fetchEvents();
                            });
                        
                            function fetchEvents() {
                                fetch(`http://localhost:8080/events/interested/${userID}`)
                                    .then(response => response.json())
                                    .then(data => {
                                        displayEvents(data);
                                    });
                            }
                        
                            function displayEvents(events) {
                                const contentWrapper = document.getElementById('content-wrapper');
                                contentWrapper.innerHTML = '';
                        
                                events.forEach((event, index) => {
                                    const eventElement = createEventElement(event, index);
                                    contentWrapper.appendChild(eventElement);
                                });
                            }
                        
                            function createEventElement(event, index) {
                                const div = document.createElement('div');
                                div.className = 'content-item';
                                div.innerHTML = `
                                    <div class="content-header">
                                        <img src="https://www.gry-online.pl/i/h/22/431209879.jpg" alt="Event Image" class="content-image">
                                        <p class="content-date">${formatDate(event.startTime)}</p>
                                        <h3>${event.name}</h3>
                                        <h3 class="content-location">${event.sportObjectName}</h3>
                                        <p class="content-interest">${event.interested_people} osób zainteresowanych</p>
                                    </div>
                                    <div class="content-actions">
                                        <button class="btn-interest" onclick="toggleInterest(this)">Zainteresowany(a)</button>
                                        <button class="btn-more" onclick="loadEventDetails(${index})">Więcej</button>
                                    </div>
                                `;
                                return div;
                            }
                            
                            function loadEventDetails(eventId) {
                                let userID = getCookie('userId');
                                fetch(`http://localhost:8080/events/detailed/interested/${userID}`)
                                    .then(response => response.json())
                                    .then(data => {
                                        displayDetailedEvent(data[eventId]);
                                    });
                            }
                        
                            function displayDetailedEvent(event) {
                                const detailedEventHTML = `
                                    <div class="detailed-event">
                                        <button class="close-btn" onclick="closeDetailedView()">
                                            <img src="../Ikony/X.svg" alt="Close" />
                                        </button>

                                        <img src="https://www.gry-online.pl/i/h/22/431209879.jpg" alt="Event Image" class="detailed-event-image">
                                        <p class="detailed-event-name">${event.name}</p>
                                        <p class="detailed-event-date">${formatDate(event.startTime)} - ${formatDateEnd(event.endTime)}</p>
                                        <p class="detailed-event-location">${event.sportObjectName}</p>
                                        <p class="detailed-event-interest">${event.interestedPeople} osób zainteresowanych</p>
                                        <button class="btn-interest-detailed" onclick="toggleInterest(this)">Zainteresowany(a)</button>

                                        <div class="detailed-event-info-container">
                                            <div class="detailed-event-info">
                                                <p class="detailed-event-title-info">Szczegółowe informacje</p>

                                                <p class="detailed-event-creatorNickname-info">
                                                    <img src="${event.creatorAvatar}" alt="Creator Avatar" class="detailed-event-avatar-info">
                                                    <span class="detailed-event-creatorNickname-text">${event.creatorNickname} stworzył/a wydarzenie</span>
                                                </p>

                                                <p class="detailed-event-creatorNickname-info">
                                                    <img src="../Ikony/user.svg" alt="Creator Avatar" class="detailed-event-avatar-info">
                                                    <span class="detailed-event-creatorNickname-text">${event.interestedPeople} osób zainteresowanych</span>
                                                </p>

                                                <p class="detailed-event-creatorNickname-info">
                                                    <img src="../Ikony/gps.svg" alt="Creator Avatar" class="detailed-event-avatar-info">
                                                    <span class="detailed-event-creatorNickname-text">${event.sportObjectAddress.postalCode} ${event.sportObjectAddress.city} ${event.sportObjectAddress.street}</span>
                                                </p>

                                                <p class="detailed-event-creatorNickname-info">
                                                    <img src="../Ikony/clock.svg" alt="Creator Avatar" class="detailed-event-avatar-info">
                                                    <span class="detailed-event-creatorNickname-text">Czas trwania: ${event.duration.hours} godzin</span>
                                                </p>

                                                <p class="detailed-event-description-info">${event.description}</p>

                                            </div>
                                        </div>

                                    </div>
                                `;

                                const contentWrapper = document.getElementById('content-wrapper');
                                contentWrapper.innerHTML = detailedEventHTML;
                            }

                            function closeDetailedView() {
                                document.getElementById('content-wrapper').innerHTML = '';
                                fetchEvents();
                            }

                            function formatDate(startTime) {
                                return `${startTime[2]}.${startTime[1]}.${startTime[0]} o ${startTime[3]}:${String(startTime[4]).padStart(2, '0')}`;
                            }

                            function formatDateEnd(endTime) {
                                return `${endTime[3]}:${String(endTime[4]).padStart(2, '0')}`;
                            }

                            function toggleInterest(button) {
                            if (button.textContent === "Zainteresowany(a)") {
                                button.textContent = "Zainteresuj się";
                            } else {
                                button.textContent = "Zainteresowany(a)";
                            }
                        }
                        </script>
                    </div>
                        
                </div>
                
                <div id="page3" class="page" style="display: none;">
                   
                    <div id="created-content-wrapper">
                        <script>
                    
                            document.addEventListener('DOMContentLoaded', function() {
                                fetchCreatedEvents();
                            });
                    
                            function fetchCreatedEvents() {
                                let userID = getCookie('userId');
                                fetch(`http://localhost:8080/events/created/${userID}`)
                                    .then(response => response.json())
                                    .then(data => {
                                        displayCreatedEvents(data);
                                    });
                            }
                    
                            function displayCreatedEvents(events) {
                                const contentWrapper = document.getElementById('created-content-wrapper');
                                contentWrapper.innerHTML = '';
                    
                                events.forEach((event, index) => {
                                    const eventElement = createCreatedEventElement(event, index);
                                    contentWrapper.appendChild(eventElement);
                                });
                            }
                    
                            function createCreatedEventElement(event, index) {
                                const div = document.createElement('div');
                                div.className = 'created-content-item';
                                div.innerHTML = `
                                    <div class="created-content-header">
                                        <img src="https://www.gry-online.pl/i/h/22/431209879.jpg" alt="Event Image" class="created-content-image">
                                        <p class="created-content-date">${formatDate(event.startTime)}</p>
                                        <h3>${event.name}</h3>
                                        <h3 class="created-content-location">${event.sportObjectName}</h3>
                                        <p class="created-content-interest">${event.interested_people} osób zainteresowanych</p>
                                    </div>
                                    <div class="created-content-actions">
                                        <button class="created-btn-more" onclick="loadCreatedEventDetails(${index})">Edytuj</button>
                                    </div>
                                `;
                                return div;
                            }
                    
                            function loadCreatedEventDetails(eventId) {
                                fetch(`http://localhost:8080/events/detailed/created/${userID}`)
                                    .then(response => response.json())
                                    .then(data => {
                                        displayCreatedDetailedEvent(data[eventId]);
                                    });
                            }
                    
                            function displayCreatedDetailedEvent(event) {
                                const detailedEventHTML = `
                                    <div class="created-detailed-event">
                                        <button class="created-close-btn" onclick="closeCreatedDetailedView()">
                                            <img src="../Ikony/X.svg" alt="Close" />
                                        </button>
                    
                                        <img src="https://www.gry-online.pl/i/h/22/431209879.jpg" alt="Event Image" class="created-detailed-event-image">
                                        <p class="created-detailed-event-name">${event.name}</p>
                                        <p class="created-detailed-event-date">${formatDate(event.startTime)} - ${formatDateEnd(event.endTime)}</p>
                                        <p class="created-detailed-event-location">${event.sportObjectName}</p>
                                        <p class="created-detailed-event-interest">${event.interestedPeople} osób zainteresowanych</p>
                    
                                        <div class="created-detailed-event-info-container">
                                            <div class="created-detailed-event-info">
                                                <p class="created-detailed-event-title-info">Szczegółowe informacje</p>
                    
                                                <p class="created-detailed-event-creatorNickname-info">
                                                    <img src="${event.creatorAvatar}" alt="Creator Avatar" class="created-detailed-event-avatar-info">
                                                    <span class="created-detailed-event-creatorNickname-text">${event.creatorNickname} stworzył/a wydarzenie</span>
                                                </p>
                    
                                                <p class="created-detailed-event-creatorNickname-info">
                                                    <img src="../Ikony/user.svg" alt="Creator Avatar" class="created-detailed-event-avatar-info">
                                                    <span class="created-detailed-event-creatorNickname-text">${event.interestedPeople} osób zainteresowanych</span>
                                                </p>
                    
                                                <p class="created-detailed-event-creatorNickname-info">
                                                    <img src="../Ikony/gps.svg" alt="Creator Avatar" class="created-detailed-event-avatar-info">
                                                    <span class="created-detailed-event-creatorNickname-text">${event.sportObjectAddress.postalCode} ${event.sportObjectAddress.city} ${event.sportObjectAddress.street}</span>
                                                </p>
                    
                                                <p class="created-detailed-event-creatorNickname-info">
                                                    <img src="../Ikony/clock.svg" alt="Creator Avatar" class="created-detailed-event-avatar-info">
                                                    <span class="created-detailed-event-creatorNickname-text">Czas trwania: ${event.duration.hours} godzin</span>
                                                </p>
                    
                                                <p class="created-detailed-event-description-info">${event.description}</p>
                                            </div>
                                        </div>
                                    </div>
                                `;
                    
                                const contentWrapper = document.getElementById('created-content-wrapper');
                                contentWrapper.innerHTML = detailedEventHTML;
                            }
                    
                            function closeCreatedDetailedView() {
                                document.getElementById('created-content-wrapper').innerHTML = '';
                                fetchCreatedEvents();
                            }
                    
                            function formatDate(startTime) {
                                return `${startTime[2]}.${startTime[1]}.${startTime[0]} o ${startTime[3]}:${String(startTime[4]).padStart(2, '0')}`;
                            }
                    
                            function formatDateEnd(endTime) {
                                return `${endTime[3]}:${String(endTime[4]).padStart(2, '0')}`;
                            }
                        </script>
                    </div>
                </div>

                <div id="page4" class="page" style="display: none;">

                    <div class="panels-top-moderator">
                        <input class="search" placeholder="Wyszukaj">
                        <select id="moderator-select" class="moderator-select" onchange="changeContentModerator()">
                            <option value="moderatorPage1">Obiekty</option>
                            <option value="moderatorPage2">Zgłoszenia</option>
                        </select>

                        <div class="moderator-controls">
                            <button class="control-btn" onclick="previousPage()">
                                <img class="leftArrow" src="../Ikony/arrow.svg" alt="Previous" />
                            </button>
                            <span id="currentPage">1</span> z <span id="totalPages">10</span>
                            <button class="control-btn" onclick="nextPage()">
                                <img class="rightArrow" src="../Ikony/arrow.svg" alt="Next" />
                            </button>
                            <button class="control-btn" onclick="reloadContent()">
                            <img src="../Ikony/reload.svg" alt="Reload" />
                            </button>
                        </div>
                        
                    </div>
                    
                    <div id="moderator-content-area">
                        <div id="moderatorPage1" class="moderator-content-page">
                            <div id="dropdown-container">
                                <!-- Dropdowns will be dynamically inserted here -->
                            </div>

                            <script>
                                let currentPage = 0;
                                const pageSize = 7;
                                const totalPagesElement = document.getElementById('totalPages');
                                let totalPages = 0;
                                document.addEventListener('DOMContentLoaded', function() {
                                    fetchComplexes(currentPage);
                                });

                                function fetchComplexes(pageNumber) {
                                    fetch(`http://localhost:8080/sport-complexes/admin?pageNumber=${pageNumber}&pageSize=${pageSize}`)
                                        .then(response => response.json())
                                        .then(data => {
                                            const container = document.getElementById('dropdown-container');
                                            container.innerHTML = '';

                                            data.content.forEach(complex => {
                                                createDropdown(complex, container);
                                            });

                                            totalPages = data.totalPages;

                                            setUpEventListeners();
                                            updatePageDisplay(data.totalPages, pageNumber);
                                        });
                                }

                                function updatePageDisplay(totalPages, currentPage) {
                                    document.getElementById('totalPages').textContent = totalPages;
                                    document.getElementById('currentPage').textContent = currentPage + 1; // +1 because pages are usually 1-indexed in UI
                                }

                                function previousPage() {
                                    if (currentPage > 0) {
                                        currentPage--;
                                        fetchComplexes(currentPage);
                                    }
                                }

                                function nextPage() {
                                    if (currentPage < totalPages - 1) {
                                        currentPage++;
                                        fetchComplexes(currentPage);
                                    }
                                }

                                function reloadContent() {
                                    fetchComplexes(currentPage);
                                    document.getElementById('currentPage').textContent = currentPage + 1;
                                }

                                function createDropdown(complex, container) {
                                    const dropdown = document.createElement('div');
                                    dropdown.className = 'dropdown';

                                    const header = document.createElement('div');
                                    header.className = 'dropdown-header';

                                    const titleName = document.createElement('p');
                                    titleName.className = 'titleDrop';
                                    titleName.textContent = complex.name;

                                    const titleCategory = document.createElement('p');
                                    titleCategory.className = 'titleDrop';
                                    titleCategory.textContent = complex.category;

                                    const arrowBG = document.createElement('div');
                                    arrowBG.className = 'arrowBG';

                                    const img = document.createElement('img');
                                    img.src = '../Ikony/arrow.svg';
                                    img.alt = 'Expand';
                                    img.className = 'arrow';

                                    arrowBG.appendChild(img);
                                    header.appendChild(titleName);
                                    header.appendChild(titleCategory);
                                    header.appendChild(arrowBG);
                                    dropdown.appendChild(header);

                                    const content = document.createElement('div');
                                    content.className = 'dropdown-content';
                                    content.innerHTML = `
                                        <img src="Photos/${complex.photo}">

                                        <h1>Szczegóły</h1>
                                        <div class="info-row"><span class="info-label">Nazwa obiektu:</span><span class="info-value">${complex.name}</span></div>
                                        <div class="info-row"><span class="info-label">Nawierzchnia:</span><span class="info-value">${complex.surface}</span></div>
                                        <div class="info-row"><span class="info-label">Kategoria:</span><span class="info-value">${complex.category}</span></div>
                                        <div class="info-row"><span class="info-label">Strona internetowa:</span><span class="info-value">${getDisplayData(complex.website)}</span></div>
                                        <div class="info-row"><span class="info-label">Numer telefonu:</span><span class="info-value">${getDisplayData(complex.phoneNumber)}</span></div>

                                        <h1>Opis</h1>
                                        <div class="info-row"><span class="info-label">Opis:</span><span class="info-value">${complex.description}</span></div>

                                        <h1>Adres</h1>
                                        <div class="info-row"><span class="info-label">Miasto:</span><span class="info-value">${complex.address.city}</span></div>
                                        <div class="info-row"><span class="info-label">Kod pocztowy:</span><span class="info-value">${getDisplayData(complex.address.postalCode)}</span></div>
                                        <div class="info-row"><span class="info-label">Ulica:</span><span class="info-value">${getDisplayData(complex.address.street)}</span></div>
                                        <div class="info-row"><span class="info-label">Nr budynku:</span><span class="info-value">${getDisplayData(complex.address.buildingNumber)}</span></div>
                                        <div class="info-row"><span class="info-label">Nr lokalu:</span><span class="info-value">${getDisplayData(complex.address.apartmentNumber)}</span></div>

                                        <h1>Godziny otwarcia</h1>
                                        <div class="info-row"><span class="info-label">Poniedziałek:</span><span class="info-value">${getDisplayOpeningHours(complex.openingHours.monday, complex)}</span></div>
                                        <div class="info-row"><span class="info-label">Wtorek:</span><span class="info-value">${getDisplayOpeningHours(complex.openingHours.tuesday, complex)}</span></div>
                                        <div class="info-row"><span class="info-label">Środa:</span><span class="info-value">${getDisplayOpeningHours(complex.openingHours.wednesday, complex)}</span></div>
                                        <div class="info-row"><span class="info-label">Czwartek:</span><span class="info-value">${getDisplayOpeningHours(complex.openingHours.thursday, complex)}</span></div>
                                        <div class="info-row"><span class="info-label">Piątek:</span><span class="info-value">${getDisplayOpeningHours(complex.openingHours.friday, complex)}</span></div>
                                        <div class="info-row"><span class="info-label">Sobota:</span><span class="info-value">${getDisplayOpeningHours(complex.openingHours.saturday, complex)}</span></div>
                                        <div class="info-row"><span class="info-label">Niedziela:</span><span class="info-value">${getDisplayOpeningHours(complex.openingHours.sunday, complex)}</span></div>

                                        <button class="deleteButton">Usuń</button>
                                    `;
                                    dropdown.appendChild(content);

                                    updateTotalPages(totalPages);

                                    container.appendChild(dropdown);
                                }

                                function updateTotalPages(newTotalPages) {
                                    const totalPagesElement = document.getElementById('totalPages');
                                    totalPagesElement.textContent = newTotalPages;
                                }

                                function setUpEventListeners() {
                                    const arrows = document.querySelectorAll('.dropdown-header .arrowBG');
                                    arrows.forEach(arrow => {
                                        arrow.addEventListener('click', function() {
                                        const dropdownContent = this.parentNode.parentNode.querySelector('.dropdown-content');
                                        dropdownContent.style.display = dropdownContent.style.display === 'block' ? 'none' : 'block';
                                        this.classList.toggle('rotate');
                                });
                                });
                                }

                            </script>
                              
                        </div>
                        <div id="moderatorPage2" class="moderator-content-page" style="display:none;">
                            <div id="dropdown-container-approval">
                                <!-- Dropdowns will be dynamically inserted here -->
                            </div>

                            <script>
                                document.addEventListener('DOMContentLoaded', function() {
                                    fetchComplexesApproval(currentPage);
                                });

                                function fetchComplexesApproval(pageNumber) {
                                    fetch(`http://localhost:8080/sport-complexes/admin/awaiting-approval?pageNumber=${pageNumber}&pageSize=${pageSize}`)
                                        .then(response => response.json())
                                        .then(data => {
                                            const container = document.getElementById('dropdown-container-approval');
                                            container.innerHTML = '';

                                            data.content.forEach(complex => {
                                                createDropdownApproval(complex, container);
                                            });

                                            totalPages = data.totalPages;

                                            setUpEventListenersApproval();
                                            updatePageDisplayApproval(data.totalPages, pageNumber);
                                        });
                                }

                                function updatePageDisplayApproval(totalPages, currentPage) {
                                    document.getElementById('totalPages').textContent = totalPages;
                                    document.getElementById('currentPage').textContent = currentPage + 1;
                                }

                                function createDropdownApproval(complex, container) {
                                    const dropdown = document.createElement('div');
                                    dropdown.className = 'dropdown';

                                    const header = document.createElement('div');
                                    header.className = 'dropdown-header';

                                    const titleName = document.createElement('p');
                                    titleName.className = 'titleDrop';
                                    titleName.textContent = complex.name;

                                    const titleCategory = document.createElement('p');
                                    titleCategory.className = 'titleDrop';
                                    titleCategory.textContent = complex.category;

                                    const arrowBG = document.createElement('div');
                                    arrowBG.className = 'arrowBG';

                                    const img = document.createElement('img');
                                    img.src = '../Ikony/arrow.svg';
                                    img.alt = 'Expand';
                                    img.className = 'arrow';

                                    arrowBG.appendChild(img);
                                    header.appendChild(titleName);
                                    header.appendChild(titleCategory);
                                    header.appendChild(arrowBG);
                                    dropdown.appendChild(header);

                                    const content = document.createElement('div');
                                    content.className = 'dropdown-content';
                                    content.innerHTML = `
                                        <img src="Photos/${complex.photo}">

                                        <h1>Szczegóły</h1>
                                        <div class="info-row"><span class="info-label">Nazwa obiektu:</span><span class="info-value">${complex.name}</span></div>
                                        <div class="info-row"><span class="info-label">Nawierzchnia:</span><span class="info-value">${complex.surface}</span></div>
                                        <div class="info-row"><span class="info-label">Kategoria:</span><span class="info-value">${complex.category}</span></div>
                                        <div class="info-row"><span class="info-label">Strona internetowa:</span><span class="info-value">${getDisplayData(complex.website)}</span></div>
                                        <div class="info-row"><span class="info-label">Numer telefonu:</span><span class="info-value">${getDisplayData(complex.phoneNumber)}</span></div>

                                        <h1>Opis</h1>
                                        <div class="info-row"><span class="info-label">Opis:</span><span class="info-value">${complex.description}</span></div>

                                        <h1>Adres</h1>
                                        <div class="info-row"><span class="info-label">Miasto:</span><span class="info-value">${complex.address.city}</span></div>
                                        <div class="info-row"><span class="info-label">Kod pocztowy:</span><span class="info-value">${getDisplayData(complex.address.postalCode)}</span></div>
                                        <div class="info-row"><span class="info-label">Ulica:</span><span class="info-value">${getDisplayData(complex.address.street)}</span></div>
                                        <div class="info-row"><span class="info-label">Nr budynku:</span><span class="info-value">${getDisplayData(complex.address.buildingNumber)}</span></div>
                                        <div class="info-row"><span class="info-label">Nr lokalu:</span><span class="info-value">${getDisplayData(complex.address.apartmentNumber)}</span></div>

                                        <h1>Godziny otwarcia</h1>
                                        <div class="info-row"><span class="info-label">Poniedziałek:</span><span class="info-value">${getDisplayOpeningHours(complex.openingHours.monday, complex)}</span></div>
                                        <div class="info-row"><span class="info-label">Wtorek:</span><span class="info-value">${getDisplayOpeningHours(complex.openingHours.tuesday, complex)}</span></div>
                                        <div class="info-row"><span class="info-label">Środa:</span><span class="info-value">${getDisplayOpeningHours(complex.openingHours.wednesday, complex)}</span></div>
                                        <div class="info-row"><span class="info-label">Czwartek:</span><span class="info-value">${getDisplayOpeningHours(complex.openingHours.thursday, complex)}</span></div>
                                        <div class="info-row"><span class="info-label">Piątek:</span><span class="info-value">${getDisplayOpeningHours(complex.openingHours.friday, complex)}</span></div>
                                        <div class="info-row"><span class="info-label">Sobota:</span><span class="info-value">${getDisplayOpeningHours(complex.openingHours.saturda, complex)}</span></div>
                                        <div class="info-row"><span class="info-label">Niedziela:</span><span class="info-value">${getDisplayOpeningHours(complex.openingHours.sunday, complex)}</span></div>

                                        <button class="approveButton" onclick="approveComplex(${complex.id})">Zatwierdź</button>
                                    `;
                                    dropdown.appendChild(content);

                                    updateTotalPagesApproval(totalPages);

                                    container.appendChild(dropdown);
                                }

                                function approveComplex(complexId, complex) {
                                    
                                    console.log(complexId);
                                    fetch(`http://localhost:8080/sport-complexes/admin/approve/${complexId}`, {
                                        method: 'PATCH'
                                    })
                                    .then(response => {
                                        if (response.ok) {
                                            alert('Obiekt został zatwierdzony.');
                                            reloadContent();
                                        } else {
                                            alert('Wystąpił błąd podczas zatwierdzania obiektu.');
                                        }
                                    })
                                    .catch(error => {
                                        console.error('Error:', error);
                                        alert('Wystąpił błąd: ' + error);
                                    });
                                }

                                function getDisplayData(displayedData) {
                                    return displayedData ? displayedData : "Brak";
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

                                function updateTotalPagesApproval(newTotalPages) {
                                    const totalPagesElement = document.getElementById('totalPages');
                                    totalPagesElement.textContent = newTotalPages;
                                }

                                function setUpEventListenersApproval() {
                                    const arrows = document.querySelectorAll('.dropdown-header .arrowBG');
                                    arrows.forEach(arrow => {
                                        arrow.addEventListener('click', function() {
                                        const dropdownContent = this.parentNode.parentNode.querySelector('.dropdown-content');
                                        dropdownContent.style.display = dropdownContent.style.display === 'block' ? 'none' : 'block';
                                        this.classList.toggle('rotate');
                                });
                                });
                                }

                            </script>
                        </div>
                    </div>

                    <script>
                        let currentPage = 0;
                        let totalPages = 0;
                        const pageSize = 8;

                        function changeContentModerator() {
                            const selectedValue = document.getElementById('moderator-select').value;
                            currentPage = 0;

                            if (selectedValue === 'moderatorPage1') {
                                fetchComplexes(currentPage);
                            } else if (selectedValue === 'moderatorPage2') {
                                fetchComplexesApproval(currentPage);
                            }

                            const pages = document.getElementsByClassName('moderator-content-page');
                            for (let i = 0; i < pages.length; i++) {
                                pages[i].style.display = 'none';
                            }

                            document.getElementById(selectedValue).style.display = 'block';
                        }

                        function nextPage() {
                            const selectedValue = document.getElementById('moderator-select').value;
                            if (currentPage < totalPages - 1) {
                                currentPage++;
                                if (selectedValue === 'moderatorPage1') {
                                    fetchComplexes(currentPage);
                                } else if (selectedValue === 'moderatorPage2') {
                                    fetchComplexesApproval(currentPage);
                                }
                            }
                        }

                        function previousPage() {
                            const selectedValue = document.getElementById('moderator-select').value;
                            if (currentPage > 0) {
                                currentPage--;
                                if (selectedValue === 'moderatorPage1') {
                                    fetchComplexes(currentPage);
                                } else if (selectedValue === 'moderatorPage2') {
                                    fetchComplexesApproval(currentPage);
                                }
                            }
                        }

                        function reloadContent() {
                            const selectedValue = document.getElementById('moderator-select').value;

                            if (selectedValue === 'moderatorPage1') {
                                fetchComplexes(currentPage);
                            } else if (selectedValue === 'moderatorPage2') {
                                fetchComplexesApproval(currentPage);
                            }
                        }

                        document.addEventListener('DOMContentLoaded', function() {
                            changeContentModerator();
                        });
                    </script>

                    
                </div>
            
                <div class="footer">
                    <a href="index.php">Wróć do strony głównej</a>
                </div>
            </div>

        </div>
    </div>
   
    <script src="script.js" type="application/javascript"></script>
    <script src="profile_popup.js" type="application/javascript"></script>
</body>

</html>