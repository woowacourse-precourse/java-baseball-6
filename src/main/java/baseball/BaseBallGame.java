package baseball;

public class BaseBallGame {

    private Computer computer;
    private Player player;

    public void play() {
        System.out.print(GameMessage.NUMBER_INPUT);
        String inputAnswer = player.getInputAnswer();
    }

    public BaseBallGame() {
        this.computer = new Computer();
        this.player = new Player();
    }
}
