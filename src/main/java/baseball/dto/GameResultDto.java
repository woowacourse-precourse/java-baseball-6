package baseball.dto;

public class GameResultDto {
    private boolean isEnd;
    private String message;

    public GameResultDto(boolean isEnd, String message) {
        this.isEnd = isEnd;
        this.message = message;
    }


    public boolean checkEnd() {
        return isEnd;
    }
    public String showMessage() {
        return new String(message);
    }


}
