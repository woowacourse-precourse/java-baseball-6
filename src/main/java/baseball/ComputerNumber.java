package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {

    public List<Integer> getComputer() {
        // 컴퓨터의 숫자를 생성하는 메소드
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < Constant.gameNumberLength) {
            int randomNumber = Randoms.pickNumberInRange(Constant.pickNumberMin, Constant.pickNumberMax);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}