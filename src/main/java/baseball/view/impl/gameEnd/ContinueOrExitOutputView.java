package baseball.view.impl.gameEnd;

import baseball.view.OutputView;

public class ContinueOrExitOutputView implements OutputView<Object> {
    @Override
    public void show(Object value) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
