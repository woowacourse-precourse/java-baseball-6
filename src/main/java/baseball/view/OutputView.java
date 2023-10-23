package baseball.view;

public class OutputView {

    public static void printBallStrike(int ball, int strike) {
        if(strike == 0 && ball > 0) System.out.println(ball + "볼");
        if(strike > 0 && ball == 0) System.out.println(strike + "스트라이크");
        if(strike >0 && ball >0) System.out.println(ball + "볼" + strike + "스트라이크");
        if(strike == 0 && ball == 0) System.out.println("낫싱");
    }
}
