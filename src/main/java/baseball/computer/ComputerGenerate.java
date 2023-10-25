package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerGenerate {
    /**
     * 컴퓨터가 숫자 3개를 랜덤으로 생성
     *
     * @return 숫자 3개를 담은 리스트
     */
    public List<Integer> getTarget() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }
}
