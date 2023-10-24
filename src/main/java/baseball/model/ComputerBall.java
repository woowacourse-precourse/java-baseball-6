package baseball.model;

import baseball.util.RandomNumberGenerator;

import java.util.List;

public class ComputerBall {

    List<Integer> computer;

    /**
     * 랜덤한 세자리 숫자 생성
     */
    public ComputerBall() {
        this.computer = RandomNumberGenerator.generateRandomNumber();
    }
}
