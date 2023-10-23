package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameUtils gameUtils = new GameUtils();
        BaseballGame baseballGame = new BaseballGame(gameUtils);
        baseballGame.run();
    }
}
