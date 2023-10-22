package baseball.game;

import baseball.message.GameMessages;
import baseball.service.MessageGenerateService;
import baseball.service.UserCodeService;
import baseball.service.ValidateJudgeService;
import baseball.vo.BaseballCode;
import baseball.vo.GameResult;
import baseball.vo.UserCode;
import java.util.ArrayList;

public class BaseballGames implements Game {

    private final ValidateJudgeService validateJudgeService;
    private final UserCodeService userCodeService;
    private final MessageGenerateService messageGenerateService;

    public BaseballGames(ValidateJudgeService validateJudgeService, UserCodeService userCodeService,
                         MessageGenerateService messageGenerateService) {
        this.validateJudgeService = validateJudgeService;
        this.userCodeService = userCodeService;
        this.messageGenerateService = messageGenerateService;
    }

    public void playBaseball(BaseballCode baseballCode) {

        UserCode codes = new UserCode(new ArrayList<>());
        GameMessages gameEndComment = GameMessages.GAME_END_COMMENT;
        GameMessages strikeComment = GameMessages.THREE_STRIKE_COMMENT;
        while (true) {
            UserCode userCode = userCodeService.makeUserCode(codes);
            validateJudgeService.validateLegalUserCode(userCode);
            GameResult gameResult = validateJudgeService.validateAndCompareCodes(baseballCode, userCode);
            String batResult = messageGenerateService.makeMessage(gameResult);
            System.out.println(batResult);
            if (batResult.equals(strikeComment.getMessage())) {
                System.out.println(gameEndComment.getMessage());
                break;
            }
        }
    }
}
