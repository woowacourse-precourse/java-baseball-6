package baseball.game;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    private final GamePlayer gamePlayer = new GamePlayer();

    public void run() {
        boolean restart = true;
        GamePhrases.startPhrase();
        do {
            BaseBallGameRunner();
            switch (gamePlayer.userRestartInput()) {
                case "1":
                    continue;
                case "2":
                    Console.close();
                    restart = false;
            }
        } while (restart);
    }

    private void BaseBallGameRunner() {
        GameController gameController = new GameController();
        boolean isCorrect;

        do {
            GamePhrases.inputPhrase();
            gameController.isStrikeOrBall(gamePlayer.userAnswerInput());
            isCorrect = gameController.printResultPhrase();
        } while (isCorrect);
    }
}
