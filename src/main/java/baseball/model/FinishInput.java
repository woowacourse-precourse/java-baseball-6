package baseball.model;

public enum FinishInput {
    RESTART_GAME(1),
    END_GAME(2);

    public final int input;

    FinishInput(int value) {
        this.input = value;
    }


}
