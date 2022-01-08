package edu1;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>(3);
        cats.add(new Cat("Cat 1", 14, 80, 80, 80));
        cats.add(new Cat("Cat 2", 10, 50, 90, 90));
        cats.add(new Cat("Cat 3", 17, 40, 30, 40));
        cats.add(new Cat("Cat 4", 13, 70, 70, 70));
        cats.add(new Cat("Cat 5", 9, 60, 60, 60));


        Cat newCat = inputCat();
        cats.add(newCat);

        Printer.printHeader();
        cats.sort(Cat::sortByAverageLevel);
        cats.forEach(c -> {
            Printer.printCat(cats.indexOf(c), c);
        });


    }

    public static Cat inputCat() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter cat name: ");
        String inputName = sc.nextLine();
        System.out.print("Enter age of cat: ");
        String inputAge = sc.nextLine();
        int intInputAge = 0;
        try {
            if (inputName.isBlank()) {
                throw new Exception("Please enter name!");
            }
            intInputAge = tryInt(inputAge);
            if (intInputAge > 18 || intInputAge <= 0) {
                throw new IllegalArgumentException("Age range 1-18!");
            }
        } catch (ParseException e) {
            System.out.println("Please enter age!");
            inputCat();
        } catch (Exception iae) {
            System.out.println(iae.getMessage());
            inputCat();
        }
        Random rnd = new Random();

        int satiety = rnd.nextInt(80) + 20;
        int mood = rnd.nextInt(80) + 20;
        int health = rnd.nextInt(80) + 20;

        Cat newCat = new Cat(inputName, intInputAge, satiety, mood, health);
        return newCat;
    }

    public static int tryInt(String birth) throws ParseException {
        NumberFormat nf = NumberFormat.getIntegerInstance();
        return nf.parse(birth).intValue();
    }
}
