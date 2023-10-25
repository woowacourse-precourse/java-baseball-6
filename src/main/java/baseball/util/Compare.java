package baseball.util;

public class Compare {

    private static int strike = 0;
    private static int ball = 0;

    //스트라이크, 볼 초기화
    public static void dataInit() {
        strike = 0;
        ball = 0;
    }

    //strike 반환
    public static int getStrike() {
        return strike;
    }

    //ball 반환
    public static int getBall() {
        return ball;
    }
}
