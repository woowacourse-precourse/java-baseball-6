package baseball.engine.dto;

import static baseball.constant.BaseballSystemPolicy.ALL_STRIKE;

public record Hint(int strike, int ball) {

    public boolean isAllStrike() {
        return this.strike == ALL_STRIKE.getCondition();
    }

    public String getMessage() {
        StringBuilder message = new StringBuilder();
        writeBallCount(message);
        writeStrikeCount(message);

        if (message.isEmpty()) {
            message.append("낫싱");
        }
        message.append("\n");

        return message.toString();
    }

    private void writeStrikeCount(StringBuilder result) {
        if (this.isExistStrike()) {
            result.append(this.strike).append("스트라이크");
        }
    }

    private void writeBallCount(StringBuilder result) {
        if (this.isExistBall()) {
            result.append(this.ball).append("볼 ");
        }
    }

    private boolean isExistBall() {
        return this.ball > 0;
    }

    private boolean isExistStrike() {
        return this.strike > 0;
    }
}
