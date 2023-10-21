package baseball.view.output;

import baseball.dto.ComparisonResult;

public class OutputView {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_END_MESSAGE_FORMAT = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private final ComparisonResultView resultView = new ComparisonResultView();

    public void printStartGame() {
        println(GAME_START_MESSAGE);
    }

    public void printComparisonResult(ComparisonResult result) {
        println(resultView.changeToOutputMessage(result));

        if (result.isRight()) {
            println(String.format(GAME_END_MESSAGE_FORMAT, result.strike()));
        }
    }

    private void println(String message) {
        System.out.println(message);
    }
}
