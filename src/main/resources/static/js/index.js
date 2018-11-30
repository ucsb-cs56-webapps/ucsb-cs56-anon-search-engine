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
	// TODO: handle {"", "\", "\\", ...} for query
    console.log("Performing Search:");
    const engine = getEngineType();
    const query = document.getElementById('searchbar').value;

    var url = "/search/" + engine + "/" + query;
   	var xmlhttp = new XMLHttpRequest();
   	
   	xmlhttp.onreadystatechange = function(){
   	    if (xmlhttp.readyState == XMLHttpRequest.DONE){
   	    	if (xmlhttp.status == 200){
   	    		console.log(this.responseText);
   	    	}
   	   		else {
   	    		alert('Something went wrong!');
   	    	}
   		}
   	};

   	xmlhttp.open("POST", url, true);
   	xmlhttp.send();
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
