package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    /*
        Computer 가 랜덤한 중복되지 않는
        세자리의 숫자를 리턴하는 메서드
     */
    public static int[] pickRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() != 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
