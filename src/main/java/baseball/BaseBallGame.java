package baseball;

public class BaseBallGame {

    private Computer computer;

    public void play() {
        System.out.print(GameMessage.NUMBER_INPUT);
    }

    public BaseBallGame() {
        computer = new Computer();
    }
}
