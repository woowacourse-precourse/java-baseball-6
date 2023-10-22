package baseball.domain.utils;

import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomGeneratorTest {

    /* package camp.nextstep.edu.missionutils.test에 이미 Test 코드 작성되어있음 */

    @Test
    @DisplayName("3개의 생성된 난수로 이루어진 List를 반환합니다")
    void getRandomNumbers() {
        // GIVEN
        List<Integer> randomNumbers = RandomGenerator.getRandomNumbers();

        // WHEN

        // THEN
        System.out.println(randomNumbers.toString());
    }
}