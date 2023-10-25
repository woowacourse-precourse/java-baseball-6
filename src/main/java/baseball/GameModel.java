package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameModel {
    private List<Integer> computerNumbers;
    private int attempts;

    public GameModel() {
        computerNumbers = generateRandomNumber();
        attempts = 0;
    }

    private List<Integer> generateRandomNumber() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public Result checkGuess(List<Integer> userGuess) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < computerNumbers.size(); i++) {
            if (computerNumbers.get(i).equals(userGuess.get(i))) {
                strikes++;
            }
            else if (computerNumbers.contains(userGuess.get(i))) {
                balls++;
            }
        }

        attempts++;

        return new Result(strikes, balls);
    }

    public boolean isGameWon(Result result) {
        return result.getStrikes() == 3;
    }
}
