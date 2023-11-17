package baseball.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static baseball.service.NumberGenerator.pickNumbersInRangeWithoutDuplicates;
import static org.assertj.core.api.Assertions.assertThat;

class NumberGeneratorTest {

    @Test
    @DisplayName("정답 숫자 조합이 잘 생성되는지 확인한다.")
    void createRandomNumbersInRangeCorrectly() {
        // given
        int startRange = 1;
        int endRage = 9;
        int count = 3;

        // when
        List<Integer> result = pickNumbersInRangeWithoutDuplicates(startRange, endRage, count);

        // then
        assertThat(result)
                .hasSize(count)
                .allMatch(number -> number >= startRange && number <= endRage)
                .doesNotHaveDuplicates();
    }


}