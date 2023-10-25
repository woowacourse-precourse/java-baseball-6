package baseball;

public class GameStatus {

    private Status status;
    private Baseballs computerNumbers;

    public GameStatus(final Status status, final Baseballs computerNumbers) {
        this.status = status;
        this.computerNumbers = computerNumbers;
    }

    public void init() {
        this.status = Status.PLAY;
        this.computerNumbers = Computer.createComputerNumbers(new BaseballNumberCreator());
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
