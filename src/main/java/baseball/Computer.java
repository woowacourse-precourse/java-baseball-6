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
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
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
        if (result.getBalls() > 0) {
            System.out.print(result.getBalls() + "볼 ");
        }
        if (result.getStrikes() > 0) {
            System.out.print(result.getStrikes() + "스트라이크");
        }
        if (result.getBalls() == 0 && result.getStrikes() == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }
}
