package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    // 각 자리 수가 서로 다른 랜덤 숫자를 생성하는 메소드
    public static List<Integer> generateRandomNumber(int length) {
        List<Integer> result = new ArrayList<>();

        while(result.size() < length) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!result.contains(randomNumber)) {
                result.add(randomNumber);
            }
        }

        return result;
    }

}
