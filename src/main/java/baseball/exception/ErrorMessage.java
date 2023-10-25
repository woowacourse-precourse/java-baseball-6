package baseball.exception;


import static baseball.model.Ball.END_RANGE;
import static baseball.model.Ball.START_RANGE;
import static baseball.model.Balls.BALLS_SIZE;

public enum ErrorMessage {
    INVALID_BALL_NUMBER(START_RANGE + "-" + END_RANGE + "사이의 중복없는 " + BALLS_SIZE + "자리 숫자를 입력해야 합니다."),
    INVALID_BALLS_SIZE(BALLS_SIZE + "자리 숫자를 입력해야 합니다."),
    INVALID_ANSWER_ABOUT_RETRY("잘못된 입력입니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
