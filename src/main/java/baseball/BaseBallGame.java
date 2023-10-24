package baseball;

public class BaseBallGame {

    private Computer computer;
    private Player player;

    public void play() {
        Boolean isGameEnd = false;
        while (!isGameEnd) {
            MessagePrinter.printNumberInputMessage();
            GameResult result = computer.calculateGameResult(player.getInputAnswer());
            MessagePrinter.printResultMessage(result);
            isGameEnd = result.isAnswer();
        }
        MessagePrinter.printGameEndMessage();
    }

    public void init() {
        this.computer = new Computer();
    }

    public BaseBallGame(Player player) {
        this.player = player;
    }
}
