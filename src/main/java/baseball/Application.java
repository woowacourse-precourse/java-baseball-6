package baseball;

import baseball.domain.GameResult;
import baseball.domain.InputValidator;
import baseball.view.View;

public class Application {
    public static void main(String[] args) {
        GameManager gameManager =
                new GameManager(new View(), new GameService(new InputValidator(), new GameResult()));

        gameManager.startGame();

        while (true) {
            gameManager.play();

            if (gameManager.isWin()) {
                if (gameManager.isEnd()) break;
            }
        }
    }
}
