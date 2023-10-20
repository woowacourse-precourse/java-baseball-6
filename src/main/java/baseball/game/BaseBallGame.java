package baseball.game;


public class BaseBallGame implements Game {

    private final Computer computer;
    public BaseBallGame() {
        this.computer = new Computer();
    }

    @Override
    public void play() {

        computer.createRandomNumber();


    }
}
