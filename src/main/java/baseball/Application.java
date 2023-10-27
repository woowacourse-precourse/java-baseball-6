package baseball;


import baseball.util.OutputUtil;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        OutputUtil.printStartGame();
        game.startGame();

    }
}
