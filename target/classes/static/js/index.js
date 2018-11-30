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
    console.log(engine);
    console.log(query);
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
