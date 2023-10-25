package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private static final int BALL_NUM = 3;
    List<Integer> computer;

    private List<Ball> balls;
    public Balls(){
        balls = new ArrayList<>();
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
                balls.add(new Ball(randomNumber));
            }
        }
    }

    public Balls(String inputNumber) {
        if(!isValidInput(inputNumber)) throw new IllegalArgumentException();
        balls = new ArrayList<>();
        for(int i=0; i<BALL_NUM; i++){
            balls.add(new Ball(inputNumber.charAt(i) - '0'));
        }
    }

    private boolean isValidInput(String inputNumber) {
        if(inputNumber == "") return false;
        if(inputNumber.length() != BALL_NUM) return false;
        return true;
    }

    public int getStrike(Balls inputBalls) {
        int cnt = 0;
        for(int i=0; i<BALL_NUM; i++){
            if(inputBalls.isSame(balls.get(i), i)) cnt++;
        }
        return cnt;
    }

    private boolean isSame(Ball ball, int idx) {
        return balls.get(idx).equals(ball);
    }

    public int getBall(Balls inputBalls) {
        int cnt = 0;
        for(int i=0; i<BALL_NUM; i++){
            if(inputBalls.isSameNumAndDiffPosition(balls.get(i), i)) cnt++;
        }
        return cnt;
    }

    private boolean isSameNumAndDiffPosition(Ball ball, int idx) {
        for(int i=0; i<BALL_NUM; i++){
            if(i == idx) continue;
            if(ball.equals(this.balls.get(i))) return true;
        }
        return false;
    }
}
