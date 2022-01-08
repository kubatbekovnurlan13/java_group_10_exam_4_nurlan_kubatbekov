package edu1;

public class Printer {
    public static void printCat(int index, Cat cat) {
        String format = " | %-4s | %-10s | %-4s | %-7s | %-4s | %-8s | %-14s | ";
        System.out.println(String.format(
                format,
                index,
                cat.getName(),
                cat.getAge(),
                cat.getHealth(),
                cat.getMood(),
                cat.getSatiety(),
                cat.getAverageLevel()));
    }

    public static void printHeader() {
        String format = " | %-4s | %-10s | %-4s | %-7s | %-4s | %-8s | %-14s | ";
        String line = " ------------------------------------------------------------------------ ";
        System.out.println(line);
        System.out.println(String.format(
                format,
                "#",
                "Name",
                "Age",
                "Health",
                "Mood",
                "Satiety",
                "Average Level"));
        System.out.println(line);
    }

    public static void printCat(Cat cat) {
    }
}
