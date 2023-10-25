package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private List<Integer> computerNumbers;
    private int attempts;
    private boolean gameOver;

    public BaseballGame() {
        computerNumbers = generateRandomNumbers();
        attempts = 0;
        gameOver = false;
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public String guess(int[] numbers) {
        int strikes = 0;
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            if (numbers[i] == computerNumbers.get(i)) {
                strikes++;
            } else {
                for (int j = 0; j < 3; j++) {
                    if (numbers[i] == computerNumbers.get(j)) {
                        balls++;
                    }
                }
            }
        }

        attempts++;
        if (strikes == 3) {
            gameOver = true;
        }

        if (strikes > 0 && balls > 0) {
            return balls + "볼 " + strikes + "스트라이크";
        } else if (strikes > 0) {
            return strikes + "스트라이크";
        } else if (balls > 0) {
            return balls + "볼";
        } else {
            return "낫싱";
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void resetGame() {
        computerNumbers = generateRandomNumbers();
        attempts = 0;
        gameOver = false;
    }
}
