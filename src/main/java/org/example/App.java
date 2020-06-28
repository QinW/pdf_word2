package org.example;

import java.util.*;

public class App {

    public static final String CONTENT_PDF = "C:\\Users\\td_qinwei\\OneDrive\\Documents\\SD_BOOK\\技术_数据库\\Teradata Database 15.10\\Database Design.pdf";

    public static void main( String[] args ) {

        final Map<String, Integer> map = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

        for(String word: PDFBoxReader.readText(CONTENT_PDF).split(" ")) {
            if (word.contains(",")) {
                word = word.replaceAll(",", "");
            } else if (word.contains("\n")) {
                word = word.replaceAll("\n", "");
            } else if (word.contains(".")) {
                word = word.replaceAll(".", "");
            }
            if (word.length() > 2) {
                map.put(word, map.containsKey(word) ? map.get(word) + 1 : 1);
            }
            if (word.contains("\n")) {
                System.out.println("{[" + word + "],,,,,,[" + word.replaceAll("\n", "") + "]}");
            }
        }

        final List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
    }
}
