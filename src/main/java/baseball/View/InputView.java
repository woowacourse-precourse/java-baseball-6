package baseball.View;

public class InputView {

    String inputMessage = "숫자를 입력해주세요 : ";
    String retryMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void printInputMessage() {
        System.out.print(inputMessage);
    }

    public void printRetryMessage() {
        System.out.println(retryMessage);
    }

}
