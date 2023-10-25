package baseball.io;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class RandomsTest {

    @Test
    void getSingleNumber가_1에서9의값을_잘가져오는가() {
        int numberOfTests = 1000;
        assertThat(
                Stream.generate(Randoms::getSingleNumber)
                        .limit(numberOfTests)
                        .allMatch(number -> 1 <= number && number <= 9))
                .isTrue();
    }

}