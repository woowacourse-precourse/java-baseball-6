package baseball.service;

import baseball.model.GameResult;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseBallService {
    public List<Integer> generateRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
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
        for (int i = 0; i < 3; i++) {
            if (userInput.contains(targetNumber.get(i))) {
                ball++;
            }
            if (userInput.get(i).equals(targetNumber.get(i))) {
                strike++;
                ball--;
            }
        }
        return new GameResult(strike, ball);
    }
}
