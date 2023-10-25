package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {
    RandomNumberGenerator randNumGenerator = new RandomNumberGenerator();

    @Test
    @DisplayName("중복된 수가 없는지 확인한다")
    void distinctNumberExist() {
        Stream.iterate(0, i -> i + 1)
                .limit(100)
                .forEach(i -> {
                    List<Integer> list = randNumGenerator.makeRandomNumbers();
                    assertThat(list).doesNotHaveDuplicates();
                });
    }
}