package baseball.view;

import baseball.model.Result;

public class OutputView {

    private OutputView() {
    }

    public static void printResult(Result result) {
        System.out.println(result);
    }
}
