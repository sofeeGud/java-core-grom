package lesson6;

public class Car {

    int price;
    int yearOfManufacturing;
    String color;
    String ownerName;
    double weight;
    int horsePower;


    public Car(int price, int yearOfManufacting, String ownerName) {
        this.price = price;
        this.yearOfManufacturing = yearOfManufacting;
        this.ownerName = ownerName;
    }

    void startRun() {
        System.out.println("I am ranning....");
    }


    void stopRun() {
        System.out.println("I am stopping....");
    }

    void changeOwner(String newOwnerName) {
        ownerName = newOwnerName;
    }

}
