package baseball.service;

import baseball.model.GameResult;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseBallService {

    private static final int NUMBER_OF_DIGITS = 3;

    public List<Integer> generateRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUMBER_OF_DIGITS ) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public GameResult getGameResult(List<Integer> targetNumber, List<Integer> userInput) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < NUMBER_OF_DIGITS; i++) {
            if (userInput.get(i).equals(targetNumber.get(i))) {
                strike++;
            } else if (targetNumber.contains(userInput.get(i))) {
                ball++;
            }
        }
        return new GameResult(strike, ball);
    }
}
