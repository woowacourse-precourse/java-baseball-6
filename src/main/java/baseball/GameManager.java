package baseball;

import baseball.game.InputManager;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
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
    public String calculateHint(List<Integer> randBaseballNumber, String userBaseballNumber) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < randBaseballNumber.size(); i++) {
            if (randBaseballNumber.get(i).equals(Integer.valueOf(userBaseballNumber.charAt(i)))) {
                strike++;
                continue;
            }

            if (randBaseballNumber.contains(Integer.valueOf(userBaseballNumber.charAt(i)))) {
                ball++;
            }
        }
        return String.format("%s 스트라이크 %s 볼", strike, ball);
    }

    public void playGame() {
        InputManager inputManager = new InputManager();

        List<Integer> randBaseballNumber = createRandNumber();
        String userBaseballNumber = inputManager.getBaseballNumberFromUser(inputManager);
        String hint = calculateHint(randBaseballNumber, userBaseballNumber);
    }
}
