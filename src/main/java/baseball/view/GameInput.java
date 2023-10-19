package baseball.view;

public class GameInput {
    private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String END_OR_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


    public void printInputNumber() {
        System.out.print(INPUT_NUMBER);
    }

    public void printEndOrRestart() {
        System.out.println(END_OR_RESTART);
    }
}
