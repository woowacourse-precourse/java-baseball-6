package baseball.view;

public class OutputView {

    private static final String welcomeMessage = "숫자 야구 게임을 시작합니다.";
    private static final String inputMessage = "숫자를 입력해주세요 : ";
    private static final String endMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String resumeMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String ballMessage = "볼 ";
    private static final String strikeMessage = "스트라이크";
    private static final String nothingMessage = "낫싱";


    private void println(String message) {
        System.out.println(message);
    }

    private void print(String message) {
        System.out.print(message);
    }

    public void printInputMessage() {
        print(inputMessage);
    }

    public void printGameStart() {
        println(welcomeMessage);
    }

    public void printFinishMessage() {
        println(endMessage);
    }

    public void printResumeMessage() {
        println(resumeMessage);
    }

    public void printResultMessage(int ball, int strike) {
        String message = "";
        if (strike == 0 && ball == 0) {
            message += nothingMessage;
        }
        if (ball > 0) {
            message += ball + ballMessage;
        }
        if (strike > 0) {
            message += strike + strikeMessage;
        }
        println(message);
    }

}
