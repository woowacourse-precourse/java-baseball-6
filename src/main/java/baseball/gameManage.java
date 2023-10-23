package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class gameManage implements gameManageInterface {
    public void init() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        play();

    }

    public List<Integer> selectComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public void play() {
        List<Integer> computerNumber = selectComputerNumber();
    }
}
