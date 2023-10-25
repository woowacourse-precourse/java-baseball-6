package baseball.view.input;

import io.Renderable;

public final class BallNumbersView implements Renderable {
    public static final String INPUT_BALL_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    private final boolean isGameStart;

    public BallNumbersView(final boolean isGameStart) {
        this.isGameStart = isGameStart;
    }

    @Override
    public String render() {
        if (isGameStart) {
            return new GameStartView().render() + INPUT_BALL_NUMBER_MESSAGE;
        }
        return INPUT_BALL_NUMBER_MESSAGE;
    }
}
