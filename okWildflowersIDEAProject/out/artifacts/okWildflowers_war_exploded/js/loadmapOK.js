var map;
var place;
var autocomplete;
var infowindow = new google.maps.InfoWindow();

function initialization() {
    showAllObservations();
    initAutocomplete();
}

function showAllObservations() {
    $.ajax({
        url: 'HttpServlet',
        type: 'POST',
        data: { "tab_id": "1"},
        success: function(observations) {
            mapInitialization(observations);
        },
        error: function(xhr, status, error) {
            alert("An AJAX error occured: " + status + "\nError: " + error);
        }
    });
}

function mapInitialization(observations) {
    var mapOptions = {
        mapTypeId : google.maps.MapTypeId.ROADMAP, // Set the type of Map
    };
    console.log(observations);
console.log("inside mapInitialization")
    // Render the map within the empty div
    map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);

    map.setMapTypeId('terrain');

    var bounds = new google.maps.LatLngBounds();

    $.each(observations, function(i, e) {
        var long = Number(e['longitude']);
        var lat = Number(e['latitude']);
        var latlng = new google.maps.LatLng(lat, long);

        bounds.extend(latlng);

        // Create the infoWindow content (simplified to just county)
        var contentStr = '<h4>Report Details</h4><hr>';
        contentStr += '<p><b>' + 'county' + ':</b>&nbsp' + e['county'] + '</p>';
        contentStr += '<p><b>' + 'report type' + ':</b>&nbsp' + e['report_type'] + '</p>';

        var marker = new google.maps.Marker({ // Set the marker
            position : latlng, // Position marker to coordinates
            map : map, // assign the market to our map variable
            customInfo: contentStr,
            icon: 'img/fire-station-15.svg'
        });

        // Add a Click Listener to the marker (creates infowindow content using contentStr (customInfo)
        google.maps.event.addListener(marker, 'click', function() {
            // use 'customInfo' to customize infoWindow
            infowindow.setContent(marker['customInfo']);
            infowindow.open(map, marker); // Open InfoWindow
        });

    });

    map.fitBounds (bounds);

}

function initAutocomplete() {
    // Create the autocomplete object
    autocomplete = new google.maps.places.Autocomplete(document
        .getElementById('autocomplete'));

    // When the user selects an address from the dropdown, show the place selected
    autocomplete.addListener('place_changed', onPlaceChanged);
}

function onPlaceChanged() {
    place = autocomplete.getPlace();
    //QUESTION #3: Re-center the map using the autocompleted place
    map.fitBounds(place.geometry.viewport);
}


//Execute our 'initialization' function once the page has loaded.
google.maps.event.addDomListener(window, 'load', initialization);