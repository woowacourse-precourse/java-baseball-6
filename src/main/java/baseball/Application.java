package baseball;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        Game model = new Game();
        GameView gameView = new GameView();
        Controller controller = new Controller(model, gameView);

        // 게임 시작
        controller.playGame();
    }
}
