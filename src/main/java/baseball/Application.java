package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        Printer.printGameStart();

        boolean gameQuit;
        do {
            runGame();
            Printer.printGameWin();

            Printer.printGameRestartOrQuit();
            String input = Console.readLine();
            GameRestartOrQuit gameRestartOrQuit = GameRestartOrQuit.from(input);
            gameQuit = isGameQuit(gameRestartOrQuit.getRestartOrQuitNumber());
        } while(!gameQuit);
    }

    private static void runGame() {
        Computer computerNumbers = Computer.create();

        boolean threeStrike;
        do {
            Printer.printInputNumber();
            String input = Console.readLine();
            Player playerNumbers = Player.from(input);

            Hint hint = Hint.of(computerNumbers.getComputer(), playerNumbers.getPlayerNumbers());
            Printer.printHint(hint);
            threeStrike = hint.isThreeStrike();
        } while(!threeStrike);
    }

    private static boolean isGameQuit(String number) {
        return number.equals(Constants.GAME_QUIT);
    }
}
