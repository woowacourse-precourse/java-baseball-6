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

    private static final int NUMBER_LENGTH = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    /**
     * 3자리 난수 생성
     *
     * @return List<Integer> 타입의 3자리 난수
     */
    public static List<Integer> createRandomNumber() {

        List<Integer> list = new ArrayList<>();
        while (list.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!list.contains(randomNumber)) {
                list.add(randomNumber);
            }
        }

        return list;
    }
}
