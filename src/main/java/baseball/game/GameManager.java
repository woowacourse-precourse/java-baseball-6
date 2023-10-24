package baseball.game;

import baseball.game.constant.Constants;
import baseball.game.domain.BaseBall;
import baseball.game.view.InputManager;
import baseball.game.view.OutputManager;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameManager {

    public List<Integer> createRandNumber() {
        List<Integer> randNumbers = new ArrayList<>();
        while (randNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randNumbers.contains(randomNumber)) {
                randNumbers.add(randomNumber);
            }
        }
        return randNumbers;
    }

    public BaseBall calculateBaseballGameResult(List<Integer> randBaseballNumber, String userBaseballNumber) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < randBaseballNumber.size(); i++) {
            if (randBaseballNumber.get(i).equals(Integer.valueOf(String.valueOf(userBaseballNumber.charAt(i))))) {
                strike++;
                continue;
            }
            if (randBaseballNumber.contains(Integer.valueOf(String.valueOf(userBaseballNumber.charAt(i))))) {
                ball++;
            }
        }

        return new BaseBall(strike, ball);
    }

    public void playGame() {
        InputManager.printGameStartMessage();
        List<Integer> randBaseballNumber = createRandNumber();
        while (true) {
            String userBaseballNumber = InputManager.getBaseballNumberFromUser();
            BaseBall baseBall = calculateBaseballGameResult(randBaseballNumber, userBaseballNumber);
            OutputManager.printHint(baseBall.getStrike(), baseBall.getBall());

            if (isCorrectBaseballNumber(baseBall.getStrike())) {
                OutputManager.printEndMessage();
                break;
            }
        }
    }

    private boolean isCorrectBaseballNumber(int strike) {
        return strike == Constants.BASEBALL_SIZE;
    }
}
