/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.reporter.service.ets_reports.util;

import java.io.IOException;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.model.SelectItem;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.component.selectoneradio.SelectOneRadioRenderer;

/**
 *
 * @author constantinn
 */
public class EtsOneRadioRenderer extends SelectOneRadioRenderer{

    @Override
    protected void encodeOptionLabel(FacesContext context, SelectOneRadio radio, String containerClientId, SelectItem option, boolean disabled) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        writer.startElement("label", null);
        writer.writeAttribute("for", containerClientId, null);

        if (option.getDescription() != null) {
            writer.writeAttribute("title", option.getDescription(), null);
        }

        if (disabled) {
            writer.writeAttribute("class", "ui-state-disabled", null);
        }

        if (option.isEscape()) {
            writer.writeText(option.getLabel(), null);
        } else {
            writer.write(option.getLabel());
        }

        writer.endElement("label");
    }
    
    
}
