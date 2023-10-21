package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private static final int NUMBER_LENGTH = 3;

    public static boolean play() {
        List<Integer> randomNumbers = createRandomNumber();

        while (true) {
            Printer.input();
            String input = Console.readLine();
            List<Integer> inputNumbers;

            try {
                inputNumbers = InputValidator.checkInputNumber(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            Baseball value = InputValidator.matchNumbers(inputNumbers, randomNumbers);

            if (ResultEvaluator.evaluate(value)) {
                return ResultEvaluator.restart();
            }
        }
    }

    private static List<Integer> createRandomNumber() {
        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }

        return randomNumbers;
    }
}
