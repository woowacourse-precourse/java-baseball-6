package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    public int[] generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public int[] calculateResult(int[] guessNumbers, int[] randomNumbers) {
        int[] result = new int[2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (guessNumbers[i] == randomNumbers[j]) {
                    if (i == j) {
                        result[1]++;
                    } else {
                        result[0]++;
                    }
                }
            }
        }
        return result;
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
}
