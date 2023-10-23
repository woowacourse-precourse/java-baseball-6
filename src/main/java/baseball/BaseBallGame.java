package baseball;
import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {
    private static final int ANSWER_DIGIT = Constants.ANSWER_DIGIT;
    private static final String INPUT_PROMPT = Constants.INPUT_PROMPT;
    private static final String GAME_START = Constants.GAME_START;
    private static final String GAME_OVER = Constants.GAME_OVER;
    private static final String RESTART_PROMPT = Constants.RESTART_PROMPT;
    private static final String RESTART = Constants.RESTART;
    private static final String QUIT = Constants.QUIT;

    public void startGame() {
        int strikes = 0;
        String gameStatus = RESTART;

        System.out.println(GAME_START);
        while (gameStatus.equals(RESTART)) {
            Computer computer = new Computer();
            computer.setAnswer();

            while (strikes < ANSWER_DIGIT) {
                System.out.print(INPUT_PROMPT);
                Player player = new Player();
                player.setInput();

                strikes = computer.printResult(Player.input);
            }

            System.out.println(GAME_OVER);
            System.out.println(RESTART_PROMPT);
            String input = Console.readLine();

            if(!input.equals(RESTART) && !input.equals(QUIT)) {
                throw new IllegalArgumentException();
            }
            gameStatus = input;
            strikes = 0;
        }
    }
}
