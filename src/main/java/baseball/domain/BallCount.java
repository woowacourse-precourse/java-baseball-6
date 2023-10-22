package baseball.domain;

import java.util.List;


public class BallCount {
    private static int strike;
    private static int ball;

    public static boolean isStrike(List<Integer> generatedAnswer, List<Integer> submittedAnswer) {
        if(generatedAnswer.equals(submittedAnswer)) {
            return true;
        }else {
            return false;
        }
    }
    public static void plusStrike() {
        strike++;
    }

    public static boolean isBall(List<Integer> generatedAnswer, List<Integer> submittedAnswer) {
        if(!isStrike(generatedAnswer, submittedAnswer) && generatedAnswer.contains(submittedAnswer)) {      // ball을 표현하려고 하다보니 이렇게 복잡하게 표현했는데 괜찮은지 확인 필요
            return true;
        }else {
            return false;
        }
    }
    public static void plusBall() {
        ball++;
    }

    public boolean isAllStrike(int strike) {
        if(strike==3) {
            return true;
        } else {
            return false;
        }
    }
    public boolean isNothing(int strike, int ball) {
        if(strike==0 && ball==0) {
            return true;
        } else {
            return false;
        }
    }
}
