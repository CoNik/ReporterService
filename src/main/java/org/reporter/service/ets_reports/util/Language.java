/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.reporter.service.ets_reports.util;

/**
 *
 * @author constantinn
 */
public class Language {
    
    private String language;
    private String ISOCode;
    
    public Language(String language, String ISOCode){
        this.language = language;
        this.ISOCode = ISOCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getISOCode() {
        return ISOCode;
    }

    public void setISOCode(String ISOCode) {
        this.ISOCode = ISOCode;
    }
    
    
}
