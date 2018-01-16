package org.reporter.service.ets_reports.clients;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import org.reporter.service.ets_reports.pattern.ValueOnChart;
import org.reporter.service.ets_reports.pattern.ValueOnMap;

/**
 * Jersey REST client generated for REST resource:StationPositionsFacadeREST
 * 
 * USAGE:
 * <pre>
 *        StationPositionClient client = new StationPositionClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author constantinn
 */
public class StationPositionClient {

    private WebTarget webTarget;
    private Client client;
    private static String BASE_URI = "http://localhost:8080/ETS_Reports/webresources";
    
    
    public StationPositionClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("org.reporter.service.ets_reports.stationpositions");
    }
    
    public StationPositionClient(String uri) {
        BASE_URI = uri + "webresources";
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("org.reporter.service.ets_reports.stationpositions");
    }

    public String countREST() throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("count");
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
    }

    public void edit_XML(Object requestEntity, String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("{0}", 
                new Object[]{id})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, 
                        javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void edit_JSON(Object requestEntity, String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("{0}", 
                new Object[]{id})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, 
                        javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getPositionsOnMap_XML(Class<T> responseType, String day, 
            String minuteNo, String nominal, String card, String in, String type) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getPositionsOnMap/{0}/{1}/{2}/{3}/{4}/{5}", 
                new Object[]{day, minuteNo, nominal, card, in, type}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public List<ValueOnMap> getPositionsOnMap_JSON(String day, String minuteNo, String nominal, 
            String card, String in, String type) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getPositionsOnMap/{0}/{1}/{2}/{3}/{4}/{5}", 
                new Object[]{day, minuteNo, nominal, card, in, type}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=utf-8").get(new GenericType<List<ValueOnMap>>(){});
    }

    public <T> T getPositionsOnMap_TEXT(Class<T> responseType, String day, String minuteNo, String nominal, 
            String card, String in, String type) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getPositionsOnMap/{0}/{1}/{2}/{3}/{4}/{5}", 
                new Object[]{day, minuteNo, nominal, card, in, type}));
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(responseType);
    }

    public <T> T find_XML(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T find_JSON(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T findRange_XML(Class<T> responseType, String from, String to) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}/{1}", new Object[]{from, to}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T findRange_JSON(Class<T> responseType, String from, String to) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}/{1}", new Object[]{from, to}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void create_XML(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, 
                javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void create_JSON(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, 
                javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getPositionsOnChart_XML(Class<T> responseType, String day, String stationId, String nominal, 
            String card, String in, String type) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getPositionsOnChart/{0}/{1}/{2}/{3}/{4}/{5}", 
                new Object[]{day, stationId, nominal, card, in, type}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public List<ValueOnChart> getPositionsOnChart_JSON(String day, String stationId, String nominal, 
            String card, String in, String type) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getPositionsOnChart/{0}/{1}/{2}/{3}/{4}/{5}", 
                new Object[]{day, stationId, nominal, card, in, type}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=utf-8").get(new GenericType<List<ValueOnChart>>(){});
    }

    public <T> T getPositionsOnChart_TEXT(Class<T> responseType, String day, String stationId, String nominal, 
            String card, String in, String type) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getPositionsOnChart/{0}/{1}/{2}/{3}/{4}/{5}", 
                new Object[]{day, stationId, nominal, card, in, type}));
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(responseType);
    }

    public <T> T findAll_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T findAll_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getPositionsOnMapWithTime_XML(Class<T> responseType, String day, String localTime, String nominal, 
            String card, String in, String type) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getPositionsOnMapWithTime/{0}/{1}/{2}/{3}/{4}/{5}", 
                new Object[]{day, localTime, nominal, card, in, type}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getPositionsOnMapWithTime_JSON(Class<T> responseType, String day, String localTime, String nominal, 
            String card, String in, String type) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getPositionsOnMapWithTime/{0}/{1}/{2}/{3}/{4}/{5}", 
                new Object[]{day, localTime, nominal, card, in, type}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getPositionsOnMapWithTime_TEXT(Class<T> responseType, String day, String localTime, String nominal, 
            String card, String in, String type) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getPositionsOnMapWithTime/{0}/{1}/{2}/{3}/{4}/{5}", 
                new Object[]{day, localTime, nominal, card, in, type}));
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(responseType);
    }

    public <T> T getPositionsOnChartByName_XML(Class<T> responseType, String day, String station, String nominal, 
            String card, String in, String type) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getPositionsOnChartByName/{0}/{1}/{2}/{3}/{4}/{5}", 
                new Object[]{day, station, nominal, card, in, type}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getPositionsOnChartByName_JSON(Class<T> responseType, String day, String station, String nominal, 
            String card, String in, String type) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getPositionsOnChartByName/{0}/{1}/{2}/{3}/{4}/{5}", 
                new Object[]{day, station, nominal, card, in, type}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getPositionsOnChartByName_TEXT(Class<T> responseType, String day, String station, String nominal, 
            String card, String in, String type) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getPositionsOnChartByName/{0}/{1}/{2}/{3}/{4}/{5}", 
                new Object[]{day, station, nominal, card, in, type}));
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(responseType);
    }

    public void remove(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id})).request().delete();
    }

    public String initialGeneratePattern() throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("testGeneratePattern");
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
    }

    public void close() {
        client.close();
    }
    
}
