package baseball.domain.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RandomUniqueBallNumbersGenerateStrategyTest {

    @DisplayName("랜덤하게 startInclusive, endInclusive 사이의 중복없는 count 자리 문자열을 생성한다")
    @ParameterizedTest
    @CsvSource(value = {"1:9:3", "1:9:4", "0:9:3"}, delimiter = ':')
    void generate(int startInclusive, int endInclusive, int count) {
        BallNumbersGenerateStrategy generateStrategy = RandomUniqueBallNumbersGenerateStrategy.instance();
        List<Integer> ballNumbers = generateStrategy.generate(startInclusive, endInclusive, count);

        assertThat(ballNumbers).allMatch(ballNumber -> ballNumber >= startInclusive);
        assertThat(ballNumbers).allMatch(ballNumber -> ballNumber <= endInclusive);
        assertThat(ballNumbers).hasSameSizeAs(new HashSet<>(ballNumbers));
    }
}
