package baseball;


import baseball.service.Game;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.initGame();
        game.runGame();
    }
}
