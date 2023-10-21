package baseball.view;

import baseball.domain.Result;

public class OutputView {
    public void startMention() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printResult(Result result) {
        System.out.println(result.getResultStringFormat());
    }

    public void gameOverMention() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
