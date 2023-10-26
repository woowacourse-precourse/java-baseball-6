package baseball.dto;

public class GameResultDTO {
    Integer strike;
    Integer ball;
    Boolean success;

    public GameResultDTO(Integer strike, Integer ball, Boolean success) {
        this.strike = strike;
        this.ball = ball;
        this.success = success;
    }

    public Integer getStrike() {
        return strike;
    }

    public Integer getBall() {
        return ball;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
