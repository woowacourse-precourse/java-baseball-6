package baseball.domain;

import baseball.application.GameLauncher;

public class Judgement {

    private final int ball;
    private final int strike;

    /**
     * 각 Pitch 들의 Computer 와의 비교 판정 값을 저장하는 객체
     * @param ball Ball 판정 값
     * @param strike Strike 판정 값
     * @see GameLauncher#execute()
     */
    public Judgement(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    /**
     * @return 본 Judgement 의 Ball 수
     * @see baseball.application.GameLauncher#judge(Pitch)
     */
    public int getBall() {
        return ball;
    }

    /**
     * @return 본 Judgement 의 Strike 수
     * @see baseball.application.GameLauncher#judge(Pitch)
     */
    public int getStrike() {
        return strike;
    }

    /**
     *
     * @return 낫싱 여부
     * @see baseball.util.JudgementConverter
     */
    public boolean isNothing() {
        return ball == 0 && strike == 0;
    }

    /**
     * @return 3 스트라이크 여부
     * @see baseball.util.JudgementConverter
     */
    public boolean isThreeStrike() {
        return strike == 3;
    }

}
