package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Model {
    private static final int NUMBER_LENGTH = 3;
    public static final int MAX_STRIKES = 3;
    private boolean isGameEnded = false;

    public boolean isGameEnded() {
        return isGameEnded;
    }

    public void setGameEnded(boolean gameEnded) {
        isGameEnded = gameEnded;
    }

    public List<Integer> generateRandomNumber() {

        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!(randomNumbers.contains(randomNumber))) {
                randomNumbers.add(randomNumber);
            }
        }

        return randomNumbers;
    }

    public GameResult calculateScore(List<Integer> computerNumber, List<Integer> playerNumber) {

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < computerNumber.size(); i++) {
            if (Objects.equals(computerNumber.get(i), playerNumber.get(i))) {
                strike++;
            } else if (computerNumber.contains(playerNumber.get(i))) {
                ball++;
            }
        }

        return new GameResult(strike, ball, strike == MAX_STRIKES);
    }
}
