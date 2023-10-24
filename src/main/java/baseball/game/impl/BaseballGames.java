package baseball.game.impl;

import baseball.game.Game;
import baseball.ioadapter.IoAdapter;
import baseball.message.GameMessages;
import baseball.service.InputConvertService;
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

    private final IoAdapter ioAdapter;

    private final InputConvertService inputConvertService;

    public BaseballGames(ValidateJudgeService validateJudgeService, MessageGenerateService messageGenerateService,
                         IoAdapter ioAdapter, InputConvertService inputConvertService) {
        this.validateJudgeService = validateJudgeService;
        this.messageGenerateService = messageGenerateService;
        this.ioAdapter = ioAdapter;
        this.inputConvertService = inputConvertService;
    }

    public void playBaseball(BaseballCode baseballCode) {

        UserCode codes = new UserCode(new ArrayList<>());
        GameMessages gameEndComment = GameMessages.GAME_END_COMMENT;
        GameMessages strikeComment = GameMessages.THREE_STRIKE_COMMENT;
        GameMessages numberInputComment = GameMessages.NUMBER_INPUT_COMMENT;
        while (true) {
            ioAdapter.printMessage(numberInputComment);
            UserCode userCode = codes.makeNewUserCode(inputConvertService);
            validateJudgeService.validateLegalUserCode(userCode);
            GameResult gameResult = validateJudgeService.validateAndCompareCodes(baseballCode, userCode);
            Message resultMessage = messageGenerateService.makeMessage(gameResult);
            resultMessage.printGameResultMessage();
            if (resultMessage.isResultMessageSameStrikeMessage(strikeComment.getMessage())) {
                ioAdapter.printMessage(gameEndComment);
                break;
            }
        }
    }
}
