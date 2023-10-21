package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private Computer computerNumbers;
    private Player playerNumbers;
    private Hint hint;

    public BaseballGame() {}

    public void run() {
        Printer.printGameStart();

        boolean gameQuit;
        do {
            playGame();
            Printer.printGameWin();

            Printer.printGameRestartOrQuit();
            String input = Console.readLine();
            GameRestartOrQuit gameRestartOrQuit = GameRestartOrQuit.from(input);
            gameQuit = gameRestartOrQuit.isGameQuit();
        } while(!gameQuit);
    }

    private void playGame() {
        computerNumbers = Computer.create();

        boolean threeStrike;
        do {
            Printer.printInputNumber();
            String input = Console.readLine();
            playerNumbers = Player.from(input);

            hint = Hint.of(computerNumbers.getComputer(), playerNumbers.getPlayerNumbers());
            Printer.printHint(hint);
            threeStrike = hint.isThreeStrike();
        } while(!threeStrike);
    }
}
