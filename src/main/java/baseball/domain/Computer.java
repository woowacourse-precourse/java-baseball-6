package baseball.domain;

import java.util.List;

/**
 * 1. computer : 'camp.nextstep.edu.missionutils.Randoms'을 이용한 랜덤 값
 * <p>
 * - 랜덤 값을 저장할 변수
 */
public class Computer {
    private final List<Integer> computerValue;

    public Computer(List<Integer> computerValue) {
        this.computerValue = computerValue;
    }

    public static Computer createComputer(List<Integer> computerValue) {
        return new Computer(computerValue);
    }

    public List<Integer> getComputerValue() {
        return computerValue;
    }
}
