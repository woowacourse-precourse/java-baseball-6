package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {
    @DisplayName("RandomNumberGenerator는 3자리 숫자를 생성한다.")
    @Test
    void generate_3length_number_test() {
        // when
        String number = RandomNumberGenerator.generate();
        System.out.println("number = " + number);

        // then
        assertThat(number)
                .hasSize(3)
                .matches("[1-9]+");
    }

    @DisplayName("RandomNumberGenerator는 모든 자리의 숫자가 다르다")
    @Test
    void generate_different_each_digit_test() {
        // when
        String number = RandomNumberGenerator.generate();

        // then
        Set<Character> characters = new HashSet<>();
        for (char c : number.toCharArray()) {
            assertThat(characters).doesNotContain(c);
            characters.add(c);
        }
    }

}
