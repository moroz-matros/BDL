package l8.var1_1;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RunnableTask implements Runnable {
    private BankAccount bankAccount;
    private String taskName;
    Random random = new Random();

    public RunnableTask(BankAccount bankAccount, String taskName) {
        this.bankAccount = bankAccount;
        this.taskName = taskName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt() % 100);
            } catch (Exception e) {
                continue;
            }
            if ((random.nextInt() % 2) == 0) {
                bankAccount.addMoney(Math.abs(random.nextInt() % 100), taskName);
            } else {
                bankAccount.withdrawMoney(Math.abs(random.nextInt() % 100), taskName);
            }
        }
    }
}
