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
        } while (!is3Strikes());
    }

    public boolean is3Strikes() {
        if (judgement.strikes == 3) {
            OutputHandler.printGameEnd();
            return true;
        }
        return false;
    }

    private void tryGuess(BaseballNumber targetNumber) {
        BaseballNumber userGuess = new BaseballNumber(UserInput.inputNumbers());
        judgement.callBallOrStrike(targetNumber, userGuess);
        OutputHandler.printHint(judgement);
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
