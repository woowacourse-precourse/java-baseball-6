package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.NumberBaseballGameConfig.*;

public class RandomNumberGenerator {

    /**
     * pickNumberInRange 사용, Config 클래스에 설정된 크기만큼의 난수를 생성한다.
     * @return Integer List의 형태로 생성된 난수를 반환
     */
    public static List<Integer> generate() {
        List<Integer> generated = new ArrayList<>();
        while (generated.size() < BASEBALL_NUMBER_LENGTH) {
            int number = Randoms.pickNumberInRange(MIN_PLACE_VALUE, MAX_PLACE_VALUE);
            if (!generated.contains(number)) {
                generated.add(number);
            }
        }
        return generated;
    }
}
