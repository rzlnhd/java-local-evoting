/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.util;

import com.voting.model.master.Pemilih;
import com.voting.model.master.Tps;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDPushButton;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;
import org.apache.pdfbox.printing.PDFPrintable;

/**
 *
 * @author Rizal
 */
public class PrintUtils{
    static PDDocument  pdfDocument;
    static Map<String, String> data = new HashMap<>();
    private static URL url;
    static BufferedImage qr;
    
    public static void printData(Pemilih p, BufferedImage img, int urut) throws IOException, PrinterException{
        Tps t=p.getTpsCode();
        String u = String.valueOf(urut),tp=t.getNo(),urt="",tp_="";
        for(int i=0; i<(3-u.length());i++){urt+="0";}urt+=u;
        for(int i=0; i<(3-tp.length());i++){tp_+="0";}tp_+=tp;
        url = new URL("http://192.168.137.1/voting/aset/program/print_form.pdf");
        HttpURLConnection connection=(HttpURLConnection)url.openConnection();
        InputStream is=connection.getInputStream();
        pdfDocument = PDDocument.load(is);qr=img;
        
        data.put("nama", p.getNama());
        data.put("jk", p.getJenisKelamin());
        data.put("urut", urt);
        data.put("induk", p.getInduk());        
        data.put("tgl", "Null");        
        data.put("jam", "07.00 s.d 13.00 WIB");
        data.put("no_tps", tp_);
        data.put("kel_tps", t.getDesCode().getNilai());
        data.put("alamat_tps_0", p.getTpsCode().getDesk());
        data.put("tgl_cetak", ""+t.getKecCode().getNilai()+", "+setDate()+".");
        data.put("qr_code_af_image", "");
        
        fillForm(pdfDocument);
    }
    
    private static void fillForm(PDDocument document) throws IOException, PrinterException{        
        PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();
        for (Map.Entry<String, String> item : data.entrySet()) {
            String key = item.getKey();
            PDField field = acroForm.getField(key);
            
            if (field instanceof PDTextField) {
                field.setValue(item.getValue());
            } else if (field instanceof PDPushButton) {
                PDPushButton pdPushButton = (PDPushButton) field;                
                List<PDAnnotationWidget> widgets = pdPushButton.getWidgets();
                if (widgets != null && widgets.size() > 0) {
                    PDAnnotationWidget annotationWidget = widgets.get(0);
                    PDImageXObject pdImageXObject = LosslessFactory.createFromImage(document, qr);
                    float imageScaleRatio = (float) pdImageXObject.getHeight() / (float) pdImageXObject.getWidth();
                    
                    PDRectangle buttonPosition = getFieldArea(pdPushButton);
                    float height = buttonPosition.getHeight();
                    float width = height / imageScaleRatio;
                    float x = buttonPosition.getLowerLeftX();
                    float y = buttonPosition.getLowerLeftY();
                    
                    PDAppearanceStream pdAppearanceStream = new PDAppearanceStream(document);
                    pdAppearanceStream.setResources(new PDResources());
                    try (PDPageContentStream content = new PDPageContentStream(document, pdAppearanceStream)) {
                        content.drawImage(pdImageXObject, x, y, width, height);
                    }                    
                    pdAppearanceStream.setBBox(new PDRectangle(x, y, width, height));
                    PDAppearanceDictionary pdAppearanceDictionary = annotationWidget.getAppearance();
                    if (pdAppearanceDictionary == null) {
                        pdAppearanceDictionary = new PDAppearanceDictionary();
                        annotationWidget.setAppearance(pdAppearanceDictionary);
                    }
                    pdAppearanceDictionary.setNormalAppearance(pdAppearanceStream);
                } else {
                    System.err.println("Missconfiguration of placeholder: '" + key + "' - no widgets(actions) found");
                }
            } else {
                System.err.print("Unexpected form field type found with placeholder name: '" + key + "'");
            }
        }
        printOut(document);
        document.close();
    }

    private static PDRectangle getFieldArea(PDField field) {
        COSDictionary fieldDict = field.getCOSObject();
        COSArray fieldAreaArray = (COSArray) fieldDict.getDictionaryObject(COSName.RECT);
        return new PDRectangle(fieldAreaArray);
    }
    
    private static String setDate(){
        String bulan;
        Date date= new Date();
        System.out.println(date.getMonth());
        switch(date.getMonth()){
            case 0 : bulan="Januari";break;
            case 1 : bulan="Februari";break;
            case 2 : bulan="Maret";break;
            case 3 : bulan="April";break;
            case 4 : bulan="Mei";break;
            case 5 : bulan="Juni";break;
            case 6 : bulan="Juli";break;
            case 7 : bulan="Agustus";break;
            case 8 : bulan="September";break;
            case 9 : bulan="Oktober";break;
            case 10 : bulan="November";break;
            default : bulan="Desember";break;
        }
        return date.getDate()+" "+bulan+" "+(1900+date.getYear());
    }
    
    private static void printOut(PDDocument document) throws IOException, PrinterException{
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable (new PDFPrintable(document));   
        if (job.printDialog()) {
            job.print();
        }
    }
}
