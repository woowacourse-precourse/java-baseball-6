package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Integer> numbers;

    public Computer() {
        this.numbers = pickNumber();
    }

    // 상대방(컴퓨터)이 랜덤으로 숫자를 뽑는다.
    private List<Integer> pickNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        for (int com : computer) {
            System.out.println("상대방(컴퓨터) 입력 수: " + com);
        }
        return computer;
    }

    public List<Integer> getNumber() {
        return numbers;
    }
}
