package baseball;

public class BaseBallGame {
    private static int strikes = 0;

    private static final int ANSWER_DIGIT = Constants.ANSWER_DIGIT;
    private static final String INPUT_PROMPT = Constants.INPUT_PROMPT;
    private static final String GAME_START = Constants.GAME_START;
    private static final String GAME_OVER = Constants.GAME_OVER;
    private static final String RESTART_PROMPT = Constants.RESTART_PROMPT;
    private static final String QUIT = Constants.QUIT;
    
    public void startGame() {
        System.out.println(GAME_START);
        runGame();
    }

    private void runGame() {
        Answer answer = new Answer();
        Computer computer = new Computer(answer);
        playRound(computer);

        GameStatus gameStatus = new GameStatus();

        if (gameStatus.getGameStatus().equals(QUIT)) {
            strikes = 0;
            return;
        }
        runGame();
    }

    private void playRound(Computer computer) {
        Guess guess = getGuessFromUser();
        computer.printResult(guess);
        strikes = computer.getStrikesCount(guess);
        if (strikes == ANSWER_DIGIT) {
            System.out.println(GAME_OVER);
            System.out.println(RESTART_PROMPT);
            return;
        }
        playRound(computer);
    }

    private Guess getGuessFromUser() {
        System.out.print(INPUT_PROMPT);

        Guess guess = new Guess();
        return guess;
    }
}
