package baseball.util;

import baseball.application.GameLauncher;
import baseball.domain.Judgement;
import baseball.util.enums.PitchType;

public class JudgementConverter {

    /**
     * 판정 결과 값인 Judgement 값에 대해 결과 값으로 변환해줍니다.
     * @param judgement 결과 변환 대상 Judgement
     * @return Judgement to String 변환 값
     * @see Judgement
     * @see GameLauncher#execute()
     */
    public static String of(Judgement judgement) {
        if (judgement.isNothing()) {
            return PitchType.NOTHING.getType();
        }
        if (judgement.isThreeStrike()) {
            return judgement.getStrike() + PitchType.STRIKE.getType();
        }
        return makeJudgementResult(judgement.getBall(), judgement.getStrike());
    }

    /**
     * "낫싱" 혹은 "3 스트라이크"가 아닌 경우에 대한 별도의 결과 변환 메서드입니다.
     * @param ballCount 변환 대상 Judgement 의 Ball 수
     * @param strikeCount 변환 대상 Judgement 의 Strike 수
     * @return Judgement to String 변환 값
     * @see #of(Judgement)
     * @see PitchType
     */
    private static String makeJudgementResult(int ballCount, int strikeCount) {
        String judgementResult = "";
        if (ballCount > 0) {
            judgementResult += ballCount + PitchType.BALL.getType();
        }
        if (strikeCount > 0) {
            judgementResult += strikeCount + PitchType.STRIKE.getType();
        }
        return judgementResult.trim();
    }

}
