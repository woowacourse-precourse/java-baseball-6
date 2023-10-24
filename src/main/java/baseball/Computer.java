package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    public List<Integer> generateRandomNumbers() {
        List<Integer> result = new ArrayList<>();
        while (result.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!result.contains(randomNumber)) {
                result.add(randomNumber);
            }
        }
        return result;
    }

    public GameResult calculateGameResult(List<Integer> targetNumbers, List<Integer> userGuess) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (userGuess.get(i).equals(targetNumbers.get(i))) {
                strikes++;
            } else if (targetNumbers.contains(userGuess.get(i))) {
                balls++;
            }
        }

        return new GameResult(strikes, balls);
    }

    public void printHint(GameResult result) {
        if (result.balls() > 0) {
            System.out.print(result.balls() + "볼 ");
        }
        if (result.strikes() > 0) {
            System.out.print(result.strikes() + "스트라이크");
        }
        if (result.balls() == 0 && result.strikes() == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }
}
