package baseball;

import java.util.List;

public class Output {

    private static final String START = "숫자 야구 게임을 시작합니다.";
    private static final String ASK_NUMBER = "숫자를 입력해주세요 : ";
    private static final String NOTHING = "낫싱%n";
    private static final String BALL = "%d볼%n";
    private static final String STRIKE = "%d스트라이크%n";
    private static final String BALL_AND_STRIKE = "%d볼 %d스트라이크%n";
    private static final String ASK_RESTART =
            "3개의 숫자를 모두 맞히셨습니다! 게임 종료%n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void start() {
        System.out.println(START);
    }

    public static void askNumber() {
        System.out.print(ASK_NUMBER);
        Input.askGuess();
    }

    public static void answer(List<Integer> result) {
        if (result.get(1) == 3) {
            System.out.println(ASK_RESTART);
            Input.askRestart();
            return;
        }
        if (result.get(0) == 0 && result.get(1) == 0) {
            System.out.println(NOTHING);
            return;
        }
        if (result.get(1) == 0) {
            System.out.println(STRIKE);
            return;
        }
        if (result.get(0) == 0) {
            System.out.println(BALL);
            return;
        }
        System.out.println(BALL_AND_STRIKE);
    }
}
