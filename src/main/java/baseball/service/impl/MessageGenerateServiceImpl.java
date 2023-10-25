package baseball.service.impl;

import baseball.service.MessageGenerateService;
import baseball.vo.GameResult;
import baseball.vo.Message;

public class MessageGenerateServiceImpl implements MessageGenerateService {
    @Override
    public Message makeMessage(GameResult gameResult) {
        if (gameResult.isStrikeCountNotEqualZeroAndBallCountEqualZero()) {
            return gameResult.makeStrikeJudgementMessage();
        } else if (gameResult.isStrikeCountNotEqualZeroAndBallCountNotEqualZero()) {
            return gameResult.makeStrikeAndBallJudgementMessage();
        } else if (gameResult.isStrikeCountEqualZeroAndBallCountNotEqualZero()) {
            return gameResult.makeBallJudgementMessage();
        }
        return gameResult.makeNoStrikeAndNoBallJudgementMessage();
    }
}
