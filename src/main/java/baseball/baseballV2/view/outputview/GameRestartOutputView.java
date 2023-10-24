package baseball.baseballV2.view.outputview;

import java.util.Map;

public class GameRestartOutputView implements OutputView {
    public static final String GAME_END_MESSAGE =
            "3개의 숫자 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";


    @Override
    public void print(Map<String, Object> model) {
        System.out.print(GAME_END_MESSAGE);
    }
}
