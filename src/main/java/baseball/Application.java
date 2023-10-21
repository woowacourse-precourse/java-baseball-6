package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.config.AppConfig;
import baseball.game.BaseballGames;
import baseball.message.GameMessages;
import baseball.service.RandomCodeService;
import baseball.service.ValidateJudgeService;
import baseball.vo.BaseballCode;
import java.util.ArrayList;

public class Application {

    private static final AppConfig appConfig = new AppConfig();
    private static final BaseballGames baseballGames = new BaseballGames();
    private static final RandomCodeService randomCodeService = appConfig.randomCodeService();
    private static final ValidateJudgeService validateJudgeService = appConfig.validateJudgeService();

    public static void main(String[] args) {
        BaseballCode baseballCode = new BaseballCode(new ArrayList<>());
        GameMessages startComment = GameMessages.START_COMMENT;
        GameMessages finishComment = GameMessages.FINISH_COMMENT;
        GameMessages restartComment = GameMessages.RESTART_COMMENT;
        System.out.println(startComment.getMessage());
        while (true) {
            BaseballCode baseballCodes = baseballCode.makeNewBaseballCode(randomCodeService.makeRandomCodeList());
            baseballGames.playBaseball(baseballCodes);
            int code = Integer.parseInt(readLine());
            boolean restartStatus = validateJudgeService.restartValidateCode(code);
            System.out.println(restartComment.getMessage());
            if (restartStatus) {
                continue;
            }
            System.out.println(finishComment.getMessage());
            break;
        }
    }
}