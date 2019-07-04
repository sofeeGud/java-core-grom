package lesson8.phones;

public class Phone {
    int price;
    double weight;
    String countryProduced;


    public Phone(int price, double weight, String countryProduced) {
        this.price = price;
        this.weight = weight;
        this.countryProduced = countryProduced;
    }

    void orderPhone(){
    System.out.println("order phone invoked...");
    }
}
