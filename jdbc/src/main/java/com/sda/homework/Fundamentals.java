package com.sda.homework;

public class Fundamentals {

    private static int var1;
    private static boolean var2;
    private static double var3;
    private static long var4;

    public static void main(String[] args) {
        testAssignment();
        testRelational();
        testLogical();
        testControlFlow();
        testArray();
        System.out.println(testString());
    }

    private static void testAssignment() {
        var1 = 2;
        var2 = true;
        var3 = 3.66 * 2;
        var4 = 560565265626L;
        System.out.println("var1= " + var1);
        System.out.println("var2= " + var2);
        System.out.println("var3= " + var3);
        System.out.println("var4= " + var4);
    }

    private static void testRelational() {
        System.out.println("var1 > var3: " + (var1 > var3));
        System.out.println("var3 <= var4: " + (var3 <= var4));
    }

    private static void testLogical() {
        System.out.println("var2 && false: " + (var2 && false));
        System.out.println("!var2 || var1<var3: " + (!var2 || var1 < var3));
    }

    private static void testControlFlow() {
        if (var4 > var3) System.out.println("var4 > var3 is true");
        else System.out.println("var4 > var3 is false");

        switch (var1) {
            case 0:
                System.out.println("zero");
                break;
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            default:
                System.out.println("Another number");
                break;
        }

        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        while (var1 < 5) {
            System.out.print(var1 + " ");
            var1++;
        }
        System.out.println();

        do {
            System.out.println(var1 + " ");
            var1++;
        } while (var1 < 2);

        int numere[] = {1, 4, 8, 9, 2,};
        for (int i = 0; i < numere.length; i++) {
            if (numere[i] == 9) {
                break;
            }
            System.out.println("Nr pt break: " + numere[i]);
        }

        for (int j = 0; j < numere.length; j++) {
            if (numere[j] == 8 || numere[j] == 4) {
                continue;
            }
            System.out.println("Nr pt continue: " + numere[j]);
        }
    }

    private static void testArray() {
        int[][] matrix = {{1, 2}, {3, 4}, {5, 6}};
        int rows = matrix.length;
        int columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Printing backwards: ");
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = columns - 1; j >= 0; j--) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static String testString() {
        String text1 = "Java is cool";
        String text2 = text1.concat("!").toUpperCase();
        return text2;
    }
}
