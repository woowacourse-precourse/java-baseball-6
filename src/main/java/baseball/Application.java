package baseball;

import baseball.service.Game;

public class Application {

    private static final Game game = new Game();

    public static void main(String[] args) {
        boolean play = true;
        boolean restart = false;
        game.outputGameStart();
        game.createComputerBalls();
        while (play) {
            game.inputUserBalls();
            if (countResult()) {
                game.outputGameSuccess();
                game.outputRestartGame();
                play = game.inputRestartNumber();
                if (play) {
                    game.createComputerBalls();
                }
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
