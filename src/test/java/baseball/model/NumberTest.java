package baseball.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberTest {

    @Test
    void 랜덤숫자_생성_검증() {
        Number number = new Number();

        number.createRandomNumber();
        List<Integer> target = number.target;

        assertThat(target.size()).isEqualTo(3);
        target.forEach(t ->
                assertTrue(t >= 1 && t <= 9)
        );
        long distinctCount = target.stream().distinct().count();
        assertThat(distinctCount).isEqualTo(3);
    }
}
