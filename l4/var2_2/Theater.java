package l4.var2_2;

public class Theater extends PublicBuilding {
    private String name;
    private int numSeats;

    public Theater(String address, int numFloors, String name, int numSeats) {
        super(address, numFloors);
        this.name = name;
        this.numSeats = numSeats;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("A theater named " + this.name + " with " + this.numSeats + " seats...");
    }
}
