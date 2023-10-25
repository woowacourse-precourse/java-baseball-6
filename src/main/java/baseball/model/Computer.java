package baseball.model;

import baseball.utils.RandomNumberGenerator;
import java.util.List;

public class Computer {
    private List<Integer> baseballNumbers;

    public Computer() {
        baseballNumbers = RandomNumberGenerator.generateRandomNumber();
    }

    public Result getStrikesAndBalls(List<Integer> userGuess) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < baseballNumbers.size(); i++) {
            int computerNumber = baseballNumbers.get(i);
            int userNumber = userGuess.get(i);

            if (computerNumber == userNumber) {
                strikes++;
            } else if (userGuess.contains(computerNumber)) {
                balls++;
            }
        }

        return new Result(strikes, balls);
    }
}
