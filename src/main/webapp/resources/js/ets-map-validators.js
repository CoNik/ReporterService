/**
 * Get all station validators
 */
function getStationsValidators(){
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
    
    var url = protocol + '//' + host + '/ETS_Reports/webresources/org.reporter.service.ets_reports.validators/positions';
    xHttp.open( "GET", url, false );
    xHttp.setRequestHeader('Accept', 'application/json');
    xHttp.send(null);
    return xHttp.responseText;
}


var width = 1620;
var height = 750;

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
var stations = JSON.parse(getStationsValidators());

for (var key in stations) {
    if(stations.hasOwnProperty(key)){
       var stationCircle = new Konva.Circle({
           identifier: stations[key].stationId,
           key: stations[key].stationName,
           x: stations[key].posX,
           y: stations[key].posY,
           radius: 15,
           fill: '#EE2F41',
           stroke: 'black',
           strokeWidth: 2,
           opacity:0
       });
       shapesLayer.add(stationCircle);
    }
}


var backgroundLayer = new Konva.Layer();

stage.add(backgroundLayer);
stage.add(shapesLayer);
stage.add(tooltipLayer);


//Canvas zoom

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
        
        shape.setOpacity(0.85);
        shapesLayer.draw();
        
        if(shape.attrs.identifier !== undefined && shape.attrs.identifier !== null){
            document.body.style.cursor = 'pointer';
            onStationHoverRC([{name:'stationId', value:shape.attrs.identifier}]);
        }else{
            document.body.style.cursor = 'default';
        }
    }
    
});
stage.on('mouseout', function(evt) {
    var shape = evt.target;
    if (shape) {
        shape.setOpacity(0);
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
            
            //if the station has multiple validators
            var validators = "";
            for(let i=0;i<stations.length;i++){
                if(stations[i].stationId===shape.attrs.identifier){
                    validators += "Validator IP: " + stations[i].IPAddress + "\n" +
                                  "Code: " + stations[i].code + "\n\n"; 
                }
            }
        
            
            //build tooltip text
            let tooltipText = shape.attrs.key + "\n\n" + validators;
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