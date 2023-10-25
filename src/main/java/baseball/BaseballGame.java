package baseball;

import balls.Balls;
import camp.nextstep.edu.missionutils.Console;
import result.Result;
import utils.Utils;

public class BaseballGame {
    Utils utils = new Utils();
    BaseballGameService baseballGameService = new BaseballGameService();

    public boolean gameStart() {
        boolean run = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        Balls computerBalls = baseballGameService.createComputerBalls();
        while (run) {
            System.out.print("숫자를 입력해주세요. : ");
            String input = Console.readLine();
            Balls userBalls = new Balls(input);
            run = baseballGameService.baseballGameServiceStart(computerBalls, userBalls);
        }
        return true;
    }

    public boolean restartOrEnd() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Result result = new Result(Console.readLine());
        return result.judgeRestartOrEnd();

    }
}
