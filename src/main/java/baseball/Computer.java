package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    private final int[] computer = new int[3];


    // 임의의 값으로 컴퓨터 초기 값을 세팅한다.
    public void computerSetting() {
        for (int i = 0; i < computer.length; i++) {
            computer[i] = Randoms.pickNumberInRange(1, 9);
        }
    }

    public int[] getComputer() {
        return computer;
    }
}
