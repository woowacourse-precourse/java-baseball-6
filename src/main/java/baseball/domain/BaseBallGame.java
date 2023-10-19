package baseball.domain;

public class BaseBallGame {
    private final Computer computer;

    public BaseBallGame() {
        computer = new Computer();
    }

    public void play() {
        computer.makeAnswerNumber();
    }
}
