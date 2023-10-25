package baseball.domain.utils;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomGeneratorTest {
    @Test
    @DisplayName("3개의 생성된 난수로 이루어진 List를 반환합니다")
    void test_getRandomNumbers() {
        // GIVEN

        // WHEN
        List<Integer> randomNumbers = RandomGenerator.getRandomNumbers();

        // THEN
        for (Integer eachRandNum : randomNumbers) {
            assertThat(eachRandNum).isBetween(1, 9);
        }
        assertThat(randomNumbers.size()).isEqualTo(3);
        System.out.println(randomNumbers.toString());
    }
}