<html>

<head>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="logon-box-style.css">
    <link rel="stylesheet" href="dodawanie_obiektu.css">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.2/jquery.min.js" integrity="sha512-tWHlutFnuG0C6nQRlpvrEhE4QpkG1nn2MOUMWmUeRePl4e3Aki0VB6W1v3oLjFtd0hVOtRQ9PHpSfN6u6/QXkQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

</head>

<body>

    <header>
        <div class="side_menu"></div>
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
        <div class="add-object-panel">

            <div class="title">
                <p>Dodaj wydarzenie</p>
            </div>

            <div class="main-container">

                <div id="add-sport-complex" class="page">
                    <div id="image-upload-container" class="image-upload-container">
                        <div id="image-preview" class="image-preview"></div>
                        <input type="file" id="complex-photo" class="input-file" accept="image/*" onchange="previewImage()">
                        <label for="complex-photo" class="upload-button">+ Dodaj zdjęcie (opcjonalne)</label>
                    </div>
                    
                    <p class="title-main">Szczegóły</p>
                    <input class="input" type="text" id="event-name" placeholder="Nazwa wydarzenia" required>
                    <div class="input_container">
                        <div class="form-group">
                            <label for="start-date">Data rozpoczęcia:</label>
                            <input class="input_half" type="date" id="start-date" placeholder="Data rozpoczęcia" required>
                        </div>
                        <div class="form-group">
                            <label for="end-date">Data zakończenia:</label>
                            <input class="input_half" type="date" id="end-date" placeholder="Data zakończenia" required>
                        </div>
                        <div class="form-group">
                            <label for="start-hour">Godzina rozpoczęcia:</label>
                            <input class="input_half" type="time" id="start-hour" placeholder="Godzina rozpoczęcia" required>
                        </div>
                        <div class="form-group">
                            <label for="end-hour">Godzina zakończenia:</label>
                            <input class="input_half" type="time" id="end-hour" placeholder="Godzina zakończenia" required>
                        </div>
                    </div>
                    <input class="input_text" type="text" id="event-description" placeholder="Opis" required>

                    
                    <button class="action-button" onclick="addEvent()">Dodaj wydarzenie</button>
                </div>
                
                <script>
                    function addEvent() {
                        if (!isFormValid()) {
                            return; // Stop the function if validation fails
                        }

                        function getCookie(cookieName) {
                            const cookiesArray = document.cookie.split('; ');

                            for (let i = 0; i < cookiesArray.length; i++) {
                                const cookie = cookiesArray[i];
                                const [name, value] = cookie.split('=');

                                if (name === cookieName) {
                                    return decodeURIComponent(value);
                                }
                            }
                            return null;
                        }
                        
                        let startDate = getStringInputValue('start-date');
                        let endDate = getStringInputValue('end-date');
                        let startHour = getStringInputValue('start-hour')+":00";
                        let endHour = getStringInputValue('end-hour')+":00";
                        
                        let startTime = startDate+"T"+startHour;
                        let endTime = endDate+"T"+endHour;
                        console.log(startTime);

                        var currentUrl = window.location.href;
                        var urlParams = new URLSearchParams(window.location.search);
                        var obiektValue = urlParams.get('obiekt');
                        console.log(startDate, endDate, startTime, endTime, obiektValue);

                        const data = {
                            creatorId: getCookie("userId"),
                            name: getStringInputValue('event-name'),
                            description: getStringInputValue('event-description'),
                            startTime: startTime,
                            endtime: endTime,
                            sportComplexId: obiektValue
                        };

                        console.log('Sending POST request with data:', data);
                
                        fetch('http://localhost:8080/events', {
                            method: 'POST',
                            headers: {
                                'Content-Type': 'application/json',
                            },
                            body: JSON.stringify(data)
                        })
                        .then(response => response.json())
                        .then(data => {
                            console.log('Success:', data);
                        })
                        .catch((error) => {
                            console.error('Error:', error);
                        });

                    }

                    function isFormValid() {
                        const requiredFields = [
                            { id: 'event-name', name: 'Nazwa wydarzenia' },
                            { id: 'event-description', name: 'Opis' },
                            { id: 'start-date', name: 'Data rozpoczęcia' },
                            { id: 'end-date', name: 'Data zakończenia' },
                            { id: 'start-hour', name: 'Godzina rozpoczęcia' },
                            { id: 'end-hour', name: 'Godzina zakończenia' }
                        ];

                        let missingFields = [];

                        requiredFields.forEach(field => {
                            const inputField = document.getElementById(field.id);
                            if (!inputField || inputField.value.trim() === '') {
                                missingFields.push("\n" +field.name);
                            }
                        });

                        if (missingFields.length > 0) {
                            alert('Proszę wypełnić wymagane pola: ' + missingFields.join(', '));
                            return false;
                        }

                        return true;
                    }

                    //Change the value of null if needed to change the inputs where nothing is inserted
                    function getStringInputValue(elementId, defaultValue = null) {

                        const value = document.getElementById(elementId).value.trim();
                        const element = document.getElementById(elementId);

                        if (element.type === 'file') {
                            // For file inputs, return the file name
                            return element.files.length > 0 ? element.files[0].name : defaultValue;
                        }

                        return value === '' ? defaultValue : value;
                    }

                    function getNumberInputValue(elementId, defaultValue = 0) {
                        const value = parseFloat(document.getElementById(elementId).value);
                        return isNaN(value) ? defaultValue : value;
                    }


                    function previewImage() {
                        var preview = document.getElementById('image-preview');
                        var file = document.getElementById('complex-photo').files[0];
                        var reader = new FileReader();

                        reader.onloadend = function() {
                            preview.style.backgroundImage = `url('${reader.result}')`;
                        }

                        if (file) {
                            reader.readAsDataURL(file);
                        } else {
                            preview.style.backgroundImage = "";
                        }
                    }

                </script>
                
            
                <div class="footer">
                    <a href="index.php">Wróć do strony głównej</a>
                </div>
            </div>

        </div>
    </div>

    <script src="script.js" type="application/javascript"></script>
</body>

</html>