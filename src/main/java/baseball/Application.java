//Application.java
package baseball;

public class Application {
    public static void main(String[] args) {
            GameView gameView = new GameView();
            GameController gameController = new GameController(gameView);
            gameController.run();
    }
}
