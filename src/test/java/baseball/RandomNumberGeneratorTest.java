package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

class RandomNumberGeneratorTest {
    @ParameterizedTest
    @CsvSource({
            "3", "4", "5"
    })
    public void N가지의_숫자는_겹치지않고_N개를_가지고_있는다(int length) {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        int value = numberGenerator.generateNumber(length);
        Set<Integer> expect = new HashSet<>();
        while (value != 0) {
            expect.add(value % 10);
            value /= 10;
        }
        Assertions.assertThat(expect.size()).isEqualTo(length);
    }

}