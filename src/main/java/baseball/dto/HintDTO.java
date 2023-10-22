package baseball.dto;

public class HintDTO {

    private boolean isAllStrike;

    private String message;

    public HintDTO(boolean isAllStrike, String message) {
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
