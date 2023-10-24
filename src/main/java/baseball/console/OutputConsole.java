package baseball.console;

public class OutputConsole {

    private String startingMsg = "숫자 야구 게임을 시작합니다.";
    private String inputMsg = "숫자를 입력해주세요.";
    private String strikeMsg = "스트라이크";
    private String ballMsg = "볼";
    private String nothingMsg = "낫싱";
    private String allClear = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private String isReplay = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void printStartingMsg() {
        System.out.println(startingMsg);
    }
    public void printInputMsg() {
        System.out.println(inputMsg);
    }

    public void printAllClearMsg() {
        System.out.println(allClear);
    }

    public void printReplayMsg() {
        System.out.println(isReplay);
    }

    public void printResultMsg(int ball, int strike) {
        String message = "";
        if (strike == 0 && ball == 0) {
            message += nothingMsg;
        }
        if (ball > 0) {
            message += ball + ballMsg;
        }
        if (strike > 0) {
            message += strike + strikeMsg;
        }
        System.out.println(message);
    }
}
