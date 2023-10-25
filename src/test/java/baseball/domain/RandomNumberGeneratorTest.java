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

    @Test
    @DisplayName("난수가 1부터 9까지의 서로 다른 수인지 확인한다")
    void isBallNumberFormat() {
        Stream.iterate(0, i -> i + 1)
                .limit(100)
                .forEach(i -> {
                    List<Integer> list = randNumGenerator.makeRandomNumbers();
                    assertThat(list).hasSize(3);
                    assertThat(list).doesNotHaveDuplicates();
                    assertThat(list).allMatch(num -> num >= 1 && num <= 9);
                });
    }
}