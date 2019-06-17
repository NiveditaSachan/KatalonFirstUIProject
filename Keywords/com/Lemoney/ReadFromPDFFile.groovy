package com.Lemoney

import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.text.PDFTextStripper
import org.testng.Assert
import org.testng.annotations.Test;
import com.kms.katalon.core.annotation.Keyword
import java.lang.String
import java.lang.CharSequence

public class ReadFromPDFFile {

	@Keyword

	def ReadPDF(String PDFURL) {
		URL TestURL = new URL(PDFURL);
		BufferedInputStream bis = new BufferedInputStream(TestURL.openStream());
		PDDocument doc = PDDocument.load(bis);
		String pdfText = new PDFTextStripper().getText(doc);
		doc.close();
		bis.close();
		assert pdfText.contains("Payment Modification post order placement")
		assert pdfText.contains('Orders under this transaction')
		return pdfText
	}
}
