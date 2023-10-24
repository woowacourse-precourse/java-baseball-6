package baseball.domain;

public class User {

    private final int[] inputNum;

    public User(int[] inputNum) {
        this.inputNum = inputNum;
    }

    public int[] getInputNum() {
        return inputNum;
    }
}
