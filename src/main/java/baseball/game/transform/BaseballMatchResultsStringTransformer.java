package baseball.game.transform;

import baseball.game.dto.BaseballMatchResults;

public class BaseballMatchResultsStringTransformer implements Transformer<BaseballMatchResults, String> {

    @Override
    public String transform(BaseballMatchResults baseballMatchResults) {
        if (baseballMatchResults.isEmpty()) {
            return "낫싱";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int ballCount = baseballMatchResults.ballCount();
        int strikeCount = baseballMatchResults.strikeCount();
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
