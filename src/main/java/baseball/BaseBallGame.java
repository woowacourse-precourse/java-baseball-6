package baseball;

import static baseball.constants.Game.ANSWER_DIGIT;
import static baseball.constants.Game.QUIT;
import static baseball.constants.Message.GAME_OVER;
import static baseball.constants.Message.GAME_START;
import static baseball.constants.Message.INPUT_PROMPT;
import static baseball.constants.Message.RESTART_PROMPT;

public class BaseBallGame {
    private static int strikes = 0;


    public void startGame() {
        System.out.println(GAME_START);
        runGame();
    }

    private void runGame() {
        Computer computer = new Computer();
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
        computer.printResult(guess.getGuess());
        strikes = computer.getStrikesCount(guess.getGuess());
        if (strikes == ANSWER_DIGIT) {
            System.out.println(GAME_OVER);
            System.out.println(RESTART_PROMPT);
            return;
        }
        playRound(computer);
    }

    private Guess getGuessFromUser() {
        System.out.print(INPUT_PROMPT);

        return new Guess();
    }
}
