package baseball.domain;

public class Opponent {

    private final NumberBaseBall numberBaseBall;
    private final RandomNumberPicker randomNumberPicker;
    private final InputOutputHandler inputOutputHandler;
    private final Me me;

    public Opponent(
            NumberBaseBall numberBaseBall,
            RandomNumberPicker randomNumberPicker,
            InputOutputHandler inputOutputHandler,
            Me me) {
        this.numberBaseBall = numberBaseBall;
        this.randomNumberPicker = randomNumberPicker;
        this.inputOutputHandler = inputOutputHandler;
        this.me = me;
    }

    public void startGame(int numberLength) {
    }
}
