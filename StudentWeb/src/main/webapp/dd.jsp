<!DOCTYPE html>
<html>

<head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">

    <link href="https://google-developers.appspot.com/maps/documentation/javascript/examples/default.css"
          rel="stylesheet">
<%--  <script src="https://maps.googleapis.com/maps/api/js"></script>--%>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyClXJf5-EtIhPI55slcfsgOdT6KLPbt0WI&callback=loadMap"
            async defer></script>





    <script>
        function loadMap() {

            var mapOptions = {
                center: new google.maps.LatLng(28.4129951, 77.0440171),
                zoom: 12,
                panControl: true,
                zoomControl: true,
               // scaleControl: true,
                mapTypeControl: true,
                streetViewControl: true,
                overviewMapControl: true,
                rotateControl: true,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            }
            var map = new google.maps.Map(document.getElementById("sample"), mapOptions);
            var infowindow = new google.maps.InfoWindow;

            var marker = new google.maps.Marker({
                position: new google.maps.LatLng(28.4129951, 77.0440171),
                map: map,
                draggable: true,
                animation: google.maps.Animation.Drop
            });

            google.maps.event.addListener(marker, 'click', function () {
                infowindow.setContent("Decipher Zone, Spaze It Park, gurugram");
                infowindow.open(map, marker);

            });


            var geocoder = new google.maps.Geocoder;
            google.maps.event.addListener(map, 'click', function (event) {
                document.getElementById('latclicked').innerHTML = event.latLng.lat();
                document.getElementById('longclicked').innerHTML = event.latLng.lng();

                var latlng = new google.maps.LatLng(event.latLng.lat(), event.latLng.lng());
                geocoder.geocode({'latLng': latlng}, function (results, status) {
                    window.alert(status);
                    if (status === google.maps.GeocoderStatus.OK) {
                        window.alert('No results');
                        if (results[0]) {
                            window.alert('No');
                            document.getElementById('longclicked').innerHTML = event.latlng.lng();
                            var marker = new google.maps.Marker({
                                position: latlng, map: map
                            });
                            infowindow.setContent(results[0].formatted_address);
                            infowindow.open(map, marker);

                            alert("Location: " + results[0].formatted_address);
                            document.getElementById('loc').innerHTML = results[0].formatted_address;
                        }
                    }

                });
            });
        }


        /* google.maps.event.addDomListener(window, 'load', loadMap);*/


    </script>

</head>

<body onload="loadMap()">
<div id="sample" style="width:1280px; height:600px;"></div>
<div id="loc">address :-</div>
<div id="latclicked"></div>
<div id="longclicked"></div>

</body>

</html>