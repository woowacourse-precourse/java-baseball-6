package baseball.view;

public class Output {

    public static void hintMessage() {
        System.out.println("낫싱");
    }
    public static void hintMessage(int ball, int strike) {
        if (strike == 0) {
            if (ball > 0) System.out.println(ball + "볼");
        }
        else {
            if (ball == 0) System.out.println(strike + "스트라이크");
            else System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }
    public static void lastMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void startMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}
