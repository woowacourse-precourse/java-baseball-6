package baseball.controller;

import baseball.view.Input;
import baseball.view.Output;
import java.util.List;

public class GameController {

    private final Input input = new Input();
    private final Output output = new Output();
    private final UserUtil userUtil = new UserUtil();
    private final RandomUtil randomUtil = new RandomUtil();
    private final Validation validation = new Validation();

    private List<Integer> computerNumbers;

    public GameController() {
        output.printStartGame();
    }

    public void startGame() {
        int gameControlNum = 1;
        computerNumbers = randomUtil.generateRandomNumber();

        while (gameControlNum == 1) {
            input.printInputMsg();
            String userInput = userUtil.getInputNumber();
            List<Integer> userNums = validation.validateInputNum(userInput);

            ResultCount result = compareNumber(computerNumbers, userNums);
            int ball = result.ballCount;
            int strike = result.strikeCount;
            output.printResult(ball, strike);

            gameControlNum = checkStrikeCount(strike);
        }
    }

    private static class ResultCount {
        int ballCount;
        int strikeCount;

        public ResultCount(int ballCount, int strikeCount) {
            this.ballCount = ballCount;
            this.strikeCount = strikeCount;
        }
    }

    private ResultCount compareNumber(List<Integer> computerNumbers, List<Integer> userNums) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            int computerNum = computerNumbers.get(i);
            int userNum = userNums.get(i);

            if (computerNum == userNum) {
                strike++;
                continue;
            }

            if (computerNumbers.contains(userNum)) {
                ball++;
            }
        }

        return new ResultCount(ball, strike);
    }

    private int checkStrikeCount(int strike) {
        int gameControlInput = 1;

        if (strike == 3) {
            output.printSuccessGame();
            gameControlInput = Integer.parseInt(userUtil.getInputNumber());
            validation.validateGameControlInput(gameControlInput);

            checkRestartAndMakeRandomNumber(gameControlInput);
        }

        return gameControlInput;
    }

    private void checkRestartAndMakeRandomNumber(int gameControlInput) {
        if (gameControlInput == 1) {
            computerNumbers = randomUtil.generateRandomNumber();
        }
    }

}
