package baseball;

public class GameRunner {
    private final GamingConsole nowRunningGame;
    private final GamePrinter nowRunningGamePrinter;

    GameRunner(GamingConsole nowRunningGame, GamePrinter nowRunningGamePrinter) {
        this.nowRunningGame = nowRunningGame;
        this.nowRunningGamePrinter = nowRunningGamePrinter;
    }

    public void run() {
        nowRunningGamePrinter.printStartingMessage();
        nowRunningGame.createNewGame();
        nowRunningGamePrinter.printEndingMessage();
    }
}
