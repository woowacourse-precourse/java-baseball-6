package baseball.service;

import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.constant.Number.NUMBER_LENGTH;
import static baseball.constant.Number.NUMBER_RANGE_START;
import static baseball.constant.Number.NUMBER_RANGE_END;
import static baseball.constant.Number.WIN;
import static baseball.constant.Number.FAIL;

public class ComputerService {

    private final OutputView outputView = new OutputView();

    private class ScoreResult {
        public final int balls;
        public final int strikes;

        public ScoreResult(int balls, int strikes) {
            this.balls = balls;
            this.strikes = strikes;
        }
    }

    public void printInit() {
        outputView.startGameMessage();
    }

    public List<Integer> generateComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();

        while (computerNumbers.size() < NUMBER_LENGTH) {
            int randomNum = Randoms.pickNumberInRange(NUMBER_RANGE_START, NUMBER_RANGE_END);
            if (!computerNumbers.contains(randomNum)) {
                computerNumbers.add(randomNum);
            }
        }

        return computerNumbers;
    }

    public boolean getResult(List<Integer> computerNumbers, List<Integer> userNumbers){
        ScoreResult scoreResult = calculateStrikeAndBalls(computerNumbers, userNumbers);
        outputView.resultMessage(scoreResult.balls, scoreResult.strikes);

        if (scoreResult.strikes==NUMBER_LENGTH) {
            outputView.winMessage();
            return WIN;
        }
        return FAIL;
    }

    private ScoreResult calculateStrikeAndBalls(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strikes = calculateStrikes(computerNumbers, userNumbers);
        int balls = calculateBalls(computerNumbers, userNumbers) - strikes;

        return new ScoreResult(balls, strikes);
    }

    private int calculateStrikes(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strikes = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (userNumbers.get(i).equals(computerNumbers.get(i))) {
                strikes++;
            }
        }
        return strikes;
    }

    private int calculateBalls(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int balls = 0;
        for (int userNumber : userNumbers) {
            if (computerNumbers.contains(userNumber)) {
                balls++;
            }
        }
        return balls;
    }

}
