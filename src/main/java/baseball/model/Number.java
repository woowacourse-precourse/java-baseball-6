package baseball.model;

public class Number {
    private static int[] computerNumber;
    private static int[] userNumber;


    public void setComputerNumber(int[] num) {
        computerNumber = num;
    }

    public int[] getComputerNumber() {
        return computerNumber;
    }

    public void setUserNumber(int[] num) {
        userNumber = num;
    }

    public int[] getUserNumber() {
        return userNumber;
    }
}
