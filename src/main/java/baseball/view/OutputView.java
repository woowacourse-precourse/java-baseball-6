package baseball.view;

public class OutputView {
    public void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printHint(String hintMessage) {
        System.out.println(hintMessage);
    }

    public void printEnd() {
        System.out.println("개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
