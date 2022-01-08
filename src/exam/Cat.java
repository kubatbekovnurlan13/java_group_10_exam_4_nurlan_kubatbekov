package exam;

import java.util.Random;

public class Cat implements Action {
    private final String name;
    private final int age;
    private int satiety;
    private int mood;
    private int health;
    private int averageLevel;
    private boolean actionable;

    public Cat(String name, int age, int satiety, int mood, int health) {
        this.name = name;
        this.age = age;
        this.satiety = satiety;
        this.mood = mood;
        this.health = health;
        this.averageLevel = calcAverageLevel();
        this.actionable = true;
    }

    @Override
    public void toNextDay() {
        Random rnd = new Random();
        int randomHealthNumber = rnd.nextInt(3) + 1;
        int ranodmMoodNumber = rnd.nextInt(3) + 1;
        int randomSatietyNumber = rnd.nextInt(5) + 1;

        int switcherForHealth = rnd.nextInt(2) + 1;
        int switcherForMood = rnd.nextInt(2) + 1;

        if (switcherForHealth == 1) {
            this.health = this.health - randomHealthNumber;
        } else {
            this.health = this.health + randomHealthNumber;
        }

        if (switcherForMood == 1) {
            this.mood = this.mood - ranodmMoodNumber;
        } else {
            this.mood = this.mood + ranodmMoodNumber;
        }

        this.satiety = this.satiety - randomSatietyNumber;

        this.actionable = true;
    }

    @Override
    public void feedCat() {
        if (this.actionable) {
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

            this.actionable = false;
        } else {
            System.out.println("You can not feed cat!");
        }
    }

    @Override
    public void playWithCat() {
        if (this.actionable) {
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

            this.actionable = false;
        } else {
            System.out.println("You can not play with cat!");
        }
    }

    @Override
    public void treatCat() {
        if (this.actionable) {
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

            this.actionable = false;
        } else {
            System.out.println("You can not treat the cat!");
        }
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
