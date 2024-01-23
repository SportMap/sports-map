<html>

<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="complex_wrapper.css">
    <link rel="stylesheet" href="logon-box-style.css">
    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.9.4/dist/leaflet.css"
        integrity="sha256-p4NxAoJBhIIN+hmNHrzRCf9tD/miZyoHS5obTRR9BMY=" crossorigin="" />
    <script src="https://unpkg.com/leaflet@1.9.4/dist/leaflet.js"
        integrity="sha256-20nQCchB9co0qIjJZRGuk2/Z9VM+kNiyxNV1lvTlZBo=" crossorigin="">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.2/jquery.min.js" integrity="sha512-tWHlutFnuG0C6nQRlpvrEhE4QpkG1nn2MOUMWmUeRePl4e3Aki0VB6W1v3oLjFtd0hVOtRQ9PHpSfN6u6/QXkQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="sidebar_category.js" type="application/javascript"></script>
</head>

<body>

    <header>
        <div class="side_menu" onclick="openMenu()">
            <div class="beam animate"></div>
            <div class="beam animate"></div>
            <div class="beam-top hidden animate"></div>
            <div class="beam-bottom hidden animate"></div>
            <div class="short_beam animate"></div>
        </div>
        <div class="header_logo"></div>
        <div class="profile_icon"></div>
        <div class="profile_menu hidden">
            <div class="text name">Witaj</div>
            <div class="button" id="login" onclick="displayLoginBox()">Zaloguj się</div>
            <div class="button" id="register" onclick="displayRegisterBox()">Zarejestruj się</div>
            <div class="text">
                <a href="polityka.html" id='insertBefore'>Polityka prywatności</a>
                <a href="warunki.html">Warunki usługi</a>
            </div>
        </div>
    </header>

    <div id="successMessage">Zalogowano pomyślnie!</div>
    <div id="successMessageReg">Zarejestrowano pomyślnie!</div>
    <div class="map_container">
        <div id="map" class="map"></div>
    </div>
    <div class="sidebar">
        <div class="sidebar_category_container"></div>
        <div class="sidebar_category_container_bar"></div>
        <div class="sidebar_footer">
            <a href="https://facebook.com"><img src="facebook.png" class="img" alt="facebook"></a>
            <a href="https://instagram.com"><img src="instagram.png" class="img" alt="instagram"></a>
        </div>
    </div>

    <script src="script.js" type="application/javascript"></script>

    <div class="logon-container hidden">
        <div class="logon-avatar-background">
            <div class="logon-avatar"></div>
        </div>
        <input type="text" placeholder="Email / Nazwa użytkownika" class="logon-container-input" id="username">
        <input type="password" placeholder="Hasło" class="logon-container-input" id="password">
        <div class='remember-container'>
            <div class="radio">
                <input type='radio' id='remember_me'>
                <label for='remember_me'>Zapamiętaj mnie</label>
            </div>
            <a href="index.php" class="fixed">Zapomniałeś/aś hasła?</a>
        </div>
        <div class="logon-container-button" onclick="login()">Zaloguj</div>
        <div class="register-text-wrapper">
            <a>Nie masz konta?</a>
        </div>
        <div class="logon-container-button" onclick="goToRegisterBox()">Zarejestruj się</div>
    </div>

    <div class="logon-container register-container hidden">
        <div class="logon-avatar-background">
            <div class="logon-avatar"></div>
        </div>
        <input type="text" placeholder="Nazwa użytkownika" class="logon-container-input" id="username_reg" required>
        <input type="email" placeholder="Email" class="logon-container-input" id="email">
        <input type="email" placeholder="Powtórz email" class="logon-container-input" id="email_repeat">
        <input type="password" placeholder="Hasło" class="logon-container-input" id="password_reg">
        <input type="password" placeholder="Powtórz hasło" class="logon-container-input" id="password_reg_repeat">
        <div class='remember-container'>
            <div class="radio">
                <input type='radio' id='accept_terms'>
                <label for='accept_terms'>Akceptuję ogólne <a href="warunki.html">warunki użytkownika</a> i <a href="polityka.html">politykę prywatności</a></label>
            </div>
        </div>
        <div class="logon-container-button" onclick="register()">Zarejestruj się</div>
        <div class="register-text-wrapper">
            <a>Masz już konto?</a>
        </div>
        <div class="logon-container-button" onclick="goToLoginBox()">Zaloguj się</div>
    </div>

    
    <script src="login_register_engine.js" type="application/javascript"></script>
    <script src="profile_popup.js" type="application/javascript"></script>
    <script src="complex_wrapper_engine.js" type="application/javascript"></script>
</body>

</html>