package baseball.model;

import static baseball.utils.Validator.NUMBER_LENGTH;

import baseball.entity.GameResult;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseballModel {
    public static final int MAX_SCORE = 3;
    public final GameResult gameResult;

    public BaseballModel(GameResult gameResult) {
        this.gameResult = gameResult;
    }

    public List<Integer> generateRandomUniqueNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!(randomNumbers.contains(randomNumber))) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    public GameResult calculateGameResult(List<Integer> computerNumber, List<Integer> playerNumber) {
        for (int i = 0; i < computerNumber.size(); i++) {
            if (Objects.equals(computerNumber.get(i), playerNumber.get(i))) {
                gameResult.getStrike().increaseCount();
            } else if (computerNumber.contains(playerNumber.get(i))) {
                gameResult.getBall().increaseCount();
            }
        }
        if (checkGameEnded(gameResult)) {
            gameResult.endGame();
        }
        return gameResult;
    }

    private boolean checkGameEnded(GameResult gameResult) {
        if (gameResult.getStrike().getCount() == MAX_SCORE) {
            return true;
        }
        return false;
    }
}
