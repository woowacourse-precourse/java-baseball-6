package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class Computer {
    public int[] generateRandomNumbers() {
        Set<Integer> randomNumbers = new HashSet<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            randomNumbers.add(randomNumber);
        }
        return randomNumbers.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] calculateResult(int[] guessNumbers, int[] randomNumbers) {
        int balls = countBalls(guessNumbers, randomNumbers);
        int strikes = countStrikes(guessNumbers, randomNumbers);

        return new int[]{balls, strikes};
    }

    private int countBalls(int[] guessNumbers, int[] randomNumbers) {
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            if (guessNumbers[i] != randomNumbers[i] && containsValue(randomNumbers, guessNumbers[i])) {
                balls++;
            }
        }
        return balls;
    }

    private int countStrikes(int[] guessNumbers, int[] randomNumbers) {
        int strikes = 0;
        for (int i = 0; i < 3; i++) {
            if (guessNumbers[i] == randomNumbers[i]) {
                strikes++;
            }
        }
        return strikes;
    }

    public String formatResult(int[] result) {
        if (result[0] > 0 && result[1] > 0) {
            return result[0] + "볼 " + result[1] + "스트라이크";
        } else if (result[0] > 0) {
            return result[0] + "볼";
        } else if (result[1] > 0) {
            return result[1] + "스트라이크";
        } else {
            return "낫싱";
        }
    }

    public boolean isGameOver(int[] result) {
        return result[1] == 3;
    }

    private boolean containsValue(int[] array, int value) {
        for (int num : array) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }
}
