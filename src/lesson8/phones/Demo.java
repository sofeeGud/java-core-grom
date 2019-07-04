package lesson8.phones;

public class Demo {
    public static void main(String[] args) {
        IPhone IPhone = new IPhone(110,10.0, "China", true);
        IPhone.deleteIPhoneFromDb();
        IPhone.orderPhone();
    }
}
