package baseball;

import baseball.model.Computer;
import baseball.util.Message;
import baseball.model.Player;
import baseball.util.Validation;

import java.util.List;

import static baseball.constant.ConsoleNumber.*;

public class Playbaseball {

    private final Player userUtil = new Player();

    private final Message messageUtil = new Message();

    private final Computer computerUtil = new Computer();

    private final Validation validator = new Validation();

    private List<Integer> computerNums;

    public Playbaseball() {
        messageUtil.printSTART();
    }

    public void startGame() {
        int gameControlNum = RESTART_NUM;
        computerNums = computerUtil.createNumber();

        while (gameControlNum == RESTART_NUM) {
            messageUtil.printInput();
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

        for (int i = 0; i < LENGTH; i++) {
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

        if (strike == CORRECT_STRIKE) {
            messageUtil.printSuccessMsg();
            gameControlInput = Integer.parseInt(userUtil.getInputNumber());
            validator.validateGameControlInput(gameControlInput);

            checkRestartNumAndMakeComputerNum(gameControlInput);
        }

        return gameControlInput;
    }

    private void checkRestartNumAndMakeComputerNum(int gameControlInput) {
        if (gameControlInput == RESTART_NUM) {
            computerNums = computerUtil.createNumber();
        }
        if ((gameControlInput != RESTART_NUM) && (gameControlInput != FINISH_NUM)) {
            validator.validateReGameInput();
        }
    }
}



