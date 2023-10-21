package baseball.game;

import baseball.config.AppConfig;
import baseball.message.GameMessages;
import baseball.service.MessageGenerateService;
import baseball.service.UserCodeService;
import baseball.service.ValidateJudgeService;
import baseball.vo.BaseballCode;
import baseball.vo.GameResult;
import baseball.vo.UserCode;
import java.util.ArrayList;

public class BaseballGames {

    private static final AppConfig appConfig = new AppConfig();
    private static final ValidateJudgeService validateJudgeService = appConfig.validateJudgeService();
    private static final UserCodeService userCodeService = appConfig.userCodeService();
    private static final MessageGenerateService messageGenerateService = appConfig.messageGenerateService();


    public void playBaseball(BaseballCode baseballCode) {

        UserCode codes = new UserCode(new ArrayList<>());
        GameMessages gameEndComment = GameMessages.GAME_END_COMMENT;
        while (true) {
            UserCode userCode = userCodeService.makeUserCode(codes);
            validateJudgeService.validateLegalUserCode(userCode);
            GameResult gameResult = validateJudgeService.validateAndCompareCodes(baseballCode, userCode);
            String batResult = messageGenerateService.makeMessage(gameResult);
            System.out.println(batResult);
            if (batResult.equals("3스트라이크")) {
                System.out.println(gameEndComment.getMessage());
                break;
            }
        }
    }
}
