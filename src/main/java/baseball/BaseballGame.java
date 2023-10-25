package baseball;

import baseball.util.ComputerUtil;
import baseball.util.MessageUtil;
import baseball.util.UserUtil;
import baseball.validation.InputValidation;

import java.util.List;

import static baseball.constant.NumberConst.*;

public class BaseballGame {
    private final UserUtil userUtil = new UserUtil();

    private final MessageUtil messageUtil = new MessageUtil();

    private final ComputerUtil computerUtil = new ComputerUtil();

    private final InputValidation validator = new InputValidation();

    private List<Integer> computerNums;

    public BaseballGame() {
        messageUtil.printInitMsg();
    }

    public void startGame() {
        int gameControlNum = RESTART_NUM;
        computerNums = computerUtil.generateNumber();

        while (gameControlNum == RESTART_NUM) {
            messageUtil.printInputMsg();
            String userInput = userUtil.getInputNumber();
            List<Integer> userNums = validator.validateInputNum(userInput);

            ResultCount result = compareNumber(computerNums, userNums);
            int ball = result.ballCount;
            int strike = result.strikeCount;
            messageUtil.printResultMsg(ball, strike);

            gameControlNum = checkStrikeCount(strike);
        }
    }

    private ResultCount compareNumber(List<Integer> computerNums, List<Integer> userNums) {
        int ball = 0, strike = 0;

        for (int i = 0; i < INPUT_LENGTH; i++) {
            int computerNum = computerNums.get(i);
            int userNum = userNums.get(i);

            if (computerNum == userNum) {
                strike++;
                continue;
            }

            if (computerNums.contains(userNum)) {
                ball++;
            }
        }

        return new ResultCount(ball, strike);
    }

    private static class ResultCount {
        int ballCount;
        int strikeCount;

        public ResultCount(int ballCount, int strikeCount) {
            this.ballCount = ballCount;
            this.strikeCount = strikeCount;
        }
    }

    private int checkStrikeCount(int strike) {
        int gameControlInput = RESTART_NUM;

        if (strike == MAX_STRIKE) {
            messageUtil.printSuccessMsg();
            gameControlInput = Integer.parseInt(userUtil.getInputNumber());
            validator.validateGameControlInput(gameControlInput);

            checkRestartNumAndMakeComputerNum(gameControlInput);
        }

        return gameControlInput;
    }

    private void checkRestartNumAndMakeComputerNum(int gameControlInput) {
        if (gameControlInput == RESTART_NUM) {
            computerNums = computerUtil.generateNumber();
        }
    }
}