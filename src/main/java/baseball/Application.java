package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballGameView baseballGameView = new BaseballGameView(new ConsoleReader(), new PrintWriter());
        BaseballGameController baseballGameController = new BaseballGameController(
            baseballGameView,
            new GameTerminationValidator(),
            new BaseballGame(baseballGameView, new BaseballNumberValidator()),
            new BaseballRandomGenerator()
        );

        baseballGameController.playGame();
    }
}
