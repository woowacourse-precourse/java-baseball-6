package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computer;

    private Computer(List<Integer> computer) {
        this.computer = computer;
    }

    // 컴퓨터 3자리 수 만드는 함수
    public static Computer createComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return new Computer(computer);
    }

    public List<Integer> getComputerNumber() {
        return computer;
    }
}
