package edu1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>(3);
        cats.add(new Cat("Cat 1",14,80,80,80));
        cats.add(new Cat("Cat 2",10,50,90,90));
        cats.add(new Cat("Cat 3",17,40,30,40));
        cats.add(new Cat("Cat 4",13,70,70,70));
        cats.add(new Cat("Cat 5",9,60,60,60));

        Printer.printHeader();
        cats.sort(Cat::sortByAverageLevel);
        cats.forEach(c->{
            Printer.printCat(cats.indexOf(c),c);
        });
    }
}
