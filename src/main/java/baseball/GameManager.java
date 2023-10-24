package baseball;

public class GameManager {

    private GameController controller;
    private Computer computer;

    public GameManager() {
        this.controller = new GameController();
    }

    public void start() {
        MessagePrinter.printGameStartMessage();
        do {
            setGame();
            playGame();
            MessagePrinter.printRetryInputMessage();
        } while (controller.getIsRetry());
    }

    private void playGame() {
        Boolean isGameEnd = false;
        while (!isGameEnd) {
            MessagePrinter.printNumberInputMessage();
            GameResult result = computer.calculateGameResult(controller.getInputGameNumber());
            MessagePrinter.printResultMessage(result);
            isGameEnd = result.isAnswer();
        }
        MessagePrinter.printGameEndMessage();
    }

    private void setGame() {
        this.computer = new Computer();
    }
}
