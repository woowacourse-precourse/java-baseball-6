package baseball;

public class PitchResult {
    private int ball;
    private int strike;

    private int restartNumber;
    private RandomNumber randomNumber;

    private Validation validation;

    public PitchResult(RandomNumber randomNumber, Validation validation) {
        this.randomNumber = randomNumber;
        this.validation = validation;
    }

    public void addBall(int ball) {
        this.ball = ball + 1;
    }

    public void addStrike(int strike) {
        this.strike = strike + 1;
    }

    public void setRestartNumber(int restartNumber) {
        this.restartNumber = restartNumber;
    }

    public int getRestartNumber() {
        return restartNumber;
    }

    public void judgePitch(String inputString) {
        for (int i = 0; i < 3; i++) {
            if (randomNumber.getRandomNumber().get(i).equals(Character.getNumericValue(inputString.charAt(i)))) {
                addStrike(strike);
            } else if (randomNumber.getRandomNumber().contains(Character.getNumericValue(inputString.charAt(i)))) {
                addBall(ball);
            }
        }
    }

}
