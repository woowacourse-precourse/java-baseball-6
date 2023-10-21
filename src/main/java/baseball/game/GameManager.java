package baseball.game;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.domain.BaseballFactory;
import baseball.domain.ComputerBaseballs;
import baseball.domain.UserBaseballs;
import baseball.dto.Result;

public class GameManager {
    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            ComputerBaseballs computerBaseballs = BaseballFactory.createComputerBaseballs();

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String userInput = readLine();
                UserBaseballs userBaseballs = BaseballFactory.createUserBaseballs(userInput);

                int ballCount = computerBaseballs.countBall(userBaseballs);
                int strikeCount = computerBaseballs.countStrike(userBaseballs);

                Result result = new Result(ballCount, strikeCount);
                System.out.println(result.toString());
                if (result.isAllStrike()) {
                    break;
                }
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String userInput = readLine();
            if (userInput.equals("1")) {
                continue;
            } else if (userInput.equals("2")) {
                break;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }
}
