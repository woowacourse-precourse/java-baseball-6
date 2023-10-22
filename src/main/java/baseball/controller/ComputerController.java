package baseball.controller;

import baseball.model.GameNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ComputerController {
    private static final int INIT_ZERO = 0;
    private int strikeCount;
    private int ballCount;

    RandomUtility randomUtility = new RandomUtility();

    public void startGame(GameNumber gameNumber) {
        List<Integer> computerGenerateNumbers = Arrays.stream(randomUtility.generateAnswerNumbers()).boxed().collect(Collectors.toList());
        gameNumber.setComputerGenerateNumbers(computerGenerateNumbers);
    }

    public void initStrikeAndBallCount() {
        strikeCount = INIT_ZERO;
        ballCount = INIT_ZERO;
    }
}
