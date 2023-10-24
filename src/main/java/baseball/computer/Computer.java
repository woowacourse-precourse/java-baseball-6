package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    /**
     * 서로 다른 3자리수 숫자 랜덤 생성
     * @return 서로 다른 3개의 숫자를 list에 담아 반환
     */
    public static List<Integer> generateRandomDigits(){
        List<Integer> computers = new ArrayList<>();
        while (computers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computers.contains(randomNumber)) {
                computers.add(randomNumber);
            }
        }
        return computers;
    }
}
