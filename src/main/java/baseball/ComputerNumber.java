package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumber extends Number {

    public ComputerNumber() {
        // 랜덤으로 생성된 수를 컴퓨터넘버로 설정한다.
        this.number = generateRandomNumber();
    }

    private List<Integer> generateRandomNumber() {
        number = new ArrayList<>();
        // 1 부터 9 까지 서로 다른 임의의 수 3개 생성
        do {
            int ramdomNumber;
            // 1 ~ 9 사이의 난수를 생성한다.
            // 생성된 난수가 중복이면 다시 난수를 생성한다.
            do {
                ramdomNumber = Randoms.pickNumberInRange(1, 9);
            } while (number.contains(ramdomNumber));

            number.add(ramdomNumber);
        } while (number.size() < 3);
        return number;
    }
}
