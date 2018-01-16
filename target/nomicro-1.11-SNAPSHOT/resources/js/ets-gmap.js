var gmap;

//Map options
var showMetroLines = true; //If true gmap will show polylines 
var showStationImage = true; //If true a photo of station will be shown in station details panel

//DOM ready here
(function() {
    initMap();
})();





function initMap(){
    //Custom ETS GMap
    var etsMapType = new google.maps.StyledMapType(
        [{"elementType":"geometry","stylers":[{"color":"#ebe3cd"}]},{"elementType":"labels.text.fill","stylers":[{"color":"#523735"}]},{"elementType":"labels.text.stroke","stylers":[{"color":"#f5f1e6"}]},{"featureType":"administrative","elementType":"geometry","stylers":[{"visibility":"off"}]},{"featureType":"administrative","elementType":"geometry.stroke","stylers":[{"color":"#c9b2a6"}]},{"featureType":"administrative.land_parcel","elementType":"geometry.stroke","stylers":[{"color":"#dcd2be"}]},{"featureType":"administrative.land_parcel","elementType":"labels","stylers":[{"visibility":"off"}]},{"featureType":"administrative.land_parcel","elementType":"labels.text.fill","stylers":[{"color":"#ae9e90"}]},{"featureType":"landscape.natural","elementType":"geometry","stylers":[{"color":"#dfd2ae"}]},{"featureType":"poi","stylers":[{"visibility":"off"}]},{"featureType":"poi","elementType":"geometry","stylers":[{"color":"#dfd2ae"}]},{"featureType":"poi","elementType":"labels.text","stylers":[{"visibility":"off"}]},{"featureType":"poi","elementType":"labels.text.fill","stylers":[{"color":"#93817c"}]},{"featureType":"poi.park","elementType":"geometry.fill","stylers":[{"color":"#a5b076"}]},{"featureType":"poi.park","elementType":"labels.text.fill","stylers":[{"color":"#447530"}]},{"featureType":"road","elementType":"geometry","stylers":[{"color":"#f5f1e6"}]},{"featureType":"road","elementType":"labels.icon","stylers":[{"visibility":"off"}]},{"featureType":"road.arterial","elementType":"geometry","stylers":[{"color":"#fdfcf8"}]},{"featureType":"road.arterial","elementType":"labels","stylers":[{"visibility":"on"}]},{"featureType":"road.highway","elementType":"geometry","stylers":[{"color":"#f8c967"}]},{"featureType":"road.highway","elementType":"geometry.stroke","stylers":[{"color":"#e9bc62"}]},{"featureType":"road.highway","elementType":"labels","stylers":[{"visibility":"off"}]},{"featureType":"road.highway.controlled_access","elementType":"geometry","stylers":[{"color":"#e98d58"}]},{"featureType":"road.highway.controlled_access","elementType":"geometry.stroke","stylers":[{"color":"#db8555"}]},{"featureType":"road.local","stylers":[{"visibility":"off"}]},{"featureType":"road.local","elementType":"labels","stylers":[{"visibility":"off"}]},{"featureType":"road.local","elementType":"labels.text.fill","stylers":[{"color":"#806b63"}]},{"featureType":"transit","stylers":[{"visibility":"off"}]},{"featureType":"transit.line","elementType":"geometry","stylers":[{"color":"#dfd2ae"}]},{"featureType":"transit.line","elementType":"labels.text.fill","stylers":[{"color":"#8f7d77"}]},{"featureType":"transit.line","elementType":"labels.text.stroke","stylers":[{"color":"#ebe3cd"}]},{"featureType":"transit.station","elementType":"geometry","stylers":[{"color":"#dfd2ae"}]},{"featureType":"transit.station.airport","stylers":[{"visibility":"off"}]},{"featureType":"transit.station.bus","stylers":[{"visibility":"off"}]},{"featureType":"transit.station.rail","stylers":[{"saturation":100},{"visibility":"simplified"},{"weight":6}]},{"featureType":"transit.station.rail","elementType":"labels.icon","stylers":[{"visibility":"on"}]},{"featureType":"water","elementType":"geometry.fill","stylers":[{"color":"#b9d3c2"}]},{"featureType":"water","elementType":"labels.text.fill","stylers":[{"color":"#92998d"}]}],
        {name: 'ETS Map'});
    
    let istanbulCenter = {
        lat: 40.998687, 
        lng: 28.876655
    };
    
    gmap = new google.maps.Map(document.getElementById('gmap'),{
       zoom:14,
       center: istanbulCenter,
       mapTypeControl: false
    });
    
    gmap.mapTypes.set('ets_map', etsMapType);
    gmap.setMapTypeId('ets_map');
    
    
    gmap.addListener('click', function(target){
        if(target.placeId){
            console.log(JSON.stringify(target.latLng));
            getPlaceDetailsById(target.placeId);
        }
    });
    
    //init metro lines polys
    if(showMetroLines){
        initMetroLines();
    }
    
}


function getPlaceDetailsById(placeId){
    var service = new google.maps.places.PlacesService(gmap);
    service.getDetails({
      placeId: placeId
    }, function(place, status) {
      if(status === google.maps.places.PlacesServiceStatus.OK) {
        initStationDetails(place);
      }
    });
}


function initStationDetails(place){
    //1. Format place.name (may contain 'Station'/'Metro station'
    substringStation = "Station";
    if(place.name.indexOf(substringStation) !== -1){
        place.name = place.name.replace(substringStation,'');
    }
    substringUnderground = "Underground";
    if(place.name.indexOf(substringUnderground)!==-1){
        place.name = place.name.replace(substringUnderground,'');
    }
    substringMetro = "Metro ";
    if(place.name.indexOf(substringMetro) !== -1){
        place.name = place.name.replace(substringMetro, '');
    }
    substringSquare = "Square";
    if(place.name.indexOf(substringSquare) !== -1){
        place.name = place.name.replace(substringSquare, '');
    }
    substringIndustry = "Industry";
    if(place.name.indexOf(substringIndustry) !== -1){
        place.name = place.name.replace(substringIndustry, '');
    }
    substringIstasyon = "istasyon";
    if(place.name.indexOf(substringIstasyon) !== -1){
        place.name = place.name.replace(substringIstasyon, '');
    }
    substringSubway = "Subway";
    if(place.name.indexOf(substringSubway) !== -1){
        place.name = place.name.replace(substringSubway, '');
    }
    substringVodf = "Vodafone";
    if(place.name.indexOf(substringVodf) !== -1){
        place.name = place.name.replace(substringVodf, '');
    }
    substringStop = "Stop";
    if(place.name.indexOf(substringStop) !== -1){
        place.name = place.name.replace(substringStop, '');
    }
    if(place.place_id==="ChIJ8f4ZB5K6yhQR1C27vv5rhU4"){
        place.name = "Otogar";
    }
    console.log('Formatted place name: ' + place.name);
    
    //2. Check if station is found
    let response = getStationInformation(place.name);
    if(response.status===200){
        
        if(showStationImage){
            initPlacePhoto(place);
        }
        
        //Hide no-station-selected panel
        document.getElementById("ets-gmap-noStationSelected").style.display = "none";
        //Show station-details-panel
        document.getElementById("mapForm:station-details-panel").style.visibility = "visible";
        
        
        //3. Populate station details with values
        var stationDetails = JSON.parse(response.responseText);
        document.getElementById("stationName").innerHTML = place.name;
        document.getElementById("nbOfPassengersIn").innerHTML = stationDetails.passengersIn;
        document.getElementById("nbOfPassengersInStation").innerHTML = stationDetails.passengersInStation;
        document.getElementById("nbOfPassengersOut").innerHTML = stationDetails.passengersOut;
        document.getElementById("nbOfSmartCards").innerHTML = stationDetails.smartCardTikets;
        document.getElementById("nbFraudulents").innerHTML = stationDetails.noFraudulents;
        document.getElementById("nbTransactions").innerHTML = stationDetails.noTransactions;
        
        //4. Show evolution arrows
        if(stationDetails.difPassengersIn>0){
            document.getElementById("diffNbOfPassengersIn").className = "fa fa-arrow-circle-up ets-val-sign-pos";
            document.getElementById("diffNbOfPassengersIn").title = "Increased with: " + stationDetails.difPassengersIn;
        }else if(stationDetails.difPassengersIn<0){
            document.getElementById("diffNbOfPassengersIn").className = "fa fa-arrow-circle-down ets-val-sign-neg";
            document.getElementById("diffNbOfPassengersIn").title = "Decreased with: " + Math.abs(stationDetails.difPassengersIn);
        }
        
        if(stationDetails.difPassengersInStation>0){
            document.getElementById("diffNbOfPassengersInStation").className = "fa fa-arrow-circle-up ets-val-sign-pos";
            document.getElementById("diffNbOfPassengersInStation").title = "Increased with: " + stationDetails.difPassengersInStation;
        }else if(stationDetails.difPassengersInStation<0){
            document.getElementById("diffNbOfPassengersInStation").className = "fa fa-arrow-circle-down ets-val-sign-neg";
            document.getElementById("diffNbOfPassengersInStation").title = "Decreased with: " + Math.abs(stationDetails.difPassengersInStation);
        }
        
        if(stationDetails.difPassengersOut>0){
            document.getElementById("diffNbOfPassengersOut").className = "fa fa-arrow-circle-up ets-val-sign-pos";
            document.getElementById("diffNbOfPassengersOut").title = "Increased with: " + stationDetails.difPassengersOut;
        }else if(stationDetails.difPassengersOut<0){
            document.getElementById("diffNbOfPassengersOut").className = "fa fa-arrow-circle-down ets-val-sign-neg";
            document.getElementById("diffNbOfPassengersOut").title = "Decreased with: " + Math.abs(stationDetails.difPassengersOut);
        }
        
        if(stationDetails.difSmartCardTikets>0){
            document.getElementById("diffNbOfSmartCards").className = "fa fa-arrow-circle-up ets-val-sign-pos";
            document.getElementById("diffNbOfSmartCards").title = "Increased with: " + stationDetails.difSmartCardTikets;
        }else if(stationDetails.difSmartCardTikets<0){
            document.getElementById("diffNbOfSmartCards").className = "fa fa-arrow-circle-down ets-val-sign-neg";
            document.getElementById("diffNbOfSmartCards").title = "Decreased with: " + Math.abs(stationDetails.difSmartCardTikets);
        }
        
        if(stationDetails.difNoFraudulents>0){
            document.getElementById("diffNbFraudulents").className = "fa fa-arrow-circle-up ets-val-sign-pos";
            document.getElementById("diffNbFraudulents").title = "Increased with: " + stationDetails.difNoFraudulents;
        }else if(stationDetails.difNoFraudulents<0){
            document.getElementById("diffNbFraudulents").className = "fa fa-arrow-circle-down ets-val-sign-neg";
            document.getElementById("diffNbFraudulents").title = "Decreased with: " + Math.abs(stationDetails.difNoFraudulents);
        }
        
        if(stationDetails.difNoTransactions>0){
            document.getElementById("diffNbTransactions").className = "fa fa-arrow-circle-up ets-val-sign-pos";
            document.getElementById("diffNbTransactions").title = "Increased with: " + stationDetails.difNoTransactions;
        }else if(stationDetails.difNoTransactions<0){
            document.getElementById("diffNbTransactions").className = "fa fa-arrow-circle-down ets-val-sign-neg";
            document.getElementById("diffNbTransactions").title = "Decreased with: " + Math.abs(stationDetails.difNoTransactions);
        }
    }else{
        console.log('NOK');
        document.getElementById("ets-gmap-err-icon").style.visibility = "visible";
        document.getElementById("ets-gmap-place-img").style.display = "none";
        document.getElementById("ets-gmap-err-title").innerHTML = "Invalid metro station selected.";
        document.getElementById("ets-gmap-err-subtitle").innerHTML = "Please select another station";
        document.getElementById("mapForm:station-details-panel").style.visibility = "collapse";
        document.getElementById("ets-gmap-noStationSelected").style.display = "inline-block";
    }
}

function getStationInformation(stationName){
    var xHttp = new XMLHttpRequest();
    let compl_url = window.location;
    var protocol,host,port;
    ['protocol','host','port'].forEach(function(k) {
        if(k==='protocol'){
            protocol = compl_url[k];
        }else if(k==='host'){
            host = compl_url[k];
        }else if(k==='port'){
            port = compl_url[k];
        }
    });
    
    var url = protocol + '//' 
            + host + '/ETS_Reports/webresources/ro.siveco.cad.ets.ets_reports.dashboardinfot/byStationName/' 
            + stationName;
    xHttp.open( "GET", url, false );
    xHttp.setRequestHeader('Accept', 'application/json');
    xHttp.send(null);
    return xHttp;
}


function initPlacePhoto(place){
    var photos = place.photos;
    if(!photos){
        return;
    }
    document.getElementById("ets-gmap-place-img").style.display = "block";
    document.getElementById("ets-gmap-place-img").src = photos[0].getUrl({'maxWidth': 300, 'maxHeight': 180});
}

//initializes metro lines
function initMetroLines(){
    let lineM1SPath = [
        {"lat":40.98942254009197,"lng":28.83687973022461},
        {"lat":40.9914795154879,"lng":28.84587049484253},
        {"lat":40.995658055300815,"lng":28.863530158996582},
        {"lat":40.99661357564705,"lng":28.87528896331787},
        {"lat":41.00176342985443,"lng":28.889987468719482},
        {"lat":41.00749581315154,"lng":28.8965106010437},
        {"lat":41.02051327202711,"lng":28.900201320648193},
        {"lat":41.03054985433818,"lng":28.89779806137085},
        {"lat":41.0401317439836,"lng":28.894493579864502}
    ];
    
    let lineM1Path = [
        {"lat":41.0324922419683,"lng":28.84284496307373},
        {"lat":41.03469354533966,"lng":28.856234550476074},
        {"lat":41.03699188648698,"lng":28.87108325958252},
        {"lat":41.04291540990123,"lng":28.878636360168457},
        {"lat":41.03738033058445,"lng":28.888378143310547},
        {"lat":41.0401317439836,"lng":28.894472122192383},
        {"lat":41.04087622430877,"lng":28.907217979431152},
        {"lat":41.03414322639742,"lng":28.92022132873535},
        {"lat":41.02401006142956,"lng":28.92953395843506},
        {"lat":41.01802007732287,"lng":28.93876075744629},
        {"lat":41.011640954794615,"lng":28.948674201965332},
        {"lat":41.00522882851542,"lng":28.95167827606201}
    ];
    
    let lineM2Path = [
      {"lat":41.13978473565079,"lng":29.030685424804688},
      {"lat":41.13018504216528,"lng":29.025235176086426},
      {"lat":41.11870881798894,"lng":29.023818969726562},
      {"lat":41.10849167378173,"lng":29.020042419433594},
      {"lat":41.0948771219984,"lng":29.00519371032715},
      {"lat":41.08481800406193,"lng":29.007039070129395},
      {"lat":41.075792597424694,"lng":29.01463508605957},
      {"lat":41.068869044209656,"lng":29.010558128356934},
      {"lat":41.06398329455141,"lng":28.992362022399902},
      {"lat":41.05395180997086,"lng":28.98716926574707},
      {"lat":41.0369757012665,"lng":28.985753059387207},
      {"lat":41.028672158490814,"lng":28.974852561950684},
      {"lat":41.022682598426414,"lng":28.966526985168457},
      {"lat":41.01248290482601,"lng":28.959531784057617},
      {"lat":41.00522882851542,"lng":28.95167827606201}
    ];
    
    let lineM3Path = [
        {"lat":41.10765095187672,"lng":28.801217079162598},
        {"lat":41.09746442741868,"lng":28.79091739654541},
        {"lat":41.088149650982984,"lng":28.796324729919434},
        {"lat":41.08077451634376,"lng":28.797311782836914},
        {"lat":41.071586787541925,"lng":28.803234100341797},
        {"lat":41.064792218576684,"lng":28.82615089416504},
        {"lat":41.05434015396821,"lng":28.830571174621582},
        {"lat":41.04108661939616,"lng":28.83589267730713},
        {"lat":41.0324922419683,"lng":28.84284496307373}
    ];
    
    let M3PathA1 = [
        {"lat":41.07948054773133,"lng":28.76842975616455},
        {"lat":41.071586787541925,"lng":28.803234100341797}
    ]
    
    let lineM4Path = [
        {"lat":40.99126896189955,"lng":29.022231101989746},
        {"lat":41.00037074168065,"lng":29.030213356018066},
        {"lat":41.00215208176697,"lng":29.045276641845703},
        {"lat":40.997358548002964,"lng":29.05935287475586},
        {"lat":40.993698385498604,"lng":29.07029628753662},
        {"lat":40.984628080638075,"lng":29.09029483795166},
        {"lat":40.974681705273,"lng":29.10003662109375},
        {"lat":40.96470142410441,"lng":29.1048002243042},
        {"lat":40.94878817919348,"lng":29.122395515441895},
        {"lat":40.935853816877696,"lng":29.13926124572754},
        {"lat":40.929953091091484,"lng":29.146170616149902},
        {"lat":40.923727578364335,"lng":29.15501117706299},
        {"lat":40.92080916737859,"lng":29.166254997253418},
        {"lat":40.91506924984297,"lng":29.1811466217041},
        {"lat":40.912863951261464,"lng":29.193334579467773},
        {"lat":40.906701697655514,"lng":29.211058616638184}
    ];
    
    let lineM1Color = "#D7382D";
    let lineM2Color = "#09843E";
    let lineM3Color = "#279DCB";
    let lineM4Color = "#DF356E";
    
   
    let lineM1Polyline = new google.maps.Polyline({
        path:lineM1Path,
        strokeColor: lineM1Color,
        strokeWeight: 12,
        strokeOpacity: 0.55,
        clickable:false
    });
    
    let lineM1SPolyline = new google.maps.Polyline({
        path:lineM1SPath,
        strokeColor: lineM1Color,
        strokeWeight: 12,
        strokeOpacity: 0.55,
        clickable:false
    });
    let lineM2Polyline = new google.maps.Polyline({
        path:lineM2Path,
        strokeColor: lineM2Color,
        strokeWeight: 12,
        strokeOpacity: 0.65,
        clickable:false
    });
    let lineM3Polyline = new google.maps.Polyline({
        path:lineM3Path,
        strokeColor: lineM3Color,
        strokeWeight: 12,
        strokeOpacity: 0.65,
        clickable:false
    });
    let lineM3A1Polyline = new google.maps.Polyline({
        path:M3PathA1,
        strokeColor: lineM3Color,
        strokeWeight: 12,
        strokeOpacity: 0.65,
        clickable:false
    });
    let lineM4Polyline = new google.maps.Polyline({
        path:lineM4Path,
        strokeColor: lineM4Color,
        strokeWeight: 12,
        strokeOpacity: 0.55,
        clickable:false
    });
    
    
    //add polylines to map
    lineM1Polyline.setMap(gmap);
    lineM1SPolyline.setMap(gmap);
    lineM2Polyline.setMap(gmap);
    lineM3Polyline.setMap(gmap);
    lineM3A1Polyline.setMap(gmap);
    lineM4Polyline.setMap(gmap);
    


    

}