package baseball.service.impl;

import baseball.service.MessageGenerateService;
import baseball.vo.GameResult;

public class MessageGenerateServiceImpl implements MessageGenerateService {
    @Override
    public String makeMessage(GameResult gameResult) {
        Integer strikeCount = gameResult.getStrikeCount();
        Integer ballCount = gameResult.getBallCount();
        if (strikeCount.equals(3)) {
            return strikeCount + "스트라이크";
        } else if (ballCount.equals(0) && !strikeCount.equals(0)) {
            return strikeCount + "스트라이크";
        } else if (!ballCount.equals(0) && !strikeCount.equals(0)) {
            return ballCount + "볼 " + strikeCount + "스트라이크";
        } else if (!ballCount.equals(0)) {
            return ballCount + "볼";
        }
        return "낫싱";
    }
}
