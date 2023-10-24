package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/**
 * ModelCreateRandomNumber.java
 * <p>
 * 난수 생성 모델
 *
 * @author Lee NaYeon
 * @since 2023-10-25
 */
public class ModelCreateRandomNumber {

    /**
     * 3자리 난수 생성
     *
     * @return List<Integer> 타입의 3자리 난수
     */
    public static List<Integer> createRandomNumber() {

        List<Integer> list = new ArrayList<>();
        while (list.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!list.contains(randomNumber)) {
                list.add(randomNumber);
            }
        }

        return list;
    }
}
