package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {
    private List<Integer> computerNumber;

    public ComputerNumber() {
        // 랜덤으로 생성된 수를 컴퓨터넘버로 설정한다.
        this.computerNumber = generateRandomNumber();
    }

    // Counter 클래스에서 사용하므로 public으로 설정한다.
    public List<Integer> getComputerNumber() {
        return this.computerNumber;
    }

    private List<Integer> generateRandomNumber() {
        computerNumber = new ArrayList<>();
        // 1 부터 9 까지 서로 다른 임의의 수 3개 생성
        do {
            int ramdomNumber;
            // 1 ~ 9 사이의 난수를 생성한다.
            // 생성된 난수가 중복이면 다시 난수를 생성한다.
            do {
                ramdomNumber = Randoms.pickNumberInRange(1, 9);
            } while (computerNumber.contains(ramdomNumber));

            computerNumber.add(ramdomNumber);
        } while (computerNumber.size() < 3);
        return computerNumber;
    }
}
