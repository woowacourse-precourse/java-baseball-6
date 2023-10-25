package baseball.controller;

import static baseball.common.exception.BaseBallExceptionMessage.INVALID_COMMAND;
import static baseball.config.BaseBallGameConfig.BASEBALL_GAME_EXIT;
import static baseball.config.BaseBallGameConfig.BASEBALL_GAME_RESTART;

import baseball.common.exception.BaseBallGameException;
import baseball.model.BaseBallNumber;
import baseball.view.ConsoleInput;
import baseball.view.ConsoleOutput;
import baseball.model.BallCount;
import camp.nextstep.edu.missionutils.Console;

public class BaseBallApp {

    public void run() {
        ConsoleOutput.gameStart();
        do {
            BaseBallNumber computerNumber = BaseBallNumber.generateRandomNumbers();
            play(computerNumber);
        } while(isRestart());
    }

    private void play(BaseBallNumber computerNumber) {
        while(true) {
            String inputString = ConsoleInput.askInputNumber();
            BaseBallNumber inputNumber = BaseBallNumber.generateNumber(inputString);
            BallCount ballCount = BallCount.generateBallCount(computerNumber, inputNumber);
            ConsoleOutput.print(ballCount.getResultMessage());
            if(ballCount.isFinished()) {
                ConsoleOutput.collect();
                break;
            }
        }
    }

    private boolean isRestart() {
        String command = ConsoleInput.askRestart();

        if(!isExitCommand(command) && !isRestartCommand(command)) throw new BaseBallGameException(INVALID_COMMAND);
        if(isExitCommand(command)) {
            ConsoleOutput.close();
            Console.close();
            return false;
        }
        return isRestartCommand(command);
    }

    private boolean isExitCommand(String command) {
        return command.equals(BASEBALL_GAME_EXIT.toString());
    }

    private boolean isRestartCommand(String command) {
        return command.equals(BASEBALL_GAME_RESTART.toString());
    }


}
