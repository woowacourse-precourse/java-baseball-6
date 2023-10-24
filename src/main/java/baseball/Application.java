package baseball;

import baseball.game.Game;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        try {
            playBaseball(game);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void playBaseball(Game game) {
        while (game.checkRestart()) {
            game.startGame();
        }
    }
}
