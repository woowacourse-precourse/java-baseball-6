package baseball.gameutil.strgenerator;

import baseball.gameutil.Score;
import baseball.message.MessageString;

/**
 * 야구 게임에 사용할 ResultStringGenerator 인터페이스를 구현한 클래스
 */
public class ResultStringGeneratorBaseBall implements ResultStringGenerator {

    /**
     * 점수를 문자열로 변환한다.
     * @param score 점수
     * @return 점수를 문자열로 변환한 결과
     */
    public String result(Score score) {
        if (score.getBall() == 0 && score.getStrike() == 0) {
            return MessageString.NOTHING_MSG;
        }
        return "%s %s"
            .formatted(ballStringBuilder(score.getBall()), strikeStringBuilder(score.getStrike()))
            .trim();
    }

    private String strikeStringBuilder(int strike) {
        if (strike == 0) {
            return "";
        }
        return "%d%s".formatted(strike, MessageString.STRIKE_MSG);
    }

    private String ballStringBuilder(int ball) {
        if (ball == 0) {
            return "";
        }
        return "%d%s".formatted(ball, MessageString.BALL_MSG);
    }

}