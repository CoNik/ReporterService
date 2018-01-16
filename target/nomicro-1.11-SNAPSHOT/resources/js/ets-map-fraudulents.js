/**
 * Get all station validators
 */
var startDate = document.getElementById("ets-navForm:filterStartDate").value;
var endDate = document.getElementById("ets-navForm:filterEndDate").value;
var width = 1620;
var height = 750;

var fraudulentsNb = 0;


function getStationsFraudulents(){
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
    console.log("Getting fraudulents within: " + startDate + " and: " + endDate);
    
    var url = protocol + '//' + host + '/ETS_Reports/webresources/ro.siveco.cad.ets.ets_reports.fraudstations/stationsFraudulents/' 
            + startDate + '/' + endDate;
    console.log("Requesting: " + url); 
    xHttp.open( "GET", url, false );
    xHttp.setRequestHeader('Accept', 'application/json');
    xHttp.send(null);
    return xHttp.responseText;
}

function getStationFraudulents(stationId){
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
    var url = protocol + '//' + host + '/ETS_Reports/webresources/ro.siveco.cad.ets.ets_reports.fraudstations/countByPeriodAndStationId/' 
            + startDate + '/' + endDate + "/" + stationId;
    xHttp.open( "GET", url, false );
    xHttp.setRequestHeader('Accept', 'text/plain');
    xHttp.send(null);
    return xHttp.responseText;
}




function updateTooltip(tooltip, x, y, text) {
    tooltip.getText().setText(text);
    tooltip.setPosition({
        x : x,
        y : y
    });
    if(text){
        tooltip.show();
    }
}

var stage = new Konva.Stage({
    container: 'ets-metro-map',
    width: width,
    height: height
});
    
var shapesLayer = new Konva.Layer();
var tooltipLayer = new Konva.Layer();

var tooltip = new Konva.Label({
    opacity: 1,
    visible: false,
    listening: false
});

tooltip.add(new Konva.Tag({
    fill: '#2E2925',
    pointerDirection: 'down',
    pointerWidth: 10,
    pointerHeight: 10,
    lineJoin: 'round',
    shadowColor: '#2E2925',
    shadowBlur: 10,
    shadowOffset: 10,
    shadowOpacity: 0.5
}));

tooltip.add(new Konva.Text({
    text: '',
    fontFamily: 'Calibri',
    fontSize: 18,
    padding: 5,
    fill: 'white'
}));


tooltipLayer.add(tooltip);
var stations = JSON.parse(getStationsFraudulents());

for (var key in stations) {
    if(stations.hasOwnProperty(key)){
       var stationCircle = new Konva.Circle({
           identifier: stations[key].stationId,
           key: stations[key].stationName,
           x: stations[key].posX,
           y: stations[key].posY,
           fraudulents: stations[key].fraudulents,
           radius: 10,
           fill: '#EE2F41',
           stroke: 'black',
           strokeWidth: 2,
           opacity:0.8
       });
       if(stationCircle.attrs.fraudulents<=0){
//           stationCircle.attrs.opacity = 0;
           stationCircle.attrs.fill = "#60a917";
           stationCircle.attrs.radius = 5;
       }else if(stationCircle.attrs.fraudulents<=2){
           stationCircle.attrs.fill = "#f0a30a";
           stationCircle.attrs.radius = 6;
       }else if(stationCircle.attrs.fraudulents<=5){
           stationCircle.attrs.fill = "#fa6800";
       }else{
           stationCircle.attrs.fill = "#e51400";
           if(stationCircle.attrs.fraudulents < 10){
                stationCircle.attrs.radius = 2 * stationCircle.attrs.fraudulents;
           }else{
               stationCircle.attrs.radius = 30;
           }
        }
        stationCircle.perfectDrawEnabled(true);
        if(stationCircle.attrs.x !== 0 && stationCircle.attrs.y !== 0){
           shapesLayer.add(stationCircle);
        }
    }
}


var backgroundLayer = new Konva.Layer();

stage.add(backgroundLayer);
stage.add(shapesLayer);
stage.add(tooltipLayer);


//canvas background - metro map
var imageObj = new Image();
imageObj.onload = function() {
    var backgroundImage = new Konva.Image({
        x: 0,
        y: 0,
        width: width,
        height: height,
        image: imageObj
    });
    backgroundLayer.add(backgroundImage);
    backgroundLayer.draw();
};

imageObj.src = '/ETS_Reports/faces/javax.faces.resource/metro_map3.jpg?ln=images';

var zoomLevel = 2;

//Stage events
stage.on('mouseover', function(evt) {
    var shape = evt.target;
    if (shape) {
        
        shape.setOpacity(1);
        shapesLayer.draw();
        
        if(shape.attrs.identifier !== undefined && shape.attrs.identifier !== null){
            document.body.style.cursor = 'pointer';
            onStationHoverRC([{name:'stationId', value:shape.attrs.identifier}]);
            //update nb of fraudulents
            fraudulentsNb = getStationFraudulents(shape.attrs.identifier);
        }else{
            document.body.style.cursor = 'default';
        }
    }
});
stage.on('mouseout', function(evt) {
    var shape = evt.target;
    if (shape) {
        shape.setOpacity(0.8);
        shapesLayer.draw();
        tooltip.hide();
        tooltipLayer.draw();
    }
});
stage.on('mousemove', function(evt) {
    var shape = evt.target;
    if (shape) {
        var mousePos = stage.getPointerPosition();
        var x = mousePos.x;
        var y = mousePos.y - 5;
        
        if(shape.attrs.key){
            //update tooltip text
            let tooltipText = shape.attrs.key + "\n\n" + "Fraudulents: " + fraudulentsNb;
            updateTooltip(tooltip, x, y, tooltipText);
        }
        tooltipLayer.batchDraw();
    }
});

stage.on('click', function(evt){
    var shape = evt.target;
    if(shape){
        var mousePos = stage.getPointerPosition();
        var x = mousePos.x;
        var y = mousePos.y - 5;
        
        if(shape.attrs.key){
            console.log('shape clicked');
            onStationClickRC([{name:'stationId', value:shape.attrs.identifier}]);
        }
    }
});