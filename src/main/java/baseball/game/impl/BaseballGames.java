package baseball.game.impl;

import baseball.game.Game;
import baseball.message.GameMessages;
import baseball.service.MessageGenerateService;
import baseball.service.ValidateJudgeService;
import baseball.vo.BaseballCode;
import baseball.vo.GameResult;
import baseball.vo.Message;
import baseball.vo.UserCode;
import java.util.ArrayList;

public class BaseballGames implements Game {

    private final ValidateJudgeService validateJudgeService;
    private final MessageGenerateService messageGenerateService;

    public BaseballGames(ValidateJudgeService validateJudgeService, MessageGenerateService messageGenerateService) {
        this.validateJudgeService = validateJudgeService;
        this.messageGenerateService = messageGenerateService;
    }

    public void playBaseball(BaseballCode baseballCode) {

        UserCode codes = new UserCode(new ArrayList<>());
        GameMessages gameEndComment = GameMessages.GAME_END_COMMENT;
        GameMessages strikeComment = GameMessages.THREE_STRIKE_COMMENT;
        GameMessages numberInputComment = GameMessages.NUMBER_INPUT_COMMENT;
        while (true) {
            System.out.print(numberInputComment.getMessage());
            UserCode userCode = codes.makeNewUserCode();
            validateJudgeService.validateLegalUserCode(userCode);
            GameResult gameResult = validateJudgeService.validateAndCompareCodes(baseballCode, userCode);
            Message resultMessage = messageGenerateService.makeMessage(gameResult);
            resultMessage.printGameResultMessage();
            if (resultMessage.isResultMessageSameStrikeMessage(strikeComment.getMessage())) {
                System.out.println(gameEndComment.getMessage());
                break;
            }
        }
    }
}
