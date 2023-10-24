package baseball;

import java.util.Map;

import static baseball.constants.Rule.GAME_RESTART;
import static baseball.constants.Rule.SUCCESS_STRIKE_COUNT;

public class BaseballGame {
    private static Computer computer;

    /**
     * 게임을 시작하는 메서드
     */
    public static void play() {
        computer = new Computer();
        do {
            computer.generateNumbers();
            gameStart();
        } while (askRestart());
    }

    /**
     * 게임 한 판 진행
     */
    private static void gameStart() {
        Console.printGameStartMessage();
        while (true) {
            Console.printInputMessage();

            String input = Console.readNumbers();
            Map<BaseBallType, Integer> result = computer.compareNumbers(input);
            Console.printResult(result.get(BaseBallType.BALL), result.get(BaseBallType.STRIKE));

            if (result.get(BaseBallType.STRIKE) == SUCCESS_STRIKE_COUNT) {
                break;
            }
        }
        Console.printSuccessEndMessage();
    }

    /**
     * 게임 재시작 여부를 묻는 메서드
     *
     * @return 게임 재시작 여부
     */
    private static boolean askRestart() {
        Console.printGameRestartOrEndMessage();
        return Console.readRestartOrEnd().equals(String.valueOf(GAME_RESTART));
    }
}
