package org.reporter.service.ets_reports.maps;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.reporter.service.ets_reports.util.Constants;

/**
 *
 * @author constantinn
 */

@Named("gMetroMapController")
@ViewScoped
public class GMetroMapController implements Serializable{
    
    private String MAPS_API;

    public String getMAPS_API() {
        MAPS_API = "https://maps.googleapis.com/maps/api/js?key=" + Constants.API_KEY + "&libraries=places";
        return MAPS_API;
    }

    public void setMAPS_API(String MAPS_API) {
        this.MAPS_API = MAPS_API;
    }

    
}
