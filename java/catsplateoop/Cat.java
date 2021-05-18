package catsplateoop;

public class Cat {
    private String name;
    private int appetite;
    private boolean fed;

    public Cat(String name, int appetite, boolean fed) {
        this.name = name;
        this.appetite = appetite;
        this.fed = false;
    }

    public void eat(Plate plate) {
        if (fed != true) {
            fed = plate.decreaseFood(appetite);
            System.out.println("Кот " + name + " поел");
        }
    }


    public void fedInfo() {
        System.out.println("Коты наелись? " + name + " " + fed);
    }
}
