/*
 *  
 * Reporter Service 2018 Updates
 */
package org.reporter.service.ets_reports.pattern;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.reporter.service.ets_reports.StationPositions;
import org.reporter.service.ets_reports.util.Constants;

/**
 *
 * @author constantinn
 */
public class PatternMain {

    private PatternMask[] patternMask = new PatternMask[24];

    private PatternMap[] behaviourPattern = new PatternMap[8];
    private PatternMap[] displayForecast = new PatternMap[8];
    private PatternMap[] riskDef = new PatternMap[8];
    
    public int noInit = 0;
    

    public PatternMain() {
        patternMask[0] = new PatternMask(100, 600);
        patternMask[1] = new PatternMask(50, 200);
        patternMask[2] = new PatternMask(0, 200);
        patternMask[3] = new PatternMask(30, 200);
        patternMask[4] = new PatternMask(100, 600);

        patternMask[5] = new PatternMask(200, 800);
        patternMask[6] = new PatternMask(300, 1200);
        patternMask[7] = new PatternMask(500, 1800);
        patternMask[8] = new PatternMask(500, 2000);
        patternMask[9] = new PatternMask(600, 2000);

        patternMask[10] = new PatternMask(500, 1600);
        patternMask[11] = new PatternMask(500, 1400);
        patternMask[12] = new PatternMask(500, 1500);
        patternMask[13] = new PatternMask(600, 1500);
        patternMask[14] = new PatternMask(700, 1800);

        patternMask[15] = new PatternMask(600, 1600);
        patternMask[16] = new PatternMask(700, 1800);
        patternMask[17] = new PatternMask(800, 2000);
        patternMask[18] = new PatternMask(800, 2000);
        patternMask[19] = new PatternMask(700, 1800);

        patternMask[20] = new PatternMask(500, 1600);
        patternMask[21] = new PatternMask(400, 1400);
        patternMask[22] = new PatternMask(200, 1000);
        patternMask[23] = new PatternMask(100, 800);

    }

    public void getAllData(int step, List<StationPositions> lsp) {
        for (int i = 0; i < 8; i++) {
            PatternMap pm = null;
            pm = new PatternMap();
            pm.initialize(step, patternMask, lsp);
            behaviourPattern[i] = pm;

            pm = new PatternMap();
            pm.initialize(step, patternMask, lsp);
            displayForecast[i] = pm;

            pm = new PatternMap();
            pm.initialize(step, patternMask, lsp);
            riskDef[i] = pm;

        }
        
        this.noInit ++;
    }

    public List<ValueOnMap> getPositionsOnMap(Integer day, LocalTime lt, Integer nominal, Integer card, Integer in, Integer type) {
        List<ValueOnMap> lvom = new ArrayList();
        PatternMap pm = behaviourPattern[day];
        // for all stations return values
        // step in the map
        Map <String, StationPattern> msp = pm.getStationPatternMap();
        for( StationPattern sp : msp.values() ){
            String s=sp.getStationName();
        }
        for (Map.Entry<String, StationPattern> entry : pm.getStationPatternMap().entrySet()) {
            //System.out.println(entry.getKey() + "/" + entry.getValue());
            StationPattern sp = entry.getValue();
            Long sid = sp.getId();
            String sn = sp.getStationName();
            double x = sp.getPosX() == null ? 0. : sp.getPosX();
            double y = sp.getPosY() == null ? 0. : sp.getPosY();

            List<PatternElement> lpe = sp.getPatterns();
            // depending on local time get the index in vector.
            // get the closest value in vector
            long diff = Long.MAX_VALUE;
                    //    86400000000

            PatternElement pfind = null;
            for (PatternElement pe : lpe) {
                if (Math.abs(pe.getDefTime().toNanoOfDay() - lt.toNanoOfDay()) < diff) {
                    pfind = pe;
                    diff = Math.abs(pe.getDefTime().toNanoOfDay() - lt.toNanoOfDay());

                }

            }
            long value = 0l;

            switch (type) {

                case 1: // duration
                    if (card == 1) {
                        value = pfind.getDurationCard()/Constants.NORMALIZE_FACTOR;
                    } else {
                        value = pfind.getDurationMobile()/Constants.NORMALIZE_FACTOR;
                    }
                    break;
                case 2: // fraudulents
                    value = pfind.getNoFraudulents()*Constants.NORMALIZE_FACTOR;
                    break;
                case 3: // activity On Kyosks
                    value = pfind.getNoKioskActions()/Constants.NORMALIZE_FACTOR;
                    break;
                case 4: // Camera recognized OK
                    value = pfind.getNoFaceRecognitionsOK()*Constants.NORMALIZE_FACTOR;
                    break;
                case 5: // Camera NOT recognized
                    value = pfind.getNoFaceRecognitionsNOK()*Constants.NORMALIZE_FACTOR;
                    break;
                case 6: // cammera error
                    value = pfind.getNoFaceRecognitionsERROR()*Constants.NORMALIZE_FACTOR;
                    break;
                default: // number of paseengers
                    if ((nominal == 1) && (card == 1)) {
                        if(in==1)
                            value=pfind.getValidatedInCardNominal();
                        else
                            value =pfind.getValidatedOutCardNominal();
                    break;
                    }
                    if ((nominal == 1) && (card == 0)) {
                        if(in==1)
                            value=pfind.getValidatedInMobileNominal();
                        else
                            value =pfind.getValidatedOutMobileNominal();
                    break;
                    }
                    
                    if ((nominal == 0) && (card == 0)) {
                        if(in==1)
                            value=pfind.getValidatedInMobileNotnominal();
                        else
                            value =pfind.getValidatedOutMobileNotnominal();
                    break;
                    }
                    
                     if ((nominal == 0) && (card == 1)) {
                        if(in==1)
                            value=pfind.getValidatedInCardNotnominal();
                        else
                            value =pfind.getValidatedOutCardNotnominal();
                    break;
                    }
                    
            }

             ValueOnMap vom = new ValueOnMap(sid, sn,(int) x,(int)y, value);
             lvom.add(vom);
        }
   
    return lvom ;
}
    
    public List<ValueOnChart> getPositionsOnChart(Integer day, String station, Integer nominal, Integer card, Integer in, Integer type){
         List<ValueOnChart> lvoc = new ArrayList();
         
          PatternMap pm = behaviourPattern[day];
        // for all stations return values
        // step in the map
        Map <String, StationPattern> msp = pm.getStationPatternMap();
        System.out.println(String.format("==> Day %d Station %s Nominal %d Card %d In %d Type %d", day, station, nominal, card, in, type));
        
       StationPattern sp= msp.get(station);
       
        List<PatternElement> lpe = sp.getPatterns();
       
        for(PatternElement pfind : lpe)
        {
        String st = String.format("%02d:%02d", pfind.getDefTime().getHour(), pfind.getDefTime().getMinute());
            long value = 0l;

            switch (type) {

                case 1: // duration
                    if (card == 1) {
                        value = pfind.getDurationCard();
                    } else {
                        value = pfind.getDurationMobile();
                    }
                    break;
                case 2: // fraudulents
                    value = pfind.getNoFraudulents();
                    break;
                case 3: // activity On Kyosks
                    value = pfind.getNoKioskActions();
                    break;
                case 4: // Camera recognized OK
                    value = pfind.getNoFaceRecognitionsOK();
                    break;
                case 5: // Camera NOT recognized
                    value = pfind.getNoFaceRecognitionsNOK();
                    break;
                case 6: // cammera error
                    value = pfind.getNoFaceRecognitionsERROR();
                    break;
                default: // number of paseengers
                    if ((nominal == 1) && (card == 1)) {
                        if(in==1)
                            value=pfind.getValidatedInCardNominal();
                        else
                            value =pfind.getValidatedOutCardNominal();
                    break;
                    }
                    if ((nominal == 1) && (card == 0)) {
                        if(in==1)
                            value=pfind.getValidatedInMobileNominal();
                        else
                            value =pfind.getValidatedOutMobileNominal();
                    break;
                    }
                    
                    if ((nominal == 0) && (card == 0)) {
                        if(in==1)
                            value=pfind.getValidatedInMobileNotnominal();
                        else
                            value =pfind.getValidatedOutMobileNotnominal();
                    break;
                    }
                    
                     if ((nominal == 0) && (card == 1)) {
                        if(in==1)
                            value=pfind.getValidatedInCardNotnominal();
                        else
                            value =pfind.getValidatedOutCardNotnominal();
                    break;
                    }
                    
            }

             ValueOnChart vom = new ValueOnChart(st, value);
             lvoc.add(vom);
        }
        
         return lvoc;
    }
}
