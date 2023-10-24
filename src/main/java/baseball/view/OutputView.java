package baseball.view;

import baseball.model.Result;

public class OutputView {
    public void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printGameResult(Result result) {
        System.out.println(result.getFormattedResult());
    }
}