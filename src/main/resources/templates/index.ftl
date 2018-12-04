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
 	</body>
</html>
