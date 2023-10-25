package baseball.controller;

import baseball.model.Ball;

import java.util.List;

public class CountController {
    //Ball 세개의 상태를 검사-> 볼, 스트라이크 개수 세기
    private int strike;
    private int ball;

    public CountController(){
        this.strike=0;
        this.ball=0;
    }
    public void count_ball(List<Ball> computer, List<Ball> user){
        for(int i=0; i<computer.size(); i++){
            Ball comBall = computer.get(i);
            Ball userBall = user.get(i);
            if(comBall.getNumber()==userBall.getNumber()) {
                this.strike++;
                continue;
            }
            boolean ballCheck = user.stream().anyMatch(u -> u.getNumber() == comBall.getNumber());
            if(ballCheck) this.ball++;
        }
    }

    public int getBall() {
        return ball;
    }
    public int getStrike() {
        return strike;
    }
}
