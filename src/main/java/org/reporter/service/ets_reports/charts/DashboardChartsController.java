package org.reporter.service.ets_reports.charts;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.imageio.ImageIO;
import javax.inject.Named;
import javax.servlet.ServletContext;
import org.apache.poi.util.IOUtils;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;
import org.reporter.service.ets_reports.ChartTimeInfo;
import org.reporter.service.ets_reports.DashboardInfo;
import org.reporter.service.ets_reports.util.Constants;

/**
 *
 * @author constantinn
 */
@Named("dashboardChartsController")
@ViewScoped
public class DashboardChartsController implements Serializable{

    private BarChartModel passengersInStationBarChart;
    private LineChartModel passengersInStationLineChart;
    private PieChartModel totalPassengersInStationPieChart;
    private List<ChartTimeInfo> listChartSeriesValues;
    
    private StreamedContent lineChartPdf;
    private StreamedContent pieChartPdf;
    
    public DashboardChartsController(){}
    
    @PostConstruct
    public void init(){
        initBarCharts();
//        initAreaCharts();
        createAreaChartModel();
        
    }
    
    /**
     * Initializes all dashboard charts (barchart+piechart)
     */
    public void initBarCharts(){
        //init passengersInStationBarChart
        // ic to do replace this
        listChartSeriesValues =  readChartValues();
        
        passengersInStationBarChart = new BarChartModel();
        passengersInStationBarChart.setLegendPosition("ne");
        passengersInStationBarChart.getAxis(AxisType.X).setLabel("Period");
        passengersInStationBarChart.getAxis(AxisType.Y).setLabel("Number of passengers");
        passengersInStationBarChart.setShadow(false);
        passengersInStationBarChart.setSeriesColors("D32527, 60b53f");
        ChartSeries fraudulents = new ChartSeries("Fraudulents");
        ChartSeries nonFraudulents = new ChartSeries("Non-fraudulents");
        
//        fraudulents.set("14:00", 10);
//        fraudulents.set("15:00", 25);
//        fraudulents.set("16:00", 45);
//        nonFraudulents.set("14:00", 35);
//        nonFraudulents.set("15:00", 20);
//        nonFraudulents.set("16:00", 5);
        
        long noNonFraudulents=0l;
        long noFraudulents=0l;

        for (ChartTimeInfo cit : listChartSeriesValues){
             fraudulents.set(cit.getSeriesDate(), cit.getSeries2Value());
             nonFraudulents.set(cit.getSeriesDate(), cit.getSeries1Value());
             noNonFraudulents = noNonFraudulents + cit.getSeries1Value();
             noFraudulents = noFraudulents + cit.getSeries2Value();
        }
        
        
        passengersInStationBarChart.addSeries(fraudulents);
        passengersInStationBarChart.addSeries(nonFraudulents);
        passengersInStationBarChart.setExtender("chartExtender");
        
        //init totalPassengersInStationPieChart
        totalPassengersInStationPieChart = new PieChartModel();
        totalPassengersInStationPieChart.setShadow(false);
        totalPassengersInStationPieChart.setSeriesColors(Constants.CHART_SERIES_COLORS);
        totalPassengersInStationPieChart.setLegendPosition("ne");
        totalPassengersInStationPieChart.setExtender("etsExtender");
        totalPassengersInStationPieChart.setShowDataLabels(true);
        totalPassengersInStationPieChart.set("Non-fraudulents", noNonFraudulents);
        totalPassengersInStationPieChart.set("Fraudulents", noFraudulents);
    }
    public void initAreaCharts(){
        //init passengersInStationBarChart
        // ic to do replace this
       listChartSeriesValues =  readChartValues();
       
        
       passengersInStationLineChart = new LineChartModel();
       passengersInStationLineChart.setLegendPosition("ne");
       passengersInStationLineChart.getAxis(AxisType.X).setLabel("Period");
       passengersInStationLineChart.getAxis(AxisType.Y).setLabel("Number of passengers");
       passengersInStationLineChart.setShadow(false);
       passengersInStationLineChart.setSeriesColors("D32527, 60b53f");
       LineChartSeries fraudulents = new LineChartSeries("Fraudulents");
       LineChartSeries nonFraudulents = new LineChartSeries("Non-fraudulents");
       fraudulents.setFill(true);
       nonFraudulents.setFill(false);
       passengersInStationLineChart.setStacked(true);
        
//        fraudulents.set("14:00", 10);
//        fraudulents.set("15:00", 25);
//        fraudulents.set("16:00", 45);
//        nonFraudulents.set("14:00", 35);
//        nonFraudulents.set("15:00", 20);
//        nonFraudulents.set("16:00", 5);
        
       long noNonFraudulents=0l;
       long noFraudulents=0l;
       for (ChartTimeInfo cit : listChartSeriesValues){
            fraudulents.set(cit.getSeriesDate(), cit.getSeries2Value());
            nonFraudulents.set(cit.getSeriesDate(), cit.getSeries1Value());
            noNonFraudulents = noNonFraudulents + cit.getSeries1Value();
            noFraudulents = noFraudulents + cit.getSeries2Value();
        }
        
        
        passengersInStationLineChart.addSeries(fraudulents);
        passengersInStationLineChart.addSeries(nonFraudulents);
        
        Axis xAxis = new CategoryAxis("XAXIS");
        passengersInStationLineChart.getAxes().put(AxisType.X, xAxis);
        Axis yAxis = passengersInStationLineChart.getAxis(AxisType.Y);
        yAxis.setLabel("YAXIS");
    }
    public void createAreaChartModel(){
        passengersInStationLineChart = new LineChartModel();
        passengersInStationLineChart.setLegendPosition("ne");
        passengersInStationLineChart.setAnimate(Constants.ANIMATE_CHART);
        passengersInStationLineChart.setExtender("etsExtender");
        passengersInStationLineChart.setStacked(true);
        passengersInStationLineChart.setSeriesColors(Constants.CHART_SERIES_COLORS);
//        passengersInStationLineChart.setShowPointLabels(true); //DOESN'T EXPORT CHART
        Axis xAxis = new CategoryAxis("Period");
        xAxis.setTickAngle(-30);
        passengersInStationLineChart.getAxes().put(AxisType.X, xAxis);
        Axis yAxis = passengersInStationLineChart.getAxis(AxisType.Y);
        yAxis.setLabel("Number of passengers");
        
        LineChartSeries fraudulentsSeries = new LineChartSeries("Fraudulents");
        fraudulentsSeries.setFill(true);
        LineChartSeries nonFraudulentsSeries = new LineChartSeries("Non-fraudulents");
        nonFraudulentsSeries.setFill(true);
        
        listChartSeriesValues = readChartValues();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    
    
        for(ChartTimeInfo cti : listChartSeriesValues){
            cti.getSeriesDate().setYear(2017);
            fraudulentsSeries.set(sdf.format(cti.getSeriesDate()), cti.getSeries2Value());
            nonFraudulentsSeries.set(sdf.format(cti.getSeriesDate()), cti.getSeries1Value());
        }
//        for(int i=0;i<12;i++){
//            
//            if(i%2==0){
//                fraudulentsSeries.set(i, i+50);
//                nonFraudulentsSeries.set(i, i+25+2*i);
//            }else{
//                fraudulentsSeries.set(i, i+100);
//                nonFraudulentsSeries.set(i, i+50+2*i);
//            }
//            
//            
//        }
        

        passengersInStationLineChart.addSeries(nonFraudulentsSeries);
        passengersInStationLineChart.addSeries(fraudulentsSeries);
    }

    /**
     * Exports a chart to .pdf
     * Chart image is received converted to base64
     */
    public void exportChartPDFRCLine(){
        String etsChartJson = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("etsChart");
        
        //get ets chart
        ObjectMapper objectMapper = new ObjectMapper();
        EtsChart etsChart = null;
        try{
            etsChart = objectMapper.readValue(etsChartJson, EtsChart.class);
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        
        if(etsChart==null){
            System.out.println("Could not export .PDF chart");
            return;
        }
        
        
        if(etsChart.getSrcBase64()!=null){
            String base64ChartImg = etsChart.getSrcBase64().split(",")[1];
            byte[] imagesBytes = Base64.getDecoder().decode(base64ChartImg);
            try{
                //build .PDF
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                Document document = new Document(PageSize.A4.rotate(),25,25,30,30); 
                PdfWriter.getInstance(document, out);
                document.open();
                
                //add pdf header
                //-top rectangle bar
                Rectangle topBarRectangle = new Rectangle(0, document.getPageSize().getHeight()-60, document.getPageSize().getWidth(), document.getPageSize().getHeight());
                topBarRectangle.setBackgroundColor(java.awt.Color.decode("#eeeeee"));
                
                //-ets logo
                InputStream logoInputStream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/images/ets-logo.png");
                byte[] etsLogoByteArray = IOUtils.toByteArray(logoInputStream);
                Image etsLogoImage = Image.getInstance(etsLogoByteArray);
                etsLogoImage.scaleAbsolute((etsLogoImage.getWidth() - etsLogoImage.getWidth()/4), (etsLogoImage.getHeight() - etsLogoImage.getHeight()/4));
                etsLogoImage.setAbsolutePosition(30, document.getPageSize().getHeight()-etsLogoImage.getHeight()-18);
                
                BufferedImage before = ImageIO.read(new ByteArrayInputStream(imagesBytes));
                Image chartImage = Image.getInstance(imagesBytes);
                chartImage.setAlignment(Element.ALIGN_CENTER);
                chartImage.scaleAbsolute((before.getWidth()-before.getWidth()/4), (before.getHeight()-before.getHeight()/4f));
                
                //get font path
                String relativeFontPath = "/resources/fonts/arial.ttf";
                ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
                String absoluteFontPath = servletContext.getRealPath(relativeFontPath);
                
                BaseFont bf = BaseFont.createFont(absoluteFontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                Paragraph chartHeadlineParagraph = new Paragraph(etsChart.getChartDescription(), new Font(bf, 12));
                chartHeadlineParagraph.setAlignment(Element.ALIGN_CENTER);
                
                document.add(createPeriodTable(etsChart.getStartDate(), etsChart.getEndDate()));
                document.add(etsLogoImage);
                document.add(new Paragraph("  "));
                document.add(new Paragraph("  "));
                document.add(new Paragraph("  "));
                document.add(chartHeadlineParagraph);
                document.add(chartImage);
                document.close();

                //download pdf
                InputStream pdfInputStream = new ByteArrayInputStream(out.toByteArray());
                lineChartPdf = new DefaultStreamedContent(pdfInputStream, "application/pdf", "ets-line-chart.pdf");
            }catch(DocumentException de){
                de.printStackTrace();
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        }
    }
    private static String encodeUTF8(String inputString){
        try{
            if (inputString.length() == 0){
                inputString = " ";
            }
            byte[] arrayAux = inputString.getBytes("ISO-8859-1");
            String stringOUT = new String(arrayAux, "UTF-8");
            return stringOUT;
        }
        catch(IOException error){
            System.err.println(error.getMessage());
            return "";
        }
    }
    
    public void exportChartPDFRCPie(){
        String etsChartJson = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("etsChart");
        
        //get ets chart
        ObjectMapper objectMapper = new ObjectMapper();
        EtsChart etsChart = null;
        try{
            etsChart = objectMapper.readValue(etsChartJson, EtsChart.class);
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        
        if(etsChart==null){
            System.out.println("Could not export .PDF chart");
            return;
        }
        
        
        if(etsChart.getSrcBase64()!=null){
            String base64ChartImg = etsChart.getSrcBase64().split(",")[1];
            byte[] imagesBytes = Base64.getDecoder().decode(base64ChartImg);
            try{
                //build .PDF
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                Document document = new Document(PageSize.A4.rotate(),25,25,30,30); 
                PdfWriter.getInstance(document, out);
                document.open();
                
                //add pdf header
                //-top rectangle bar
                Rectangle topBarRectangle = new Rectangle(0, document.getPageSize().getHeight()-60, document.getPageSize().getWidth(), document.getPageSize().getHeight());
                topBarRectangle.setBackgroundColor(java.awt.Color.decode("#eeeeee"));
                
                //-ets logo
                InputStream logoInputStream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/images/ets-logo.png");
                byte[] etsLogoByteArray = IOUtils.toByteArray(logoInputStream);
                Image etsLogoImage = Image.getInstance(etsLogoByteArray);
                etsLogoImage.scaleAbsolute((etsLogoImage.getWidth() - etsLogoImage.getWidth()/4), (etsLogoImage.getHeight() - etsLogoImage.getHeight()/4));
                etsLogoImage.setAbsolutePosition(30, document.getPageSize().getHeight()-etsLogoImage.getHeight()-18);
                
                BufferedImage before = ImageIO.read(new ByteArrayInputStream(imagesBytes));
                Image chartImage = Image.getInstance(imagesBytes);
                chartImage.setAlignment(Element.ALIGN_CENTER);
                chartImage.scaleAbsolute((before.getWidth()-before.getWidth()/4), (before.getHeight()-before.getHeight()/4f));
                
                
                Paragraph chartHeadlineParagraph = new Paragraph(etsChart.getChartDescription());
                chartHeadlineParagraph.setAlignment(Element.ALIGN_CENTER);
                
                document.add(createPeriodTable(etsChart.getStartDate(), etsChart.getEndDate()));
                document.add(etsLogoImage);
                document.add(new Paragraph("  "));
                document.add(new Paragraph("  "));
                document.add(new Paragraph("  "));
                document.add(chartHeadlineParagraph);
                document.add(chartImage);
                document.close();

                //download pdf
                InputStream pdfInputStream = new ByteArrayInputStream(out.toByteArray());
                pieChartPdf = new DefaultStreamedContent(pdfInputStream, "application/pdf", "ets-line-chart.pdf");
            }catch(DocumentException de){
                de.printStackTrace();
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        }
        
        
    }
    
    public static PdfPTable createPeriodTable(String start_date, String end_date) {
        float fontSize = 9f;
        
    	PdfPTable table = new PdfPTable(2);
        table.setHorizontalAlignment(Element.ALIGN_RIGHT);
        table.setTotalWidth(250);
        table.setLockedWidth(true);
        
        PdfPCell cell;
        //add a cell with rowspan 2
        cell = new PdfPCell();
        cell.setUseVariableBorders(true);
        
        PdfPCell startDateCellLabel = new PdfPCell(new Phrase("Start period",FontFactory.getFont(FontFactory.HELVETICA, fontSize+1)));
        startDateCellLabel.setUseVariableBorders(true);
        startDateCellLabel.setHorizontalAlignment(Element.ALIGN_CENTER);
        startDateCellLabel.setPaddingBottom(5);
        
        PdfPCell endDateCellLabel = new PdfPCell(new Phrase("End period",FontFactory.getFont(FontFactory.HELVETICA, fontSize+1)));
        endDateCellLabel.setUseVariableBorders(true);
        endDateCellLabel.setHorizontalAlignment(Element.ALIGN_CENTER);
        endDateCellLabel.setPaddingBottom(5);
        
        table.addCell(startDateCellLabel);
        table.addCell(endDateCellLabel);
        
        //add a cell with rowspan 2
        cell = new PdfPCell();
        cell.setUseVariableBorders(true);
        cell.setBorderColor(java.awt.Color.yellow);
        cell.setRowspan(2);
        
        PdfPCell startDateCell = new PdfPCell(new Phrase(start_date,FontFactory.getFont(FontFactory.HELVETICA, fontSize)));
        startDateCell.setUseVariableBorders(true);
        startDateCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        startDateCell.setPaddingBottom(5);
        
        PdfPCell endDateCell = new PdfPCell(new Phrase(end_date,FontFactory.getFont(FontFactory.HELVETICA, fontSize)));
        endDateCell.setUseVariableBorders(true);
        endDateCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        endDateCell.setPaddingBottom(5);
        
        table.addCell(startDateCell);
        table.addCell(endDateCell);
        return table;
    }

   
    
    public StreamedContent getLineChartPdf() {
        return lineChartPdf;
    }
    public void setLineChartPdf(StreamedContent lineChartPdf) {
        this.lineChartPdf = lineChartPdf;
    }
    public StreamedContent getPieChartPdf() {
        return pieChartPdf;
    }
    public void setPieChartPdf(StreamedContent pieChartPdf) {
        this.pieChartPdf = pieChartPdf;
    }
    /**
     * @return the passengersInStationLineChart
     */
    public LineChartModel getPassengersInStationLineChart() {
        return passengersInStationLineChart;
    }
    /**
     * @param passengersInStationLineChart the passengersInStationLineChart to set
     */
    public void setPassengersInStationLineChart(LineChartModel passengersInStationLineChart) {
        this.passengersInStationLineChart = passengersInStationLineChart;
    }
    public DashboardInfo getDashboardInfo(){
        DashboardInfo di = new DashboardInfo();
        return di;
    }
    public BarChartModel getPassengersInStationBarChart() {
        return passengersInStationBarChart;
    }
    public void setPassengersInStationBarChart(BarChartModel passengersInStationBarChart) {
        this.passengersInStationBarChart = passengersInStationBarChart;
    }
    public PieChartModel getTotalPassengersInStationPieChart() {
        return totalPassengersInStationPieChart;
    }
    public void setTotalPassengersInStationPieChart(PieChartModel totalPassengersInStationPieChart) {
        this.totalPassengersInStationPieChart = totalPassengersInStationPieChart;
    }
    private List<ChartTimeInfo> readChartValues(){
        List<ChartTimeInfo> lcti = new ArrayList<>();
        Date ds= new Date(2017, 10, 19);
        Calendar c = Calendar.getInstance();
        c.setTime(ds);
        
        for(int i=0; i<25; i++){
            ChartTimeInfo cti = new ChartTimeInfo();
            c.add(Calendar.HOUR, 1);
            cti.setSeriesDate(c.getTime());
            lcti.add(cti);
        }
        return lcti;
    }
    
    
}
