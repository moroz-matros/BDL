package l4.var2_2;

public abstract class PublicBuilding implements Building {
    private String address;
    private int numFloors;

    public PublicBuilding(String address, int numFloors) {
        this.address = address;
        this.numFloors = numFloors;
    }

    @Override
    public void printInfo() {
        System.out.println("A public building at " + this.address + "...");
        System.out.println("Number of floors: " + this.numFloors);
    }
}
