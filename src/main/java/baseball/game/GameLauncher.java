package baseball.game;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.message.GameMessages;
import baseball.service.BaseballRandomCodeService;
import baseball.service.ValidateJudgeService;
import baseball.vo.BaseballCode;
import java.util.ArrayList;

public class GameLauncher {
    private final Game baseballGames;
    private final BaseballRandomCodeService baseballRandomCodeService;
    private final ValidateJudgeService validateJudgeService;

    public GameLauncher(Game baseballGames, BaseballRandomCodeService randomCodeService,
                        ValidateJudgeService validateJudgeService) {
        this.baseballGames = baseballGames;
        this.baseballRandomCodeService = randomCodeService;
        this.validateJudgeService = validateJudgeService;
    }

    public void playGame() {
        BaseballCode baseballCode = new BaseballCode(new ArrayList<>());
        GameMessages startComment = GameMessages.START_COMMENT;
        GameMessages finishComment = GameMessages.FINISH_COMMENT;
        System.out.println(startComment.getMessage());
        while (true) {
            boolean restartStatus = baseballGame(baseballCode);
            if (restartStatus) {
                continue;
            }
            System.out.println(finishComment.getMessage());
            break;
        }
    }

    private boolean baseballGame(BaseballCode baseballCode) {
        GameMessages restartComment = GameMessages.RESTART_COMMENT;
        BaseballCode baseballCodes = baseballCode.makeNewBaseballCode(
                baseballRandomCodeService.makeRandomCodeList());
        baseballGames.playBaseball(baseballCodes);
        System.out.println(restartComment.getMessage());
        int code = Integer.parseInt(readLine());
        return validateJudgeService.restartValidateCode(code);
    }
}
