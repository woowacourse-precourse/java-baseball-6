package baseball;

import baseball.controller.BaseballController;
import baseball.domain.BallAndStrike;
import baseball.domain.BaseBallNumber;
import baseball.service.BaseballService;

public class BaseballGame {
    private final static String GAME_RESET_CMD = "1";
    private final static String GAME_EXIT_CMD = "2";
    private boolean restartFlag = false;

    public void run(int numSize) {
        BaseballController baseballController = new BaseballController(numSize);
        baseballController.userGameStart();

        do {
            BaseBallNumber cpuNumber = BaseBallNumber.generateRandomNumber();
            BaseballService baseballService = new BaseballService(cpuNumber);

            guessUserAnswer(numSize, baseballService, baseballController);
        } while (!restartFlag);

    }

    private void guessUserAnswer(int numSize, BaseballService baseballService, BaseballController baseballController) {
        BallAndStrike ballAndStrike;
        do {
            BaseBallNumber userBaseBallNumber = baseballController.requestUserBaseBallNumberInput();

            ballAndStrike = baseballService.checkBallAndStrike(userBaseBallNumber);
            baseballController.userGuessBallAndStrike(ballAndStrike);

        } while (!isUserCorrectAnswer(numSize, ballAndStrike));

        baseballController.userGameEnd();

        String command = "";
        command = baseballController.requestUserGameExit();
        validateCommand(command);

        if (command.equals(GAME_EXIT_CMD)) {
            restartFlag = true;
        }
    }

    private void validateCommand(String command) {
        if (!(command.equals(GAME_EXIT_CMD) || command.equals(GAME_RESET_CMD))) {
            throw new IllegalArgumentException("커맨드를 다시 입력해주세요");
        }
    }

    private static boolean isUserCorrectAnswer(int numSize, BallAndStrike ballAndStrike) {
        return ballAndStrike.getStrikes() == numSize;
    }
}
