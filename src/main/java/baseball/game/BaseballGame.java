package baseball.game;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.domain.BaseballFactory;
import baseball.domain.ComputerBaseballs;
import baseball.domain.UserBaseballs;
import baseball.dto.Result;

public class BaseballGame {
    private ComputerBaseballs computerBaseballs;
    private Referee referee;

    public BaseballGame() {
        computerBaseballs = null;
        referee = new Referee();
    }

    public void play() {
        init();

        Result result;
        do {
            result = playOnce();
            System.out.println(result.toString());
        } while (!referee.isUserWin(result));

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void init() {
        computerBaseballs = BaseballFactory.createComputerBaseballs();
    }

    private Result playOnce() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = readLine();

        UserBaseballs userBaseballs = BaseballFactory.createUserBaseballs(userInput);

        return referee.createResult(computerBaseballs, userBaseballs);
    }
}
