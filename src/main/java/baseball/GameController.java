package baseball;

import camp.nextstep.edu.missionutils.Console;

/**
 * The 'GameController' class controls the flow of the baseball game.
 * */
public class GameController {
    private static final String YES = "1";
    private static final String NO = "2";

    public static void start() {
        boolean gameOn = true;

        Printer.castStartTheGameMessage();
        Numbers computer = Numbers.getComputerNumbers();
        do {
            Numbers player = Numbers.getPlayerNumbers();

            Score score = new Score(computer.getNumbers(), player.getNumbers());
            score.calculate();

            Printer.castCurrentScore(score);

            if (score.isStrike()) {
                Printer.castEndTheGameMessage();

                if (wantToRetry()) {
                    computer = Numbers.getComputerNumbers();
                } else {
                    gameOn = false;
                }
            }

        }
        while (gameOn);
    }

    /**
     * Asks the player if they want to retry the game.
     * @return true if the player wants to retry, false otherwise.
     * @throws IllegalArgumentException if the input is not "1" or "2".
     * */
    private static boolean wantToRetry() {
        Printer.askRetry();
        String input = Console.readLine();

        if (input.equals(YES)) {
            return true;
        }

        if (input.equals(NO)) {
            return false;
        }

        throw new IllegalArgumentException("재시작/종료를 구분하는 수는 1과 2 중 하나의 수");
    }
}
