package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new BaseballGame(
            new ConsoleReader(),
            new PrintWriter(),
            new BaseballNumberValidator(),
            new GameTerminationValidator(),
            new BaseballGameProcessorImpl(),
            new BaseballRandomGenerator()
        );

        game.play();
    }
}
