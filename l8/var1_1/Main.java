package l8.var1_1;

/*
 * 1. Реализовать многопоточное приложение “Банк”. Имеется банковский счет.
 * Сделать синхронным пополнение и снятие денежных средств на счет/со счет случайной суммой.
 * При каждой операции (пополнения или снятие) вывести текущий баланс счета.
 * В том случае, если денежных средств недостаточно – вывести сообщение.
 */
public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(100);

        Runnable oneTask = new RunnableTask(account, "one");
        Runnable twoTask = new RunnableTask(account, "two");

        Thread oneThread = new Thread(oneTask);
        oneThread.start();

        Thread twoThread = new Thread(twoTask);
        twoThread.start();

        try {
            oneThread.join();
            twoThread.join();
        } catch (Exception e) {
            System.out.println("some exception");
        }

        System.out.println("Final balance: " + account.getBalance());
    }
}
