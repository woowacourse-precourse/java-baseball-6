package baseball.model;

public class Game {
    private int ballCount;
    private int strikeCount;
    private String resultMessage;

    private boolean enableGameOn;

    public Game() {
        this.enableGameOn = true;
    }

    public boolean isSuccess() {
        return strikeCount == 3;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void setStrikeCount (int strikeCount){
        this.strikeCount = strikeCount;
    }

    public void addMessage(String message) {
        this.resultMessage += message;
    }

    public boolean isGameOn() {
        return enableGameOn;
    }

    public void enableGameOver(String menuNumber) {
        // TODO 입력 유효성 처리

        // TODO if. 사용자가 2번 선택 시, 종료
        this.enableGameOn = false;
    }

}
