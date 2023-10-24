package baseball.Game;

import baseball.Util.Constant;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {

    public List<Integer> getComputer() {
        // 컴퓨터의 숫자를 생성하는 메소드
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < Constant.GAME_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(Constant.PICK_NUMBER_MIN, Constant.PICK_NUMBER_MAX);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}