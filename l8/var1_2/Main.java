package l8.var1_2;

/*
 * 2. Реализовать многопоточное приложение “Робот”.
 * Надо написать робота, который умеет ходить.
 * За движение каждой его ноги отвечает отдельный поток.
 * Шаг выражается в выводе в консоль LEFT или RIGHT.
 */

public class Main {
    public static void main(String[] args) {
        Robot robot = new Robot();

        Thread leftLegThread = new Thread(() -> {
            while (true) {
                robot.moveLeftLeg();
            }
        });

        Thread rightLegThread = new Thread(() -> {
            while (true) {
                robot.moveRightLeg();
            }
        });

        leftLegThread.start();
        rightLegThread.start();

        robot.startWalking();
    }
}
