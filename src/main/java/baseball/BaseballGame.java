package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private static final int NUMBER_LENGTH = 3;
    private static final int STRIKE = 1;
    private static final String INPUT_RESTART = "1";
    private static final String INPUT_QUIT = "2";

    private final ConsolePrinter consolePrinter = new ConsolePrinter();
    private final Computer computerService = new Computer();
    private final Player playerService = new Player();

    public void gameStart() {
        int[] result;
        consolePrinter.startPrint();

        while (true) {
            consolePrinter.pleaseEnterNumber();
            playerService.inputPlayerNumber();

            result = playerService.checkStrikeAndBall(computerService.getRandomNumber());
            consolePrinter.printResult(result);

            if (!isGameComplete(result)) {
                break;
            }
        }
    }

    private boolean isGameComplete(int[] result) {
        if (result[STRIKE] == NUMBER_LENGTH) {
            consolePrinter.successPrint();
            consolePrinter.restartPrint();
            return askForRestart();
        }
        return true;
    }

    public Boolean askForRestart() {
        String answer = Console.readLine();
        if (answer.equals(INPUT_RESTART)) {
            computerService.randomNumberGenerate();
            return true;
        }
        if (answer.equals(INPUT_QUIT)) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}
