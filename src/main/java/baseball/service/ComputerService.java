package baseball.service;

import baseball.constant.Number;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerService {

    private String computerNumber;
    private final OutputView outputView = new OutputView();

    private class ScoreResult {
        public final int balls;
        public final int strikes;

        public ScoreResult(int balls, int strikes) {
            this.balls = balls;
            this.strikes = strikes;
        }
    }

    public void printStart() {
        outputView.startGameMessage();
    }

    public List<Integer> generateComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();

        while (computerNumbers.size() < Number.NUMBER_LENGTH) {
            int randomNum = Randoms.pickNumberInRange(Number.NUMBER_RANGE_START, Number.NUMBER_RANGE_END);
            if (!computerNumbers.contains(randomNum)) {
                computerNumbers.add(randomNum);
            }
        }

        return computerNumbers;
    }

    public boolean printResult(List<Integer> computerNumbers, List<Integer> userNumbers){
        ScoreResult scoreResult = calculateStrikeAndBalls(computerNumbers, userNumbers);

        outputView.resultMessage(scoreResult.balls, scoreResult.strikes);

        if (scoreResult.strikes==Number.NUMBER_LENGTH) {
            outputView.winMessage();
            return true;
        }
        return false;
    }

    private ScoreResult calculateStrikeAndBalls(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < Number.NUMBER_LENGTH; i++) {
            int computerNumber = computerNumbers.get(i);
            int userNumber = userNumbers.get(i);

            if (userNumber == computerNumber) {
                strikes++;
                continue;
            }

            if (computerNumbers.contains(userNumber)) {
                balls++;
            }
        }

        return new ScoreResult(balls, strikes);
    }
}
