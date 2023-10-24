package baseball;

enum ScoreType {
    STRIKE, BALL
}


public class Application {
    public static void main(String[] args) {
        GameInterface game = new BaseballGame();

        do {
            game.initialize();
            game.start();
        } while (!game.isEndGame());
    }
}