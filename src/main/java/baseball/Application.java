package baseball;

public class Application {
    public static void main(String[] args) {
        UserNumberManager userNumberManager = new UserInputNumberManager();
        NumberManager numberManager = new RandomRuleManager(userNumberManager);

        BaseballGame game = new BaseballGame(numberManager);
        game.run();
    }
}
