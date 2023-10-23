package baseball;

import baseball.service.Game;

public class Application {

    private static final Game game = new Game();

    public static void main(String[] args) {
        int play = 1;
        game.outputGameStart();
        while (play == 1) {
            game.inputUserBalls();
            if (countResult()) {
                game.outputGameSuccess();
                game.outputRestartGame();
                play = game.inputRestartNumber();
            }
        }


    }

    private static boolean countResult() {
        int balls = game.countContainedBalls();
        if (game.isNothing(balls)) {
            return false;
        }
        int strike = game.countStrike();
        if (game.isThreeStrike(strike)) {
            return true;
        }
        balls -= strike;
        game.outputResult(balls, strike);
        return false;
    }
}
