package baseball.Controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.domain.Baseball;
import baseball.utils.Utils;
import java.util.List;

public class GameRunner {

    private final Baseball baseball;

    public GameRunner(Baseball baseball) {
        this.baseball = baseball;
    }

    public void run() {
        while (true) {
            List<Integer> playerNumber = getUserInput();
            int strikes = baseball.countStrikes(playerNumber);
            int balls = baseball.countBalls(playerNumber);
            printResult(strikes, balls);

            if (baseball.isGameWon(strikes)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private List<Integer> getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = readLine();
        Utils.validateUserInput(userInput);
        return Utils.stringToIntegerList(userInput);
    }

    private void printResult(int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
            return;
        }
        if (strikes > 0 && balls > 0) {
            System.out.printf("%d볼 %d스트라이크\n", balls, strikes);
            return;
        }
        if (strikes > 0) {
            System.out.printf("%d스트라이크\n", strikes);
            return;
        }
        if (balls > 0) {
            System.out.printf("%d볼\n", balls);
        }
    }
}