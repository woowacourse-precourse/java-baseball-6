package baseball;

import baseball.enums.BaseBallType;

import java.util.Map;

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

            if (result.get(BaseBallType.STRIKE) == 3) {
                break;
            }
        }
        Console.printSuccessEndMessage();
    }

    private static boolean askRestart() {
        Console.printGameRestartOrEndMessage();
        return Console.readRestartOrEnd().equals("1");
    }
}
