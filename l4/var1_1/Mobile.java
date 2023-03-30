package l4.var1_1;

public class Mobile {
    private String manufacturer;
    private String model;
    private int year;
    private double price;

    public Mobile(String manufacturer, String model, int year, double price) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public class MobileProperties {
        private String color;
        private String OS;
        private int RAM;
        private int ROM;

        public MobileProperties(String color, String OS, int RAM, int ROM) {
            this.color = color;
            this.OS = OS;
            this.RAM = RAM;
            this.ROM = ROM;
        }

        public String getColor() {
            return color;
        }

        public String getOS() {
            return OS;
        }

        public int getRAM() {
            return RAM;
        }

        public int getROM() {
            return ROM;
        }
    }
}
