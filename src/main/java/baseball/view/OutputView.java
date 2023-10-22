package baseball.view;

public class OutputView {

    private static final String START = "야구 게임을 시작합니다.";
    private static final String END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";

    public void printStart() {
        System.out.println(START);
    }

    public void printInputNumber() {
        System.out.print(INPUT_NUMBER);
    }

    public void printResult(final String result) {
        System.out.println(result);
    }

    public void printEnd() {
        System.out.println(END);
    }

    public void printRestart() {
        System.out.println(RESTART);
    }
}
