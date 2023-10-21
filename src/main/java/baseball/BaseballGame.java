package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private final Judgement judgement;

    public BaseballGame() {
        judgement = new Judgement();
    }

    public void start() {
        do {
            playGame();
        } while (wantsToRestart());
    }

    private void playGame() {
    }

    public boolean wantsToRestart() {
        OutputHandler.printGameRestart();
        String input = Console.readLine();
        if (input.equals("1")) {
            return true;
        }
        if (input.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
