package exam;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        List<Cat> cats = new ArrayList<>(3);
        cats.add(new Cat("Cat 1", 3, 80, 80, 80));
        cats.add(new Cat("Cat 2", 10, 50, 90, 90));
        cats.add(new Cat("Cat 3", 17, 40, 30, 40));
        cats.add(new Cat("Cat 4", 5, 70, 70, 70));
        cats.add(new Cat("Cat 5", 9, 60, 60, 60));

        boolean exit = false;
        while (!exit) {
            Printer.printHeader();
            cats.sort(Cat::sortByAverageLevel);
            cats.forEach(cat -> Printer.printCat(cats.indexOf(cat) + 1, cat));

            exit = action(cats);
        }

    }

    public static boolean action(List<Cat> cats) {
        boolean exit = false;

        System.out.println("You also could actions: ");
        System.out.println("● Feed the cat      => 1");
        System.out.println("● Play with the cat => 2");
        System.out.println("● Treat the cat     => 3");
        System.out.println("● Get a new pet     => A");
        System.out.println("● To the next day   => N");
        System.out.println("● To exit ===========> E");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the comand: ");
        String inputComand = sc.nextLine();

        switch (inputComand) {
            case "1":
                Cat catToFeed = chooseCat(cats);
                catToFeed.feedCat();
                cats.add(catToFeed);
                break;
            case "2":
                Cat catToPlay = chooseCat(cats);
                catToPlay.playWithCat();
                cats.add(catToPlay);
                break;
            case "3":
                Cat catToTreat = chooseCat(cats);
                catToTreat.treatCat();
                cats.add(catToTreat);
                break;
            case "a":
            case "A":
                Cat newCat1 = inputCat();
                cats.add(newCat1);
                break;
            case "N":
            case "n":
                cats.forEach(Cat::toNextDay);
                System.out.println("One day passed!");
                break;
            case "e":
            case "E":
                exit = true;
                break;
        }
        return exit;
    }

    public static Cat chooseCat(List<Cat> cats) {
        Cat chosenCat = null;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of cat: ");
        String inputNumber = sc.nextLine();
        int intInputNumber = 0;

        try {
            intInputNumber = tryInt(inputNumber);
        } catch (ParseException e) {
            System.out.println("Please enter correct number of Cat!");
            chooseCat(cats);
        }

        if (0 >= intInputNumber || cats.size() < intInputNumber) {
            System.out.println("There is no such cat!");
            chooseCat(cats);
        } else {
            chosenCat = cats.get(intInputNumber - 1);
            cats.remove(intInputNumber - 1);
        }
        return chosenCat;
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

        return new Cat(inputName, intInputAge, satiety, mood, health);
    }

    public static int tryInt(String birth) throws ParseException {
        NumberFormat nf = NumberFormat.getIntegerInstance();
        return nf.parse(birth).intValue();
    }
}
