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
    public void count_ball(List<Ball> computer, List<Ball> user) {
        if(!validate_ballList(computer, user)){
            throw new IllegalArgumentException("balls의 길이가 맞지 않습니다.");
        }
        for(int i=0; i<computer.size(); i++){
            Ball comBall = computer.get(i);
            Ball userBall = user.get(i);
            if(comBall.equals(userBall)) {
                this.strike++;
                continue;
            }
            boolean ballCheck = user.stream().anyMatch(u -> u.getNumber() == comBall.getNumber());
            if(ballCheck) this.ball++;
        }
    }

    private boolean validate_ballList(List<Ball> computer, List<Ball> user) {
        return computer.size()==user.size() && computer.size()==3;
    }

    public int getBall() {
        return ball;
    }
    public int getStrike() {
        return strike;
    }
}
