package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    void 입력_문자열이_숫자_리스트로_완성되었는지_검토() {
        Player player = new Player("123");
        List<Integer> computerNums = player.getInputNums();
        assertThat(computerNums.stream().allMatch(v -> v >= 1 && v <= 9)).isTrue();
    }
}
