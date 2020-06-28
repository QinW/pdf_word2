package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PDFBoxReader {

    public static String readText(final String path, Integer startPage, Integer endPage) {
        PDDocument document = null;
        PDFTextStripper textStripper= null;
        try {
            document = PDDocument.load(new File(path));
            textStripper = new PDFTextStripper();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        String string = "";
        if (null != document && null != textStripper) {
            final int numberOfPages = document.getNumberOfPages();
            if (null != startPage) {
                textStripper.setStartPage(startPage);
            }
            textStripper.setEndPage(null == endPage || endPage > numberOfPages ? numberOfPages : endPage);
            try {
                string = textStripper.getText(document);
                document.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return string;
    }

    public static String readText(final String path, Integer page) {
        return readText(path, page, page);
    }

    public static String readText(final String path) {
        return readText(path, null);
    }
}
