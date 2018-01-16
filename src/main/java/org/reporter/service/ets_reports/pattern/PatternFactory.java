/*
 *  
 * Reporter Service 2018 Updates
 */
package org.reporter.service.ets_reports.pattern;

import java.util.List;

import org.reporter.service.ets_reports.StationPositions;

/**
 *
 * @author constantinn
 */
public class PatternFactory {
     private final static PatternMain PATTERN = new PatternMain();
     
    private PatternFactory() {
    }
    
    public static PatternFactory getInstance() {
        return PatternFactoryHolder.INSTANCE;
    }
    
    public static PatternMain getNewPattern(List<StationPositions> lsp) {
        PATTERN.getAllData(5, lsp);
        return PATTERN;
    }
    
    public static PatternMain getPattern() {
        return PATTERN;
    }
    
    private static class PatternFactoryHolder {

        private static final PatternFactory INSTANCE = new PatternFactory();
    }
}
