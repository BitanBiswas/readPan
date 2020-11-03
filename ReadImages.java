package com.tainer.readImage;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ReadImages {

	public static void main(String[] args) throws IOException {
		
		ITesseract image = new Tesseract();
		try {
			
			String myPanText = image.doOCR(new File("D:\\Study Material\\OCR\\Images\\BitanPan.png"));
		//	String dadPanText = image.doOCR(new File("D:\\Study Material\\OCR\\Images\\DadPan.png"));
		//	String momPanText = image.doOCR(new File("D:\\Study Material\\OCR\\Images\\MomPan.png"));
			
		 BufferedReader br = new BufferedReader(new StringReader(myPanText));

		        String namerequired=null, panNumber=null;
		        String line;
		        int counter = 0;
		        while ((line = br.readLine()) != null) {
		            if (counter == 3) {
		                namerequired = line;
		            }
		            if (counter == 7) {
		            	panNumber = line;
		            }
		            counter++;
		        }
			
			System.out.println("My pan card details \n "+myPanText);
			System.out.println("The name is --> "+namerequired);
			System.out.println("The pan card number is --> "+panNumber);
			System.out.println("**************************************************");
			//System.out.println("Dad's pan card details \n "+dadPanText);
			System.out.println("**************************************************");
			//System.out.println("Mom pan card details \n "+momPanText);
			System.out.println("**************************************************");
		
		} catch (TesseractException e) {
			
			System.out.println("Exception "+ e );
			e.printStackTrace();
		}
				
	}

}
