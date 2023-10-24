package baseball.view;

public class View {
    public void showStartLine() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void showInputLine() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void showResultByCorrectAnswer() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void showResultByPartialMismatchAnswer(int ball, int strike) {
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }

    public void showResultByAllMismatchAnswer() {
        System.out.println("낫싱");
    }

    public void showEndLine() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
