package baseball.view.input;

import io.Renderable;

public final class BallNumbersView implements Renderable {
    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_BALL_NUMBER_MESSAGE = "\n숫자를 입력해주세요 : ";

    private final boolean isGameStart;

    public BallNumbersView(final boolean isGameStart) {
        this.isGameStart = isGameStart;
    }

    @Override
    public String renderToString() {
        if (isGameStart) {
            return GAME_START_MESSAGE + INPUT_BALL_NUMBER_MESSAGE;
        }
        return INPUT_BALL_NUMBER_MESSAGE;
    }
}
