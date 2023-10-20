package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.domain.BaseballCode;
import baseball.game.BaseballGames;
import baseball.service.RandomCodeService;
import baseball.service.ValidateJudgeService;
import baseball.service.impl.RandomCodeServiceImpl;
import baseball.service.impl.ValidateJudgeServiceImpl;
import java.util.ArrayList;

public class Application {
    private static final BaseballGames baseballGames = new BaseballGames();
    private static final RandomCodeService randomCodeService = new RandomCodeServiceImpl();
    private static final ValidateJudgeService validateJudgeService = new ValidateJudgeServiceImpl();

    public static void main(String[] args) {
        BaseballCode baseballCode = new BaseballCode(new ArrayList<>());
        while (true) {
            BaseballCode baseballCodes = baseballCode.makeNewBaseballCode(randomCodeService.makeRandomCodeList());
            baseballGames.playBaseball(baseballCode.getCodes());
            int code = Integer.parseInt(readLine());
            boolean restartStatus = validateJudgeService.restartValidateCode(code);
            if (restartStatus) {
                continue;
            }
            break;
        }
    }
}