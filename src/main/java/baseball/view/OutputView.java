package baseball.view;

import baseball.domain.Hint;

public class OutputView {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_FINISHED_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String CONTINUE_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    public void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printHint(final Hint hint) {
        System.out.println(hint.formatResult());
    }

    public void printGameFinishedMessage() {
        System.out.println(GAME_FINISHED_MESSAGE);
    }

    public void printAskContinueMessage() {
        System.out.print(CONTINUE_GAME_MESSAGE);
    }

    public void printInputNumberMessage() {
        System.out.print(INPUT_NUMBER_MESSAGE);
    }
}
