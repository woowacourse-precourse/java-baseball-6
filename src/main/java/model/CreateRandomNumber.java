/*
 * <pre>
 * Class : CreateRandomNumber
 * Comment: 숫자 생성 규칙에 따라 난수를 생성하는 모델
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2023-10-22       손준형           최초 생성
 * 2023-10-23       손준형           매직넘버 상수 대체
 * </pre>
 *
 * @author 손준형
 * @version 1.0.1
 * @see
 */

package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CreateRandomNumber {
    public static final int MIN_NUMBER = 1;
    public static final int NUMBER_SIZE = 3;
    public static final int MAX_NUMBER = 9;

    public static List<Integer> createRandomNumber() {
        List<Integer> number = new ArrayList<>();
        while (number.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!number.contains(randomNumber)) {
                number.add(randomNumber);
            }
        }
        return number;
    }
}
