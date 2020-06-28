package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class App {

    public static final String CONTENT_PDF = "C:\\Users\\td_qinwei\\OneDrive\\Documents\\SD_BOOK\\技术_数据库\\Teradata Database 15.10\\Database Design.pdf";
    public static final int START_PAGE = 1;
    public static final int TEST_END_PAGE = 10;

    public static void printMap(Map<String, Integer> map) {
 /*       map = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));*/
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue() + "," + containsCharacter(entry.getValue().toString()));
        }
    }

    public static boolean containsCharacter(String string) {
        return string.matches("\\w");
    }

    public static String[] splitString(String string) {
        final Set<String> caseInsensitiveSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        caseInsensitiveSet.addAll(Arrays.asList(string.split(" ")));
        return caseInsensitiveSet.toArray(new String[0]);
    }

    public static void main( String[] args ) throws IOException {
        final PDDocument document = PDDocument.load(new File(CONTENT_PDF));
        final PDFTextStripper textStripper = new PDFTextStripper();
        final int numberOfPages = document.getNumberOfPages();
        final Map<String, Integer> map = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        for(int page = START_PAGE; page <= TEST_END_PAGE; page++) {
            textStripper.setStartPage(page);
            textStripper.setEndPage(page);
            String original = textStripper.getText(document);
            final String[] strings = splitString(original);
            for(String word: strings) {
                map.put(word, map.containsKey(word) ? map.get(word) + 1 : 1);
            }
            //String now = original.replaceAll("[^(A-Za-z)]", "");
        }
        printMap(map);
        document.close();


    }
}
