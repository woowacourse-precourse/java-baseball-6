package baseball.dto;

public class GameResultDto {
    private String randomNumber;
    private String validateInput;
    private int strike;
    private int ball;
    private String gameResultMessage;

    private boolean isRestart;
    private boolean isCorrectAnswer;


    public String getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(String randomNumber) {
        this.randomNumber = randomNumber;
    }

    public String getValidateInput() {
        return validateInput;
    }

    public void setValidateInput(String validateInput) {
        this.validateInput = validateInput;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public String getGameResultMessage() {
        return gameResultMessage;
    }

    public void setGameResultMessage(String gameResultMessage) {
        this.gameResultMessage = gameResultMessage;
    }

    public boolean getIsRestart() {
        return isRestart;
    }

    public void setIsRestart(boolean isRestart) {
        this.isRestart = isRestart;
    }

    public boolean getIsCorrectAnswer() {
        return isCorrectAnswer;
    }

    public void setIsCorrectAnswer(boolean isCorrectAnswer) {
        this.isCorrectAnswer = isCorrectAnswer;
    }
}
