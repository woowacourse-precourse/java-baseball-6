package baseball.utils;

import static baseball.constant.BaseballSystemPolicy.LIMIT_LENGTH;
import static baseball.constant.BaseballSystemPolicy.MAXIMUM_NUMBER;
import static baseball.constant.BaseballSystemPolicy.MINIMUM_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

@DisplayName("Utility 난수 생성기")
class RandomGeneratorUtilsTest {

    @DisplayName("3자리 고유한 숫자를 생성한다.")
    @RepeatedTest(3)
    void testCreateNumber() {
        //given
        //when
        long uniqueNumberCount = RandomGeneratorUtils.createUniqueNumbers(LIMIT_LENGTH.getCondition(),
                        MINIMUM_NUMBER.getCondition(), MAXIMUM_NUMBER.getCondition()).stream()
                .distinct()
                .count();

        //then
        assertThat(uniqueNumberCount).isEqualTo(LIMIT_LENGTH.getCondition());
    }
}