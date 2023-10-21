package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.game.BaseballGames;
import baseball.service.RandomCodeService;
import baseball.service.ValidateJudgeService;
import baseball.service.impl.RandomCodeServiceImpl;
import baseball.service.impl.ValidateJudgeServiceImpl;
import baseball.vo.BaseballCode;
import java.util.ArrayList;

public class Application {
    private static final BaseballGames baseballGames = new BaseballGames();
    private static final RandomCodeService randomCodeService = new RandomCodeServiceImpl();
    private static final ValidateJudgeService validateJudgeService = new ValidateJudgeServiceImpl();

    private static final String RESTART_COMMENT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String FINISH_COMMENT = "게임 종료";

    public static void main(String[] args) {
        BaseballCode baseballCode = new BaseballCode(new ArrayList<>());
        while (true) {
            BaseballCode baseballCodes = baseballCode.makeNewBaseballCode(randomCodeService.makeRandomCodeList());
            baseballGames.playBaseball(baseballCodes);
            int code = Integer.parseInt(readLine());
            boolean restartStatus = validateJudgeService.restartValidateCode(code);
            System.out.println(RESTART_COMMENT);
            if (restartStatus) {
                continue;
            }
            System.out.println(FINISH_COMMENT);
            break;
        }
    }
}