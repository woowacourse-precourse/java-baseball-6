package baseball.view;

import static baseball.constant.Constant.BASEBALL_GAME_NUMBER_DIGIT;

public class OutputView {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GUESS_NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String WINNING_MESSAGE = BASEBALL_GAME_NUMBER_DIGIT + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_OR_FINISH_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printGuessNumberInputMessage() {
        System.out.print(GUESS_NUMBER_INPUT_MESSAGE);
    }

    public void printGuessNumberResult(final String result) {
        System.out.println(result);
    }

    public void printWinningMessage() {
        System.out.println(WINNING_MESSAGE);
    }

    public void printRestartOrFinishMessage() {
        System.out.println(RESTART_OR_FINISH_MESSAGE);
    }

    public void printExceptionMessage(final String message) {
        System.out.println(message);
    }
}
