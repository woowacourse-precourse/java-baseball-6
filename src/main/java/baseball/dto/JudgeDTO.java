package baseball.dto;

public class JudgeDTO {

    private boolean isAllStrike;

    private String message;

    public JudgeDTO(boolean isAllStrike, String message) {
        this.isAllStrike = isAllStrike;
        this.message = message;
    }

    public boolean isAllStrike() {
        return isAllStrike;
    }

    public String getMessage() {
        return message;
    }
}
