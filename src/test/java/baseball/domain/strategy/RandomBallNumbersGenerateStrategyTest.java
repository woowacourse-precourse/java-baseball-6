package baseball.domain.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomBallNumbersGenerateStrategyTest {

    @DisplayName("랜덤하게 1-9 사이의 중복없는 3자리 문자열을 생성한다")
    @Test
    void generate() {
        BallNumbersGenerateStrategy generateStrategy = new RandomBallNumbersGenerateStrategy();
        String ballNumbers = generateStrategy.generate();

        Pattern validNumberPattern = Pattern.compile("[1-9]{3}");
        assertThat(ballNumbers).matches(validNumberPattern);

        Set<String> uniqueBallNumbers = new HashSet<>();
        for (char ballNumber : ballNumbers.toCharArray()) {
            uniqueBallNumbers.add(String.valueOf(ballNumber));
        }
        assertThat(uniqueBallNumbers).hasSize(3);
    }
}
