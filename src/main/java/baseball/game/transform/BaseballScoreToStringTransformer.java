package baseball.game.transform;

import baseball.game.dto.BaseballScore;

public class BaseballScoreToStringTransformer implements Transformer<BaseballScore, String> {

    @Override
    public String transform(BaseballScore baseballScore) {
        if (baseballScore.isEmpty()) {
            return "낫싱";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int ballCount = baseballScore.ballCount();
        int strikeCount = baseballScore.strikeCount();
        boolean isNeedSpace = ballCount > 0;
        if (ballCount > 0) {
            stringBuilder.append(ballCount).append("볼");
        }
        if (isNeedSpace) {
            stringBuilder.append(" ");
        }
        if (strikeCount > 0) {
            stringBuilder.append(strikeCount).append("스트라이크");
        }
        return stringBuilder.toString();
    }
}
