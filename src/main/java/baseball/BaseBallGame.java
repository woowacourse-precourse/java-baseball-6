package baseball;

public class BaseBallGame {

    private Computer computer;
    private Player player;

    public void play() {
        System.out.print(GameMessage.NUMBER_INPUT);
        GameResult result = computer.calculateGameResult(player.getInputAnswer());
        System.out.println(result.toString());
    }

    public BaseBallGame() {
        this.computer = new Computer();
        this.player = new Player();
    }
}
