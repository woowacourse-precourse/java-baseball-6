package baseball.view;

public class OutputMessage {
    public static void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printResultMessage(int strike, int ball) {
        System.out.println(ball + "볼 " + strike + " ");
    }

    public static void printWinMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}
