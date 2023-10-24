package baseball;

public class GameManager {

    private Player player;
    private Computer computer;

    public GameManager() {
        this.player = new Player();
    }

    public void start() {
        MessagePrinter.printGameStartMessage();
        do {
            setGame();
            playGame();
            MessagePrinter.printRetryInputMessage();
        } while (player.getIsRetry());
    }

    private void playGame() {
        Boolean isGameEnd = false;
        while (!isGameEnd) {
            MessagePrinter.printNumberInputMessage();
            GameResult result = computer.calculateGameResult(player.getInputGameNumber());
            MessagePrinter.printResultMessage(result);
            isGameEnd = result.isAnswer();
        }
        MessagePrinter.printGameEndMessage();
    }

    private void setGame() {
        this.computer = new Computer();
    }
}
