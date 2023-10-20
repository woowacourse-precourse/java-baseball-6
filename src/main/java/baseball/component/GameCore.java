package baseball.component;

public class GameCore {
    private Initializer initializer;
    private Inputter inputter;
    private Validator validator;

    public GameCore(
            Initializer initializer,
            Inputter inputter,
            Validator validator
            ) {
        this.initializer = initializer;
        this.inputter = inputter;
        this.validator = validator;
    }

    private void initGame() {
        validator.setTarget(initializer.initGame());
    }

}
