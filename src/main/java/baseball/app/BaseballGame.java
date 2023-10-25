package baseball.app;

import static baseball.constants.Game.ANSWER_DIGIT;
import static baseball.constants.GameMessage.GAME_OVER;
import static baseball.constants.GameMessage.GAME_START;
import static baseball.constants.GameMessage.INPUT_PROMPT;
import static baseball.constants.GameMessage.RESTART_PROMPT;

import baseball.core.Computer;
import baseball.core.GameStatus;
import baseball.core.Guess;

public class BaseballGame {
    private static int strikes = 0;


    public void startGame() {
        System.out.println(GAME_START);
        runGame();
    }

    private void runGame() {
        while (true) {
            Computer computer = new Computer();
            playRound(computer);

            GameStatus gameStatus = new GameStatus();

            if (gameStatus.isQuit()) {
                strikes = 0;
                break;
            }
        }
    }

    private void playRound(Computer computer) {
        while (strikes < ANSWER_DIGIT) {
            Guess guess = getGuessFromUser();
            computer.printResult(guess.getGuess());
            strikes = computer.getStrikesCount(guess.getGuess());
        }
        System.out.println(GAME_OVER);
        strikes = 0;
        System.out.println(RESTART_PROMPT);
    }

    private Guess getGuessFromUser() {
        System.out.print(INPUT_PROMPT);

        return new Guess();
    }
}
