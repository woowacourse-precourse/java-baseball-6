package game.controller;


import game.model.Computer;
import game.model.Player;
import game.view.GameMessage;
import game.util.InputValidation;

import java.util.List;

import static constant.NumberConst.*;

public class BaseballGame {
    private final Player player = new Player();

    private final GameMessage gameMessage = new GameMessage();

    private final Computer computer = new Computer();

    private final InputValidation validator = new InputValidation();

    private List<Integer> computerNums;

    public BaseballGame() {
        gameMessage.printInitMsg();
    }

    public void startGame() {
        int gameControlNum = RESTART_NUM;
        computerNums = computer.generateNumber();

        while (gameControlNum == RESTART_NUM) {
            gameMessage.printInputMsg();
            String userInput = player.getInputNumber();
            List<Integer> userNums = validator.validateInputNum(userInput);

            ResultCount result = compareNumber(computerNums, userNums);
            int ball = result.ballCount;
            int strike = result.strikeCount;
            gameMessage.printResultMsg(ball, strike);

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
            gameMessage.printSuccessMsg();
            gameControlInput = Integer.parseInt(player.getInputNumber());
            validator.validateGameControlInput(gameControlInput);

            checkRestartNumAndMakeComputerNum(gameControlInput);
        }

        return gameControlInput;
    }

    private void checkRestartNumAndMakeComputerNum(int gameControlInput) {
        if (gameControlInput == RESTART_NUM) {
            computerNums = computer.generateNumber();
        }
    }
}