package baseball.view.impl.gameEnd;

import baseball.view.OutputView;

public class GameEndOutputView implements OutputView<Object> {
    @Override
    public void show(Object data) {
        System.out.println("게임 종료");
    }
}
