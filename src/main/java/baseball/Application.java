package baseball;

public class Application {
    public static void main(String[] args) {
        GameRandom random = new MissionUtilsGameRandom();
        GameExecutor gameExecutor = new GameExecutor(new BaseballGame(random.sampleDistinctNumbers(1, 9, 3)),
                new ConsoleInput(), new ConsoleLogger(), random
        );
        gameExecutor.run();
    }
}
