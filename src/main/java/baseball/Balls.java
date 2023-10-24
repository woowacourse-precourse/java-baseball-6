package baseball;

import java.util.ArrayList;
import java.util.List;


import camp.nextstep.edu.missionutils.Randoms;

import static baseball.Game.MAX_BALL_SIZE;

public class Balls {
    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        GlobalExcept.checkDuplication(balls);
        this.balls = balls;
    }

    public static Balls randomComputerBalls(){
        List<Ball> balls = new ArrayList<>();
        while(balls.size()<MAX_BALL_SIZE){
            Ball newBall = new Ball(Randoms.pickNumberInRange(1,9));
            if(!balls.contains(newBall)) {
                balls.add(newBall);
            }
        }
        return new Balls(balls);
    }

    public static Balls strToBalls(String str){
        List<Ball> balls = new ArrayList<>();
        char[] charList = str.toCharArray();

        for (char c : charList) {
            balls.add(new Ball(c));
        }
        return new Balls(balls);
    }


    public boolean isContain(Ball ball){
        return this.balls.contains(ball);
    }

    public Ball get(int index){
        return this.balls.get(index);
    }
}
