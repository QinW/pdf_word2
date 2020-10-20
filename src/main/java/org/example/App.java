package org.example;

import java.util.*;
import java.util.regex.Pattern;

public class App {

    public static final String CONTENT_PDF = "C:\\Users\\td_qinwei\\OneDrive\\Documents\\SD_BOOK\\技术_数据库\\Teradata Database 15.10\\Database Design.pdf";

    public static void main( String[] args ) {

        final Map<String, Integer> map = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        final Pattern pattern = Pattern.compile("[^a-zA-Z]");
        final Pattern pattern1 = Pattern.compile("[a-zA-Z]");
        for(String word: PDFBoxReader.readText(CONTENT_PDF).split(" ")) {
            if (pattern1.matcher(word).find()) {
                if (pattern.matcher(word).find()) {
                    word = word.replaceAll("[^a-zA-Z]", "");
                }
                map.put(word, map.containsKey(word) ? map.get(word) + 1 : 1);
            }
        }

        final List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        System.out.println("========== Start =========");
        System.out.println(list);
        System.out.println("==========  End  =========");
    }
}
