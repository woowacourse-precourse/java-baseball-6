package baseball.view.input;

import io.Renderable;

public final class GameStartView implements Renderable {
    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.\n";

    @Override
    public String render() {
        return GAME_START_MESSAGE;
    }
}
