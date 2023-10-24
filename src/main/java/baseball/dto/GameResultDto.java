package baseball.dto;

public class GameResultDto {
    private String gameResultMessage;
    private boolean isRestart;
    private boolean isCorrectAnswer;

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