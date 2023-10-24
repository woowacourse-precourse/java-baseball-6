package baseball.view;

public class OutputView {
    private final String GAME_START_GUIDE = "숫자 야구 게임을 시작합니다.";
    private final String CORRECT_ANSWER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String RESTART_OR_EXIT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private final String NUMBER_REQUEST_MESSAGE = "숫자를 입력해주세요 : ";

    public void gameStart() {
        System.out.println(GAME_START_GUIDE);
    }

    public void requestInputNumber() {
        System.out.println(NUMBER_REQUEST_MESSAGE);
    }

    public void notifyCorrectAnswer() {
        System.out.println(CORRECT_ANSWER_MESSAGE);
    }

    public void askRestartOrExit() {
        System.out.println(RESTART_OR_EXIT_MESSAGE);
    }

    public void printHint(String hint) {
        System.out.println(hint);
    }
}
