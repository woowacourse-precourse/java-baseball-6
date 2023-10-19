package baseball.game.transform;

public interface Transformer<Input, Output> {

    Output transform(Input input);
}
