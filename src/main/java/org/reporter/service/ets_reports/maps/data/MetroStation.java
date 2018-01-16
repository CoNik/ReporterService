package org.reporter.service.ets_reports.maps.data;

import java.io.Serializable;

/**
 *
 * @author constantinn
 */
public class MetroStation implements Serializable{
    
    private String name;
    private String lineColor;
    private double x;
    private double y;

    public MetroStation() {
    }

    public MetroStation(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLineColor() {
        return lineColor;
    }

    public void setLineColor(String lineColor) {
        this.lineColor = lineColor;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    
}
