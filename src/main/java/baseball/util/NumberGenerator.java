package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

/**
 * 숫자 생성을 위한 유틸리티 클래스입니다.
 *
 * <p>이 클래스는 야구 게임에서 사용되는 유니크한 숫자를 생성하는 기능을 제공합니다.</p>
 */
public class NumberGenerator {
    private static final int NUMBER_COUNT = 3;

    /**
     * 유니크한 숫자들의 목록을 생성하여 반환합니다.
     *
     * <p>생성된 숫자의 개수는 {@code NUMBER_COUNT}에 의해 정해집니다. 현재로서는 3개의 숫자가 반환됩니다.
     * 각 숫자는 1부터 9까지의 범위 안에서 무작위로 선택됩니다.</p>
     *
     * @return 유니크한 숫자의 목록
     */
    public static List<Integer> generateUniqueNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}
