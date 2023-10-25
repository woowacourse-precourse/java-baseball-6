package baseball.core;

import baseball.domain.BaseballNumber;
import baseball.domain.Computer;
import baseball.domain.Judge;
import baseball.io.OutputHandler;
import baseball.io.UserInput;
import camp.nextstep.edu.missionutils.Console;

public class GameRunner {
    private final Judge judge;

    public GameRunner() {
        judge = new Judge();
    }

    public void start() {
        OutputHandler.printGameStart();
        do {
            playGame();
        } while (askToRestart());
    }

    private void playGame() {
        BaseballNumber targetNumber = new BaseballNumber(Computer.generateNumbers());
        do {
            tryGuess(targetNumber);
        } while (!isEndOfGame());
    }

    public boolean isEndOfGame() {
        if (judge.isMaxStrikes()) {
            OutputHandler.printGameEnd();
            return true;
        }
        return false;
    }

    private void tryGuess(final BaseballNumber targetNumber) {
        BaseballNumber userGuess = new BaseballNumber(UserInput.inputNumbers());
        judge.callBallOrStrike(targetNumber, userGuess);
        OutputHandler.printMessage(judge.toString());
    }

    public boolean askToRestart() {
        OutputHandler.printGameRestart();
        String input = Console.readLine();
        if (input.equals("1")) {
            return true;
        }
        if (input.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}
