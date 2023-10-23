package baseball;

public class GameStatus {

    private Status status;
    private Baseballs computerNumbers;

    public GameStatus() {
        init();
    }

    public void init() {
        this.status = Status.PLAY;
        this.computerNumbers = new Computer(new BaseballNumberCreator()).createComputerNumbers();
    }

    public boolean isPlaying() {
        return status.equals(Status.PLAY);
    }

    public void end() {
        this.status = Status.END;
    }

    public Baseballs getComputerNumbers() {
        return computerNumbers;
    }
}
