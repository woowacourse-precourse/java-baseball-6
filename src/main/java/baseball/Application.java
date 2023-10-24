package baseball;

public class Application {
    public static void main(String[] args) {
        NumberManager numberManager = new ComputerFunction();
        BaseballGame game = new BaseballGame(numberManager);

        game.run();
    }
}
