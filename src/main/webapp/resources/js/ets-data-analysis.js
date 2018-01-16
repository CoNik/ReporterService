var width = 1620;
var height = 750;

//KonvaJS
var stage;
//canvas layers
var stationsLayer;
var tooltipLayer;
var tooltip;
var backgroundLayer;

//CanvasJS
var patternChart;
var forecastChart;

var stationsData;


//DOM ready here
(function() {
    initKonvaJS();
    initCanvasJSCharts();
})();

/*
 * Called when time slider ends.
 */
function initStationData(data){
    //1. Get station data as JSON
    stationsData = JSON.parse(data);
    //1. Clear all existing stations from stationsLayer
    stationsLayer.destroyChildren();
    //2. Add stations to stationsLayer
    for(var key in stationsData){
        if(stationsData.hasOwnProperty(key)){
            var stationCircle = new Konva.Circle({
               identifier: stationsData[key].stationId,
               x: stationsData[key].posX,
               y: stationsData[key].posY,
               key: stationsData[key].stationName,
               radius: stationsData[key].normalValue,
               value: stationsData[key].value,
               fill: stationsData[key].color,
               stroke: 'black',
               strokeWidth: 2,
               opacity: 0.85
            });
            stationsLayer.add(stationCircle);
        }
    }
    //3. Update layer
    stationsLayer.draw();
    
}

function onStationClick(stationDataJSON){
    //1. Get station data as JSON
    let stationData = JSON.parse(stationDataJSON);
    
    //2. Loop through stationData and build dataPoints
    let dataSplines = [];
    let dataPoints = [];
    var step=0;
    for(var key in stationData){
        if(stationData.hasOwnProperty(key)){
            var dataPoint = {
                label: stationData[key].timeStamp,
                y: stationData[key].value
            };
            
            
            dataPoints.push(dataPoint);
            if(step%20==0)
                dataSplines.push(dataPoint);
            step=step+1;
        }
    }
    
    //3. Assign dataPoints to *both* charts
    patternChart.options.data =  [{
        type: "line",
        dataPoints: dataPoints
    }];

    forecastChart.options.data =  [{
        type: "splineArea",
        dataPoints: dataSplines
    }];

    //4. Render charts
    patternChart.render();
    forecastChart.render();
}


function initKonvaJS(){
    stage = new Konva.Stage({
        container: 'ets-metro-map-min',
        width: width,
        height: height
    });
    //init layers
    stationsLayer = new Konva.Layer();
    tooltipLayer = new Konva.Layer();
    backgroundLayer = new Konva.Layer();
    initBackgroundMetroMap();
    
    initTootlips();
    tooltipLayer.add(tooltip);
    
    //finally add layers to konva stage
    stage.add(backgroundLayer);
    stage.add(stationsLayer);
    stage.add(tooltipLayer);
    
    //hide charts panel until a stations is clicked
    document.getElementById("mapForm:chartsPanel").style.display = 'none';
}
function initTootlips(){
    //init tooltips
    tooltip = new Konva.Label({
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
}
function initBackgroundMetroMap(){
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
}
function initCanvasJSCharts(){
    //1. Init pattern chart
    patternChart = new CanvasJS.Chart("patternChartContainer", {
        animationEnabled: true,
        zoomEnabled: true,
        panEnabled: true,
        theme: "light2"
    });
    
   
    //2. Init forecast chart
    forecastChart = new CanvasJS.Chart("forecastChartContainer", {
        animationEnabled: true,
        zoomEnabled: true,
        panEnabled: true,
        theme: "light1",
        colorSet: "“colorSet2" 
    });
    
   
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

//Stage events
stage.on('mouseover', function(evt) {
    var shape = evt.target;
    if (shape) {
        
        shape.setOpacity(0.85);
        stationsLayer.draw();
        
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
        stationsLayer.draw();
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
           
            //build tooltip text
            var selectedValueName = document.getElementById("mapForm:selectedValueName").value;
            if(selectedValueName!==undefined && selectedValueName!==null){
                selectedValueName = capitalizeFirstLetter(selectedValueName);
                
                let tooltipText = shape.attrs.key + "\n\n" 
                        +  selectedValueName + ": " + shape.attrs.value;
                updateTooltip(tooltip, x, y, tooltipText); 
            }else{
                console.warn('Could not get selected value name from #mapForm:selectedValueName!');
            }
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
            //if a station is clicked show charts panel
            let chartsPanel = document.getElementById("mapForm:chartsPanel");
            chartsPanel.style.display = 'block';
            
            onStationClickRC([{name:'stationId', value:shape.attrs.identifier},
                              {name:'stationName', value:shape.attrs.key}]);

            let selectedValueName = document.getElementById("mapForm:selectedValueName").value;
            if(selectedValueName !== undefined && selectedValueName !== null){
                document.getElementById('ets-pattern-header').innerHTML = "Pattern for " + selectedValueName + " in " + shape.attrs.key;
                document.getElementById('ets-forecast-header').innerHTML = "Forecast for " + selectedValueName + " in " + shape.attrs.key;
            }else{
                document.getElementById('ets-pattern-header').innerHTML = "Pattern for " + shape.attrs.key;
                document.getElementById('ets-forecast-header').innerHTML = "Forecast for " + shape.attrs.key;
            }
        }
    }
});


//utility functions
function capitalizeFirstLetter(string) {
    return string.charAt(0).toUpperCase() + string.slice(1);
}
