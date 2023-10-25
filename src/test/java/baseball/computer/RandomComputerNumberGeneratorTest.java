package baseball.computer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomComputerNumberGeneratorTest {

    @DisplayName("생성된 난수를 문자열로 변환하면 3글자의 문자열이 반환된다.")
    @Test
    void check_number_string() {
        // given
        RandomComputerNumberGenerator generator = new RandomComputerNumberGenerator();

        // when
        String numberString = generator.toString();

        // then
        assertThat(numberString)
                .matches("\\d{3}");
    }

}
