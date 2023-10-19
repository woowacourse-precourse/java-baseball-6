package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;
public class Balls {
    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        checkDuplication(balls);
        this.balls = balls;
    }

    public Balls randomComputerBalls(){
        List<Ball> balls = new ArrayList<>();
        while(balls.size()<3){
            Ball newBall = new Ball(Randoms.pickNumberInRange(1,9));
            if(!balls.contains(newBall)) {
                balls.add(newBall);
            }
        }
        return new Balls(balls);
    }

    public Balls strToBalls(String str){
        List<Ball> balls = new ArrayList<>();
        char[] charList = str.toCharArray();

        for (char c : charList) {
            balls.add(new Ball(c));
        }
        return new Balls(balls);
    }

    public void checkDuplication(List<Ball> balls){
        Set<Ball> ballSet = new HashSet<>(balls);
        if (ballSet.size() != balls.size()) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }

    public boolean isEqual(Balls balls){
        return this.balls.equals(balls.balls);
    }

    public boolean isContain(Ball ball){
        return this.balls.contains(ball);
    }
}
