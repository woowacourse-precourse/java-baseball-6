package baseball;

import java.util.List;

public class NumberComparer {
    public static int compareNumber(int playerNumber, List<Integer> randomNumber) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 2; i >= 0; i--) {
            int numberDigit = playerNumber % 10;
            if (randomNumber.contains(numberDigit)) {
                if (randomNumber.get(i) == numberDigit) strikeCount++;
                else ballCount++;
            }
            playerNumber /= 10;
        }
        MessagePrinter.printResultMessage(strikeCount,ballCount);
        return strikeCount;
    }

}
