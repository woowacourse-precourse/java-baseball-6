package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    /** selectNumber : 컴퓨터가 숫자를 선택
     *  컴퓨터는 1에서 9까지 서로 다른 임의의 수를 3개 선택
     */
    public List<Integer> selectNumber() {

        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < 3) {

            int number = Randoms.pickNumberInRange(1, 9);

            if (!randomNumbers.contains(number)) {

                randomNumbers.add(number);

            }
        }

        return randomNumbers;
    }
}
