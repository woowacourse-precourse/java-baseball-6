package baseball.view;

public class OutputView {
    private static final String START_INFO = "숫자 야구 게임을 시작합니다.";
    private static final String OUTPUT_ANSWER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void startInfo() {
        System.out.println(START_INFO);
    }

    public void answerMsg() {
        System.out.println(OUTPUT_ANSWER);
    }

    public void hintMsg(String Msg) {
        System.out.println(Msg);
    }

}

