package baseball.view;

public class OutputView {


    public void printBaseballGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printInputNumberMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printCountMessage(String countMessage) {
        System.out.println(countMessage);
    }

    public void printGameResultMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printRetryOrEndMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printRetryOrEndMessageProcess() {
        printGameResultMessage();
        printRetryOrEndMessage();
    }
}
