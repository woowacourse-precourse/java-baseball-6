package baseball.service;

import baseball.model.ComputerBall;

import java.util.List;

public class BaseballService {

    private ComputerBall computerBall;
    private final String NOTHING_KO = "낫싱";
    private final String BALL_KO = "볼 ";
    private final String STRIKE_KO = "스트라이크 ";


    /**
     * 초기 게임 세팅
     */
    public void setNewGame(){
        this.computerBall = new ComputerBall();
    }

    /**
     * 승리 조건 확인
     */
    public boolean checkVictory(List<Integer> user){
        return computerBall.countStrike(user) == 3;
    }

    /**
     * 힌트 생성
     */
    public String getHint(List<Integer> user) {

        StringBuilder message = new StringBuilder();
        int strike = computerBall.countStrike(user);
        int ball = computerBall.countBall(user);

        if (strike == 0 && ball == 0) {
            message.append(NOTHING_KO);
        }
        if (ball != 0) {
            message.append(ball).append(BALL_KO);
        }
        if (strike != 0) {
            message.append(strike).append(STRIKE_KO);
        }
        return message.toString();
    }

}
