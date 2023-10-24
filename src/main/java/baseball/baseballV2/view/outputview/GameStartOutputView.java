package baseball.baseballV2.view.outputview;

import java.util.Map;

public class GameStartOutputView implements OutputView {
    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    @Override
    public void print(Map<String, Object> model) {
        System.out.println(GAME_START_MESSAGE);
    }
}
