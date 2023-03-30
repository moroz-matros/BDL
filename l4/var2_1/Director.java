package l4.var2_1;

public class Director extends Engineer {
    private double bonus;

    public Director(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    @Override
    public void work() {
        super.work();
        System.out.println(this.name + " is also leading the team.");
    }

    @Override
    public void getPaid() {
        super.getPaid();
        System.out.println(this.name + " is also getting a bonus of " + this.bonus + ".");
    }
}
