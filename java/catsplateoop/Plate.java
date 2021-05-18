package catsplateoop;

public class Plate {
    private int food;
    private int minFood = 0;

    public boolean decreaseFood(int input) {
        boolean isFed = false;

        if (food - input < minFood) {
            System.out.println("Котам не хватит еды");
        } else {
            food -= input;
            isFed = true;
        }
        return isFed;
    }



    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("Еды в тарелке: " + food);
    }

    public void fillPlate(int input) {
        System.out.println("В тарелку добавили еды");
        food += input;

    }
}
