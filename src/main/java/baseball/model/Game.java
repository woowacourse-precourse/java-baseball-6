package baseball.model;

import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final OutputView outputView = new OutputView();
    private List<Integer> computerNumbers;

    public Game() {
        computerNumbers = generateRandomNumber();
    }

    public boolean isCorrect(List<Integer> userNumbers) {
        int strikes = countStrikes(userNumbers);
        int balls = countBalls(userNumbers);

        String result = generateResult(strikes, balls);
        outputView.printResult(result);

        return strikes == 3;
    }

    private List<Integer> generateRandomNumber() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }

    private int countStrikes(List<Integer> userNumbers) {
        int strikes = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumbers.get(i).equals(userNumbers.get(i))) {
                strikes++;
            }
        }
        return strikes;
    }

    private int countBalls(List<Integer> userNumbers) {
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumbers.contains(userNumbers.get(i)) && !computerNumbers.get(i).equals(userNumbers.get(i))) {
                balls++;
            }
        }
        return balls;
    }

    private String generateResult(int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            return "낫싱";
        } else {
            StringBuilder result = new StringBuilder();
            if (balls > 0) {
                result.append(balls).append("볼 ");
            }
            if (strikes > 0) {
                result.append(strikes).append("스트라이크");
            }
            return result.toString();
        }
    }
}
