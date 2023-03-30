package l4.var2_1;

public class Engineer implements Employee {
    protected String name;
    private double salary;

    public Engineer(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public void work() {
        System.out.println(this.name + " is working...");
    }

    @Override
    public void getPaid() {
        System.out.println(this.name + " is getting paid " + this.salary + ".");
    }
}