package l4.var1_1;

/* 3. Создать класс Mobile с внутренним классом, с помощью объектов которого
* можно хранить информацию о моделях телефонов и их свойствах.
*/

public class Main {
    public static void main(String[] args) {
        Mobile mobile = new Mobile("Samsung", "Galaxy S10", 2019, 1000.00);
        Mobile.MobileProperties mobileProperties = mobile.new MobileProperties("white", "Android 9.0", 4, 128);

        System.out.println("Manufacturer: " + mobile.getManufacturer());
        System.out.println("Model: " + mobile.getModel());
        System.out.println("Year: " + mobile.getYear());
        System.out.println("Price: " + mobile.getPrice());
        System.out.println("Color: " + mobileProperties.getColor());
        System.out.println("OS: " + mobileProperties.getOS());
        System.out.println("RAM: " + mobileProperties.getRAM());
        System.out.println("ROM: " + mobileProperties.getROM());
    }
}
