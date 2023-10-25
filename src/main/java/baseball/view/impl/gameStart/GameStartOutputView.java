package baseball.view.impl.gameStart;

import baseball.view.OutputView;

public class GameStartOutputView implements OutputView<Object> {
    @Override
    public void show(Object value) {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}