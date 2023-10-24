package baseball.model;

public class Number {
    private static int[] computerNumber;
    private static int[] userNumber;


    public static void setComputerNumber(int[] num) {
        computerNumber = num;
    }

    public static int[] getComputerNumber() {
        return computerNumber;
    }

    public static void setUserNumber(int[] num) {
        userNumber = num;
    }

    public static int[] getUserNumber() {
        return userNumber;
    }
}
