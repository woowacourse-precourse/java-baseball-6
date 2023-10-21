package baseball;

import java.util.List;

/**
 * 사용자의 예측을 바탕으로 볼카운트를 저장하는 클래스
 */
public class BallCount {

    private final int strike;
    private final int ball;
    private final BallCountType ballCountType;

    private BallCount(int strike, int ball, BallCountType ballCountType) {
        this.strike = strike;
        this.ball = ball;
        this.ballCountType = ballCountType;
    }

    /**
     * 컴퓨터의 값과 사용자의 값을 바탕으로 볼카운트 객체 반환
     */
    public static BallCount create(List<Integer> computer, List<Integer> player){
        int s = 0;
        int b = 0;

        for (int p = 0; p < 3; p++) {
            if (computer.contains(player.get(p))) {
                if (computer.indexOf(player.get(p)) == p) {
                    s += 1;
                } else {
                    b += 1;
                }
            }
        }
        BallCountType ballCountType = gettBallCountType(b, s);

        return new BallCount(s, b, ballCountType);
    }

    /**
     * 볼, 스트라이크에 따른 상태 반환
     */
    private static BallCountType gettBallCountType(int ball, int strike){
        if(isStrikeOut(strike)){
            return BallCountType.STRIKEOUT;
        }else if(isNothing(ball, strike)){
            return BallCountType.NOTHING;
        }else if(hasBall(ball) && hasStrike(strike)){
            return BallCountType.BALL_AND_STRIKE;
        }else if(hasStrike(strike)){
            return BallCountType.ONLY_STRIKE;
        }else{
            return BallCountType.ONLY_BALL;
        }
    }

    private static boolean isStrikeOut(int strike){
        return strike == 3;
    }

    private static boolean isNothing(int ball, int strike){
        return strike + ball <= 0;
    }

    private static boolean hasStrike(int strike){
        return strike > 0;
    }

    private static boolean hasBall(int ball){
        return ball > 0;
    }

    public BallCountType getBallCountType() {
        return ballCountType;
    }

    public void printStrikeOut(){
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printNothing(){
        System.out.println("낫싱");
    }
    public void printBallAndStrike(){
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }

    public void printOnlyBall(){
        System.out.println(ball + "볼");
    }

    public void printOnlyStrike(){
        System.out.println(strike + "스트라이크");
    }
}
