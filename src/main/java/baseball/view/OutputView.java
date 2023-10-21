package baseball.view;

import baseball.domain.dto.GuessResult;

public final class OutputView {

    public void printResult(final GuessResult result) {
        System.out.println(result.renderToString());
        System.out.println("게임 종료");
    }
}
