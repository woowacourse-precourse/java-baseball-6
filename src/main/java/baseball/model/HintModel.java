package baseball.model;

import baseball.enums.HintEnum;

/**
 * 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시
 * @param strike int
 * @param ball int
 */
public record HintModel(int strike, int ball) {
    private static final int ZERO_STRIKE = 0;
    private static final int ZERO_BALL = 0;
    private static final int MAX_STRIKE = 3;

    public HintModel {
        if (strike < ZERO_STRIKE || ball < ZERO_BALL) {
            throw new IllegalArgumentException("스트라이크와 볼은 0 이상이어야 합니다.");
        }
    }

    /**
     * strike와 ball 개수에 따라 힌트 메세지를 반환
     * @return String 힌트 메세지
     */
    public String toHintMessage() {
        if (strike == ZERO_STRIKE && ball == ZERO_BALL) {
            return HintEnum.NOTHING.getValue();
        }

        StringBuilder sb = new StringBuilder();
        if (ball > ZERO_BALL) {
            sb.append(ball)
               .append(HintEnum.BALL.getValue())
               .append(" ");
        }

        if (strike > ZERO_STRIKE) {
            sb.append(strike).append(HintEnum.STRIKE.getValue());
        }

        return sb.toString();
    }

    /**
     * 스트라이크 개수가 3개인지 확인
     * @return boolean 스트라이크 개수가 3개면 true, 아니면 false
     */
    public boolean isAllStrikes() {
        return strike == MAX_STRIKE;
    }
}
