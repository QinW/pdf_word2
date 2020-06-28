package org.example;

import java.util.*;

public class App {

    public static final String CONTENT_PDF = "C:\\Users\\td_qinwei\\OneDrive\\Documents\\SD_BOOK\\技术_数据库\\Teradata Database 15.10\\Database Design.pdf";


    public static void printMap(Map<String, Integer> map) {
    /*
    map = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));
        */
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue() + "," + containsCharacter(entry.getValue().toString()));
        }
    }

    public static String[] splitString(String string) {
        final Set<String> caseInsensitiveSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        caseInsensitiveSet.addAll(Arrays.asList(string.split(" ")));
        return caseInsensitiveSet.toArray(new String[0]);
    }

    public static boolean containsCharacter(String string) {
        return string.matches("\\w");
    }

    public static void main( String[] args ) {

        String original = PDFBoxReader.readText(CONTENT_PDF, 2);
        final String[] strings = splitString(original);
        final Map<String, Integer> map = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        for(String word: strings) {
            map.put(word, map.containsKey(word) ? map.get(word) + 1 : 1);
        }
        //String now = original.replaceAll("[^(A-Za-z)]", "");
        System.out.println(original);
    }
}
