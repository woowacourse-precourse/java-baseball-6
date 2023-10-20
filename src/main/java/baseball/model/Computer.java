package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    public List<Integer> randomNumbers;

    /**
     * 입력한 크기에 맞추어 랜덤 숫자 배열을 생성한다.
     *
     * @param size
     */
    public Computer(int size) {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < size) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }

        this.randomNumbers = randomNumbers;
    }


}
