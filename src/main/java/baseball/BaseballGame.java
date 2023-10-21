package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private final Judgement judgement;

    public BaseballGame() {
        judgement = new Judgement();
    }

    public void start() {
        OutputHandler.printGameStart();
        do {
            playGame();
        } while (wantsToRestart());
    }

    private void playGame() {
        BaseballNumber targetNumber = new BaseballNumber(Computer.generateNumbers());
        do {
            tryGuess(targetNumber);
        } while (!isEndOfGame());
    }

    public boolean isEndOfGame() {
        if (judgement.is3Strikes()) {
            OutputHandler.printGameEnd();
            return true;
        }
        return false;
    }

    private void tryGuess(final BaseballNumber targetNumber) {
        BaseballNumber userGuess = new BaseballNumber(UserInput.inputNumbers());
        judgement.callBallOrStrike(targetNumber, userGuess);
        OutputHandler.printMessage(judgement.toString());
    }

    public boolean wantsToRestart() {
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
