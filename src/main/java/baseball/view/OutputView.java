package baseball.view;

public class OutputView {
    public static void gameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void userInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printBallStrike(Integer ball, Integer strike) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }

        if (ball > 0 && strike == 0) {
            System.out.println(ball + "볼");
        }

        if (strike > 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        }

        if (strike > 0 && ball > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }
}
