package baseball.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("1부터 9까지 서로 다른 임의의 수 3개를 생성한다.")
    void createRandomNumbers() {
        List<Integer> result = RandomNumberGenerator.createRandomNumbers();

        assertThat(result.size()).isEqualTo(new HashSet<>(result).size());
        assertThat(result.size()).isEqualTo(3);
    }
}