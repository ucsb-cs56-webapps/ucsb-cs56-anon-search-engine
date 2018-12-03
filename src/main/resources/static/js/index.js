//index.js

$(document).ready(function() {
    $('.logo-container').click(function(event) {
        $('.selected').removeClass("selected");
        $(this).addClass("selected");
    });

    $('#searchbar').keypress(function(e){
        if(e.which == 13){ //Enter key pressed
            performSearch();
        }
    });

    $('#search-button').on('click', performSearch);
});


function performSearch() {
    console.log("Performing Search:");
    const engine = getEngineType();
    const query = document.getElementById('searchbar').value;

    // Used https://www.mkyong.com/spring-boot/spring-boot-ajax-example/ for reference

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/search",
        data: (engine + ":" + query),
        dataType: "text",
        cache: false,
        timeout: 600000,
        success: function (data) {
            didSuccessfullyGetData(data);
        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });
}

const didSuccessfullyGetData = (data) => {
    console.log(data);
}

function getEngineType() {
    const engine = $('.selected').attr('id');

    if (engine == "duckduckgo-search-button")
        return "DuckDuckGo";
    else if (engine == "google-search-button")
        return "Google";
    else
        return "Bing";
}
