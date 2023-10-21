package baseball;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame(3);
        do {
            baseballGame.start();
        } while (baseballGame.isRestart());
        baseballGame.end();
    }
}
