package l5.var2_2;

public class InvalidPhoneException extends Exception {

    public InvalidPhoneException(String message) {
        super(message);
        System.out.println("phone should have 11 numbers");
    }
}
