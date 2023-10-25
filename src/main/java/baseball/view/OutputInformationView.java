package baseball.view;

public class OutputInformationView {

    private static final String start = "숫자 야구 게임을 시작합니다.";
    private static final String checkAnswer = "3개의 숫자를 모두 맞추셨습니다. ";
    private static final String gameOver = "게임 종료.";
    private static final String gameEnd = "게임 실행을 종료합니다.";

    // "숫자 야구 게임을 시작합니다." 문장을 출력하는 메서드.
    public void startGuide() {
        System.out.println(start);
    }
}