package baseball;


public class Referee {
    public static int[] judge(Ball userBall, Ball comBall){
        int[] judgement = new int[2];
        judgement[0] = comBall.countStrike(userBall);
        judgement[1] = comBall.countBall(userBall);
        return judgement;
    }
}
