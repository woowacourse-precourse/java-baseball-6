package baseball;

public class Application {
    public static void main(String[] args) {
        BaseballGame game = new BaseballGame(new MissionUtilsGameRandom(), new ConsoleInput(), new ConsoleLogger());
        GameExecutor gameExecutor = new GameExecutor(game);
        gameExecutor.run();
    }
}
