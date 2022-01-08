package edu1;

public class Cat implements Action {
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

    @Override
    public void feedCat() {
        if (this.age >= 1 && this.age <= 5) {
            this.satiety = this.satiety + 7;
            this.mood = this.mood + 7;
        } else if (this.age > 5 && this.age <= 10) {
            this.satiety = this.satiety + 5;
            this.mood = this.mood + 5;
        } else if (this.age > 10) {
            this.satiety = this.satiety + 4;
            this.mood = this.mood + 4;
        }
        System.out.println("The cat: " + this.name + " is fed!");
    }

    @Override
    public void playWithCat() {
        if (this.age >= 1 && this.age <= 5) {
            this.satiety = this.satiety - 3;

            this.health = this.health + 7;
            this.mood = this.mood + 7;
        } else if (this.age > 5 && this.age <= 10) {
            this.satiety = this.satiety - 5;

            this.health = this.health + 5;
            this.mood = this.mood + 5;
        } else if (this.age > 10) {
            this.satiety = this.satiety - 6;

            this.health = this.health + 4;
            this.mood = this.mood + 4;
        }
        System.out.println("The cat:" + this.name + " played!");
    }

    @Override
    public void treatCat() {
        if (this.age >= 1 && this.age <= 5) {
            this.satiety = this.satiety - 3;
            this.mood = this.mood - 3;

            this.health = this.health + 7;
        } else if (this.age > 5 && this.age <= 10) {
            this.satiety = this.satiety - 5;
            this.mood = this.mood - 5;

            this.health = this.health + 5;
        } else if (this.age > 10) {
            this.satiety = this.satiety - 6;
            this.mood = this.mood - 6;

            this.health = this.health + 4;
        }
        System.out.println("The cat: " + this.name + " is cured!");
    }

    public static int sortByAverageLevel(Cat c1, Cat c2) {
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
        this.averageLevel = calcAverageLevel();
        return averageLevel;
    }
}
