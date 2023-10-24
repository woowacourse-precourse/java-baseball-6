package baseball.service;

import baseball.model.ComputerBall;

public class BaseballService {

    private ComputerBall computerBall;

    /**
     * 초기 게임 세팅
     */
    public void init(){
        this.computerBall = new ComputerBall();
    }
}
