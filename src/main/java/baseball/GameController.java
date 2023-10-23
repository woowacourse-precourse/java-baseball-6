package baseball;

public class GameController {
    private final Output output;

    public GameController() {
        this.output = new Output();
    }

    public void play() {
        output.gameStart();
    }
}
