package baseball.view;

public class OutView {

    private static final String ballStr = "볼";
    private static final String strikeStr = "스트라이크";

    public static void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void gameResult(int ball, int strike) {
        if(strike > 0 && ball > 0) {
            System.out.println(ball + ballStr + " " + strike + strikeStr);
        } else if (strike == 0 && ball > 0) {
            System.out.println(ball + ballStr);
        } else if (ball == 0 && strike > 0) {
            System.out.println(strike + strikeStr);
        } else {
            System.out.println("낫싱");
        }
    }

    public static void end() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
