package baseball.view;

import java.util.List;

public class OutputView {

    //    볼, 스트라이크 수 출력
    public static void printBallStrike(List<Integer> listBallStrike) {
        int ball = listBallStrike.get(0);
        int strike = listBallStrike.get(1);

        if(ball > 0 && strike == 0) System.out.println(ball + "볼");
        if(ball == 0 && strike > 0) System.out.println(strike + "스트라이크");
        if(ball >0 && strike >0) System.out.println(ball + "볼 " + strike + "스트라이크");
        if(ball == 0 && strike == 0) System.out.println("낫싱");
    }
}
