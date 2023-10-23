package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame extends Validation {
    private static final int ANSWER_DIGIT = Constants.ANSWER_DIGIT;
    private static final String INPUT_PROMPT = Constants.INPUT_PROMPT;
    private static final String GAME_START = Constants.GAME_START;
    private static final String GAME_OVER = Constants.GAME_OVER;
    private static final String RESTART_PROMPT = Constants.RESTART_PROMPT;
    private static final String QUIT = Constants.QUIT;
    private static int strikes = 0;

    public void startGame() {
        System.out.println(GAME_START);
        runGame();
    }

    private void runGame() {
        Computer computer = new Computer();
        playRound(computer);

        String gameStatusInput = Console.readLine();
        this.validateGameStatusInput(gameStatusInput);

        if (gameStatusInput.equals(QUIT)) {
            strikes = 0;
            return;
        }
        runGame();
    }

    private void playRound(Computer computer) {
        String guess = getGuessFromUser();
        computer.printResult(guess);
        strikes = computer.getStrikesCount(guess);
        if (strikes == ANSWER_DIGIT) {
            System.out.println(GAME_OVER);
            System.out.println(RESTART_PROMPT);
            return;
        }
        playRound(computer);
    }

    private String getGuessFromUser() {
        System.out.print(INPUT_PROMPT);
        String input = Console.readLine();
        this.validateNumberInput(input);

        return input;
    }
}
