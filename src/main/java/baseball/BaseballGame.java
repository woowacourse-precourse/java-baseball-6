package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private final Computer computer;
    private final UserInput userInput;
    private final Judgement judgement;
    private final OutputHandler outputHandler;

    public BaseballGame() {
        computer = new Computer();
        userInput = new UserInput();
        judgement = new Judgement();
        outputHandler = new OutputHandler();
    }

    public void start() {
        do {
            playGame();
        } while (wantsToRestart());
    }

    private void playGame() {
    }

    public boolean wantsToRestart() {
        outputHandler.printGameRestart();
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
