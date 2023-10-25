package baseball;

public class BaseballGame {

    private final BaseballNumber numbers;

    public BaseballGame() {
        numbers = new BaseballNumber();
    }

    public void setUserNumbers(String numbers) {
        this.numbers.setUser(numbers);
    }

    public void getBallScoreMessage() {

    }

}
