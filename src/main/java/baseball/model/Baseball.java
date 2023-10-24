package baseball.model;

import static baseball.constant.Constants.GAME_STOP_MESSAGE;
import static baseball.constant.Constants.INPUT_MAX_SIZE;
import static baseball.constant.Constants.INPUT_NUM_MAX;
import static baseball.constant.Constants.INPUT_NUM_MIN;
import static baseball.constant.Constants.INPUT_PREDICTED_MESSAGE;

import baseball.io.InputHandler;
import baseball.io.OutputHandler;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Baseball implements Game {

    private final List<Integer> computer;
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public Baseball(InputHandler inputHandler, OutputHandler outputHandler) {
        computer = new ArrayList<>();
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    @Override
    public void initGame() {
        while (computer.size() < INPUT_MAX_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(INPUT_NUM_MIN, INPUT_NUM_MAX);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    @Override
    public void playGame() {
        ResultScoreBoard resultScore = new ResultScoreBoard(0, 0);
        while (!isFullStrike(resultScore.strike())) {
            System.out.print(INPUT_PREDICTED_MESSAGE);
            int input = inputHandler.scanInteger();
            List<Integer> expectedNums = inputHandler.inputToExpectedNumber(input);
            resultScore = compareExpect(expectedNums);
            outputHandler.printScore(resultScore);
        }
        System.out.println(GAME_STOP_MESSAGE);
    }

    private ResultScoreBoard compareExpect(List<Integer> expectedNums) {
        int ball = (int) expectedNums.stream()
                .filter(computer::contains)
                .count();

        int strike = (int) IntStream.range(0, INPUT_MAX_SIZE)
                .filter(i -> Objects.equals(expectedNums.get(i), computer.get(i)))
                .count();

        ball -= strike;

        return new ResultScoreBoard(strike, ball);
    }

    private Boolean isFullStrike(int strike) {
        return strike == INPUT_MAX_SIZE;
    }
}
