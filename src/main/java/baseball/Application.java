package baseball;

public class Application {
    public static void main(String[] args) {
        NumberManager numberManager = new RandomRuleManager();
        BaseballGame game = new BaseballGame(numberManager);
        game.run();
    }
}
