package baseball.view.impl.game;

import baseball.view.OutputView;

public class GameOutputView implements OutputView<String> {
    @Override
    public void show(String result) {
        System.out.println(result);
    }

    public void showAfterSuccess() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
