package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandTest {

    @Test
    void 난수_생성_여부_확인() {
        NumberGenerator generator = new NumberGenerator();
        List<Integer> answer = generator.createAnswer();
        assertThat(answer.size()).isEqualTo(3);
        assertThat(answer.size()).isNotEqualTo(4);
        assertThat(answer.size()).isNotEqualTo(10);
    }
}
