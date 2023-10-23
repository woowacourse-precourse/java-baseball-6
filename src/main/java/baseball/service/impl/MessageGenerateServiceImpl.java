package baseball.service.impl;

import baseball.service.MessageGenerateService;
import baseball.vo.GameResult;

public class MessageGenerateServiceImpl implements MessageGenerateService {
    @Override
    public String makeMessage(GameResult gameResult) {
        if (gameResult.isStrikeCountNotEqualZeroAndBallCountEqualZero()) {
            return gameResult.makeStrikeJudgementMessage();
        } else if (gameResult.isStrikeCountNotEqualZeroAndBallCountNotEqualZero()) {
            return gameResult.makeStrikeAndBallJudgement();
        } else if (gameResult.isStrikeCountEqualZeroAndBallCountNotEqualZero()) {
            return gameResult.makeBallJudgementMessage();
        }
        return gameResult.makeNoStrikeAndNoBallJudgementMessage();
    }
}
