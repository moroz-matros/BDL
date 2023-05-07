package l8.var1_1;

public class BankAccount {
    int money = 0;

    public BankAccount(int money) {
        this.money = money;
    }

    synchronized void addMoney(int amount, String author) {
        money += amount;
        System.out.println(author + " added " + amount + " money to account. Total available: " + money);
    }

    synchronized void withdrawMoney(int amount, String author) {
        if (amount <= money) {
            money -= amount;
            System.out.println(author + " removed " + amount + " money from account. Total available: " + money);
        } else
            System.out.println("Not enough money for this operation from " + author);
    }

    synchronized int getBalance() {
        return money;
    }
}
