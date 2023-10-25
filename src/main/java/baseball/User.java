package baseball;

public class User {
    private int[] userNumbers;

    public User() {
        this.userNumbers = new int[3];
    }

    public void setUserNumbers(int[] userNumbers) {
        this.userNumbers = userNumbers;
    }

    public int[] getUserNumbers() {
        return this.userNumbers;
    }
}
