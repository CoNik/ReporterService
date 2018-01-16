package org.reporter.service.ets_reports.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.selectonemenu.SelectOneMenuRenderer;

/**
 *
 * @author constantinn
 */
public class ETSSelectOneMenuRenderer extends SelectOneMenuRenderer{
    
    @Override
    protected void encodeOptionsAsTable(FacesContext context, SelectOneMenu menu, List<SelectItem> selectItems) throws IOException {
        List<SelectItem> wrappedSelectItems = new ArrayList<>();

        for (SelectItem selectItem : selectItems) {
            Object value = selectItem.getValue();

            if (value instanceof String) {
                value = new StringBuilder((String) value);
            }

            wrappedSelectItems.add(new SelectItem(value, selectItem.getLabel()));
        }

        super.encodeOptionsAsTable(context, menu, wrappedSelectItems);
    }
    
}
