/*
 * ETS Project
 * Reporter Service 2018 Updates
 */
package org.reporter.service.ets_reports.pattern;

import java.time.LocalTime;

/**
 *
 * @author constantinn
 * Class used to store the elements which define a pattern
 * 
 */
public class PatternElement {
    
    
    private LocalTime defTime;
    private Long validatedInCardNominal;
    private Long validatedInCardNotnominal;
    private Long validatedInMobileNominal; 
    private Long validatedInMobileNotnominal; 
    
    private Long validatedOutCardNominal;
    private Long validatedOutCardNotnominal;
    private Long validatedOutMobileNominal; 
    private Long validatedOutMobileNotnominal; 
    
    private Long durationCard;
    private Long durationMobile;
    
    private Long noFraudulents;
    private Long noKioskActions;
    
    private Long noFaceRecognitionsOK;
    private Long noFaceRecognitionsNOK;
    private Long noFaceRecognitionsERROR;
    
    public PatternElement(){
        defTime = LocalTime.MIN;
    }
    
     public PatternElement(LocalTime lt){
        defTime = lt;
    }
     
public void generateValues(int startHour, int step, PatternMask [] mask){

    double xxStart;
    double xxEnd;
     xxStart=mask[startHour].minVal/60.*step;
     xxEnd=mask[startHour].maxVal/60.*step;
     
     this.validatedInCardNominal = randomize(xxStart, xxEnd, 40./3.);
     this.validatedInCardNotnominal=randomize(xxStart, xxEnd, 40./3./9.);
     
     this.validatedInMobileNominal = randomize(xxStart, xxEnd, 40.);
     this.validatedInMobileNotnominal = randomize(xxStart, xxEnd, 40./9.);
     
     this.validatedOutCardNominal = randomize(xxStart, xxEnd, 40./3.);
     this.validatedOutCardNotnominal=randomize(xxStart, xxEnd, 40./3./9.);
     
     this.validatedOutMobileNominal = randomize(xxStart, xxEnd, 40.);
     this.validatedOutMobileNotnominal = randomize(xxStart, xxEnd, 40./9.);
     
     this.durationCard = randomize(5, 90, 1.);
     this.durationMobile =randomize(10, 100, 1.);
     
     this.noFraudulents = randomize(0, 60./step, 10.);
     
     this.noFaceRecognitionsOK=randomize(xxStart, xxEnd,1000./95.);
     this.noFaceRecognitionsNOK=randomize(xxStart, xxEnd,1000./3.);
     this.noFaceRecognitionsERROR=randomize(xxStart, xxEnd,1000./2.);
     
     this.noKioskActions  =randomize(xxStart, xxEnd,4.);
     
}

    public long randomize(double start, double end, double divisor){
        double d =(Math.random() * (end-start) + start+divisor-1)/divisor;
        return (long) d;
    }
    
    /**
     * @return the defTime
     */
    public LocalTime getDefTime() { 
        return defTime;
    }

    /**
     * @param defTime the defTime to set
     */
    public void setDefTime(LocalTime defTime) {
        this.defTime = defTime;
    }

    /**
     * @return the validatedInCardNominal
     */
    public Long getValidatedInCardNominal() {
        return validatedInCardNominal;
    }

    /**
     * @param validatedInCardNominal the validatedInCardNominal to set
     */
    public void setValidatedInCardNominal(Long validatedInCardNominal) {
        this.validatedInCardNominal = validatedInCardNominal;
    }

    /**
     * @return the validatedInCardNotnominal
     */
    public Long getValidatedInCardNotnominal() {
        return validatedInCardNotnominal;
    }

    /**
     * @param validatedInCardNotnominal the validatedInCardNotnominal to set
     */
    public void setValidatedInCardNotnominal(Long validatedInCardNotnominal) {
        this.validatedInCardNotnominal = validatedInCardNotnominal;
    }

    /**
     * @return the validatedInMobileNominal
     */
    public Long getValidatedInMobileNominal() {
        return validatedInMobileNominal;
    }

    /**
     * @param validatedInMobileNominal the validatedInMobileNominal to set
     */
    public void setValidatedInMobileNominal(Long validatedInMobileNominal) {
        this.validatedInMobileNominal = validatedInMobileNominal;
    }

    /**
     * @return the validatedInMobileNotnominal
     */
    public Long getValidatedInMobileNotnominal() {
        return validatedInMobileNotnominal;
    }

    /**
     * @param validatedInMobileNotnominal the validatedInMobileNotnominal to set
     */
    public void setValidatedInMobileNotnominal(Long validatedInMobileNotnominal) {
        this.validatedInMobileNotnominal = validatedInMobileNotnominal;
    }

    /**
     * @return the validatedOutCardNominal
     */
    public Long getValidatedOutCardNominal() {
        return validatedOutCardNominal;
    }

    /**
     * @param validatedOutCardNominal the validatedOutCardNominal to set
     */
    public void setValidatedOutCardNominal(Long validatedOutCardNominal) {
        this.validatedOutCardNominal = validatedOutCardNominal;
    }

    /**
     * @return the validatedOutCardNotnominal
     */
    public Long getValidatedOutCardNotnominal() {
        return validatedOutCardNotnominal;
    }

    /**
     * @param validatedOutCardNotnominal the validatedOutCardNotnominal to set
     */
    public void setValidatedOutCardNotnominal(Long validatedOutCardNotnominal) {
        this.validatedOutCardNotnominal = validatedOutCardNotnominal;
    }

    /**
     * @return the validatedOutMobileNominal
     */
    public Long getValidatedOutMobileNominal() {
        return validatedOutMobileNominal;
    }

    /**
     * @param validatedOutMobileNominal the validatedOutMobileNominal to set
     */
    public void setValidatedOutMobileNominal(Long validatedOutMobileNominal) {
        this.validatedOutMobileNominal = validatedOutMobileNominal;
    }

    /**
     * @return the validatedOutMobileNotnominal
     */
    public Long getValidatedOutMobileNotnominal() {
        return validatedOutMobileNotnominal;
    }

    /**
     * @param validatedOutMobileNotnominal the validatedOutMobileNotnominal to set
     */
    public void setValidatedOutMobileNotnominal(Long validatedOutMobileNotnominal) {
        this.validatedOutMobileNotnominal = validatedOutMobileNotnominal;
    }

    /**
     * @return the durationCard
     */
    public Long getDurationCard() {
        return durationCard;
    }

    /**
     * @param durationCard the durationCard to set
     */
    public void setDurationCard(Long durationCard) {
        this.durationCard = durationCard;
    }

    /**
     * @return the durationMobile
     */
    public Long getDurationMobile() {
        return durationMobile;
    }

    /**
     * @param durationMobile the durationMobile to set
     */
    public void setDurationMobile(Long durationMobile) {
        this.durationMobile = durationMobile;
    }

    /**
     * @return the noFraudulents
     */
    public Long getNoFraudulents() {
        return noFraudulents;
    }

    /**
     * @param noFraudulents the noFraudulents to set
     */
    public void setNoFraudulents(Long noFraudulents) {
        this.noFraudulents = noFraudulents;
    }

    /**
     * @return the noKioskActions
     */
    public Long getNoKioskActions() {
        return noKioskActions;
    }

    /**
     * @param noKioskActions the noKioskActions to set
     */
    public void setNoKioskActions(Long noKioskActions) {
        this.noKioskActions = noKioskActions;
    }

    /**
     * @return the noFaceRecognitionsOK
     */
    public Long getNoFaceRecognitionsOK() {
        return noFaceRecognitionsOK;
    }

    /**
     * @param noFaceRecognitionsOK the noFaceRecognitionsOK to set
     */
    public void setNoFaceRecognitionsOK(Long noFaceRecognitionsOK) {
        this.noFaceRecognitionsOK = noFaceRecognitionsOK;
    }

    /**
     * @return the noFaceRecognitionsNOK
     */
    public Long getNoFaceRecognitionsNOK() {
        return noFaceRecognitionsNOK;
    }

    /**
     * @param noFaceRecognitionsNOK the noFaceRecognitionsNOK to set
     */
    public void setNoFaceRecognitionsNOK(Long noFaceRecognitionsNOK) {
        this.noFaceRecognitionsNOK = noFaceRecognitionsNOK;
    }

    /**
     * @return the noFaceRecognitionsERROR
     */
    public Long getNoFaceRecognitionsERROR() {
        return noFaceRecognitionsERROR;
    }

    /**
     * @param noFaceRecognitionsERROR the noFaceRecognitionsERROR to set
     */
    public void setNoFaceRecognitionsERROR(Long noFaceRecognitionsERROR) {
        this.noFaceRecognitionsERROR = noFaceRecognitionsERROR;
    }
   
    
    
    
}
