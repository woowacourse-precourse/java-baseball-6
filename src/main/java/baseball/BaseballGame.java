package baseball;

import java.util.Map;

import static baseball.constants.Rule.GAME_RESTART;
import static baseball.constants.Rule.SUCCESS_STRIKE_COUNT;

public class BaseballGame {
    private static Computer computer;

    public static void play() {
        computer = new Computer();
        do {
            computer.generateNumbers();
            gameStart();
        } while (askRestart());
    }

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

    private static boolean askRestart() {
        Console.printGameRestartOrEndMessage();
        return Console.readRestartOrEnd().equals(String.valueOf(GAME_RESTART));
    }
}
