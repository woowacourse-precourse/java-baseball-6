package baseball.service;

import baseball.model.ComputerBall;

import java.util.List;

public class BaseballService {

    private ComputerBall computerBall;

    /**
     * 초기 게임 세팅
     */
    public void setNewGame(){
        this.computerBall = new ComputerBall();
    }

    public boolean checkVictory(List<Integer> user){
        return computerBall.countStrike(user) == 3;
    }

    public String getHint(List<Integer> user) {

        StringBuilder message = new StringBuilder();
        int strike = computerBall.countStrike(user);
        int ball = computerBall.countBall(user);

        if (strike == 0 && ball == 0) {
            message.append("낫싱");
        }
        if (strike != 0) {
            message.append(strike).append("스트라이크 ");
        }
        if (ball != 0) {
            message.append(ball).append("볼 ");
        }
        return message.toString();
    }

}
