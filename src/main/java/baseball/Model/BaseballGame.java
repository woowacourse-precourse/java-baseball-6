package baseball.Model;

import baseball.View.InputView;
import baseball.View.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private List<Integer> computerNumbers;

    public void initializeGame() {
        computerNumbers = generateRandomNumbers();
    }

    public boolean play(InputView inputView, OutputView outputView) {
        while (true) {
            List<Integer> playerNumbers = inputView.readNumbers();
            int strikes = 0;
            int balls = 0;

            for (int i = 0; i < 3; i++) {
                if (computerNumbers.get(i).equals(playerNumbers.get(i))) {
                    strikes++;
                } else if (playerNumbers.contains(computerNumbers.get(i))) {
                    balls++;
                }
            }

            outputView.displayGameResult(balls, strikes);

            if (strikes == 3) {
                return true;
            }
        }
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
