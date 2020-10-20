package org.example;

public class Eat6 {

    public static final double FEE = 0.55 / 100;


    public static void main( String[] args ) {

        for(int i = 10; i <= 20000 * 0.4; i++) {
            if (i % 6 == 0) {
                double j = FEE * i;
                double x = i - j;
                String j_str= String.valueOf(j);
                if (3 == j_str.substring(j_str.indexOf(".")).length()) {
                    System.out.println(i + ", " + j + ", " + x);
                }

            }
        }
    }
}
