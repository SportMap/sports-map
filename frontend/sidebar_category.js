document.addEventListener('DOMContentLoaded', function () {
    var settings = {
        'cache': false,
        'dataType': "json", // użyj "json" zamiast "jsonp" w przypadku CORS
        "async": true,
        "crossDomain": true,
        "url": "http://localhost:8080/sport-complexes/categories",
        "method": "GET",
        "xhrFields": {
            "withCredentials": true  // dla obsługi cookies i innych danych uwierzytelniających
        },
        "headers": {
            "Content-Type": "application/json",
        }
    };
    
    $.ajax(settings).done(function (response) {
        categories = Object.values(response);
        for (var i = 0; i < categories.length; i++){
            var cat = categories[i].category.charAt(0).toUpperCase() + categories[i].category.slice(1).toLowerCase().replace(/_/g, ' ');
            var cat_img = categories[i].category.toLowerCase()+".png";
            var category_wrapper = "<div class='category_wrapper'><img src='categories/"+cat_img+"' alt='image'><k>"+cat+"</k></div>";
            var category_container = document.querySelector('.sidebar_category_container');
            category_container.insertAdjacentHTML('beforeend', category_wrapper);
        }
    });
});