package l8.var1_2;

import java.util.concurrent.TimeUnit;

public class Robot {

    private boolean leftLeg;
    private boolean rightLeg;

    public Robot() {
        this.leftLeg = false;
        this.rightLeg = false;
    }

    public void startWalking() {
        while (!leftLeg && !rightLeg) {
            moveLeftLeg();
        }
    }

    synchronized public void moveLeftLeg() {
        if (!leftLeg) {
            System.out.println("left");
            leftLeg = true;
            rightLeg = false;
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (Exception e) {
            }

        }
    }

    synchronized public void moveRightLeg() {
        if (!rightLeg) {
            System.out.println("right");
            rightLeg = true;
            leftLeg = false;
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (Exception e) {
            }
        }
    }

    public boolean getLeftLeg() {
        return leftLeg;
    }

    public boolean getRightLeg() {
        return rightLeg;
    }

}
