package baseball.Model;

import baseball.View.InputView;
import baseball.View.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private List<Integer> computerNumbers;
    private static int INPUTLENGTH = 3;
    private static int MIN_RANGE = 1;
    private static int MAX_RANGE = 9;
    private static int INITIAL_VALUE = 0;

    public void initializeGame() {
        computerNumbers = generateRandomNumbers();
    }

    public boolean play(InputView inputView, OutputView outputView) {
        boolean isGameWon = false;
        while (!isGameWon) {
            List<Integer> playerNumbers = inputView.readNumbers();
            int strikes = countStrikes(playerNumbers);
            int balls = countBalls(playerNumbers);
            outputView.displayGameResult(balls, strikes);
            if (strikes == INPUTLENGTH) {
                isGameWon = true;
            }
        }
        return isGameWon;
    }

    private int countStrikes(List<Integer> playerNumbers) {
        Integer strikes = Integer.valueOf(0);
        for (int i = INITIAL_VALUE; i < INPUTLENGTH; i++) {
            if (computerNumbers.get(i).equals(playerNumbers.get(i))) {
                strikes++;
            }
        }

        return strikes;
    }

    private int countBalls(List<Integer> playerNumbers) {
        Integer balls = Integer.valueOf(0);

        for (int i = INITIAL_VALUE; i < INPUTLENGTH; i++) {
            if (!computerNumbers.get(i).equals(playerNumbers.get(i)) && playerNumbers.contains(
                    computerNumbers.get(i))) {
                balls++;
            }
        }
        return balls;
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < INPUTLENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}