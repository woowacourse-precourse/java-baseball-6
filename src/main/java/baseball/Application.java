package baseball;

import baseball.Game.State;
import baseball.Hint.Hints;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        int roundResult;
        boolean running = true;

        game.startGame();

        while (running) {
            String guessNumsStr = game.getGuessNums();
            game.isValidGuessNums(guessNumsStr);
            roundResult = game.getHint();

            if (roundResult == Hints.ALL_STRIKE.ordinal()) {
                int state = game.isRestart();
                if (state == State.RESTART.ordinal()) {
                    game.startGame();
                } else if (state == State.END.ordinal()) {
                    running = false;
                    game.endGame();
                } else {
                    break;
                }
            }
        }
    }
}
