package baseball.game;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.message.GameMessages;
import baseball.service.RandomCodeService;
import baseball.service.ValidateJudgeService;
import baseball.vo.BaseballCode;
import java.util.ArrayList;

public class GameLauncher {
    private final Game baseballGames;
    private final RandomCodeService randomCodeService;
    private final ValidateJudgeService validateJudgeService;

    public GameLauncher(Game baseballGames, RandomCodeService randomCodeService,
                        ValidateJudgeService validateJudgeService) {
        this.baseballGames = baseballGames;
        this.randomCodeService = randomCodeService;
        this.validateJudgeService = validateJudgeService;
    }

    public void playGame() {
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
