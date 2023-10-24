package baseball;

import java.util.List;

public class NumberComparer {


    public static boolean compareNumbers(int inputNumber, List<Integer> computer) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 2; i >=0; i--) {
            int playerNumberDigit = inputNumber % 10;

            if (computer.contains(playerNumberDigit)) {
                strikeCount += computer.get(i) == playerNumberDigit ? 1 : 0;
                ballCount += computer.get(i) != playerNumberDigit ? 1 : 0;
            }

            inputNumber /= 10;
        }
        ResultPrinter.printResult(strikeCount, ballCount);

        if (strikeCount == 3) {
            return true;
        }
        return false;
    }
}
