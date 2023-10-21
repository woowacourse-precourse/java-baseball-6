package baseball.game;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.domain.BaseballFactory;
import baseball.domain.ComputerBaseballs;
import baseball.domain.UserBaseballs;
import baseball.dto.Result;

public class BaseballGame {
    private ComputerBaseballs computerBaseballs;
    private Result result;


    public void play() {
        init();

        do {
            result = playOnce();
            System.out.println(result.toString());
        } while (!result.isAllStrike());

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void init() {
        computerBaseballs = BaseballFactory.createComputerBaseballs();
        result = null;
    }

    private Result playOnce() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = readLine();
        UserBaseballs userBaseballs = BaseballFactory.createUserBaseballs(userInput);

        int ballCount = computerBaseballs.countBall(userBaseballs);
        int strikeCount = computerBaseballs.countStrike(userBaseballs);

        return new Result(ballCount, strikeCount);
    }
}
