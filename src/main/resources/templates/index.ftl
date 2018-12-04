<!DOCTYPE html>
<html>
	<head>
		<title>Welcome to Anonymous Searcher!</title>
   		<#include "head.ftl" />
 	</head>
	<body>
		<div class="body-container">
			<div id="title-text" class="flex-column">
	   			<h1 id="title">Anonymous Search Engine</h1>
	  			<h5 id="subtitle">Search the web anonymously by making the network requests through a third party that obscures your requests.</h5>
			</div>
			<div id="search-section" class="flex-row">
				<input type="text" id="searchbar" placeholder="Enter Search Here"></input>
				<button id="search-button">Search</button>
			</div>
			<div id="engine-buttons" class="flex-row">
				<div id="google-search-button" class="logo-container clickable selected"><img class="logo" src="/assets/google_logo.png"></div>
				<div id="duckduckgo-search-button" class="logo-container clickable"><img class="logo" src="/assets/ddg_logo.png"></div>
				<div id="bing-search-button" class="logo-container clickable"><img class="logo" src="/assets/bing_logo.png"></div>
			</div>
		</div>

                <div class="result-container" style="display: none">
                        <div id="result-header" class="flex-row">
                                <div id="back-to-index" class="clickable">
                                        <h1>ASE</h1>
                                </div>
                                <input type="text" id="searchbar-result" placeholder="Enter Search Here"></input>
                                <button id="search-button-result">Search</button>
                                <div id="engine-buttons-result" class="flex-row">
                                        <div id="google-search-button-result" class="logo-container-result clickable selected">
                                                <img class="logo" src="/assets/google_logo.png">
                                        </div>
                                        <div id="duckduckgo-search-button-result" class="logo-container-result clickable">
                                                <img class="logo" src="/assets/ddg_logo.png">
                                        </div>
                                        <div id="bing-search-button-result" class="logo-container-result clickable">
                                                <img class="logo" src="/assets/bing_logo.png">
                                        </div>
                                </div>
                        </div>
                        <div id="result-list">
                        </div>
                </div>
        </body>

</html>
