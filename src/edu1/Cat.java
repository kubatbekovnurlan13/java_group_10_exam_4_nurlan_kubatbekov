package edu1;

public class Cat {
    private String name;
    private int age;
    private int satiety;
    private int mood;
    private int health;
    private int averageLevel;

    public Cat(String name, int age, int satiety, int mood, int health) {
        this.name = name;
        this.age = age;
        this.satiety = satiety;
        this.mood = mood;
        this.health = health;
        this.averageLevel = calcAverageLevel();
    }


    public static int sortByAverageLevel(Cat c1,Cat c2) {
        return c2.getAverageLevel() - c1.getAverageLevel();
    }


    private int calcAverageLevel() {
        return (this.satiety + this.mood + this.health) / 3;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSatiety() {
        return satiety;
    }

    public int getMood() {
        return mood;
    }

    public int getHealth() {
        return health;
    }

    public int getAverageLevel() {
        return averageLevel;
    }
}
