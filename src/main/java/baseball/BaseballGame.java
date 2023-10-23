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

            if (result[STRIKE] == NUMBER_LENGTH) {
                consolePrinter.successPrint();
                consolePrinter.restartPrint();
                
                if (!restartGame()) {
                    break;
                }
            }
        }
    }

    public Boolean restartGame() {
        String answer = Console.readLine();
        if (answer.equals(INPUT_RESTART)) {
            computerService.randomNumberGenerate();
            return true;
        }
        if (answer.equals(INPUT_QUIT)) {
            return false;
        }
        if (!answer.equals(INPUT_RESTART) && !answer.equals(INPUT_QUIT)) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}
