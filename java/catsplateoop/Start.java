package catsplateoop;

public class Start {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", 10, false);
        Cat secondCat = new Cat("Murzik", 5, false);
        Cat thirdCat = new Cat("Tom", 7, false);


        Plate plate = new Plate(25);

        plate.info();
        cat.eat(plate);
        secondCat.eat(plate);
        thirdCat.eat(plate);

        plate.info();

        cat.fedInfo();


        secondCat.fedInfo();
        thirdCat.fedInfo();

        plate.fillPlate(15);

        plate.info();

    }

}
