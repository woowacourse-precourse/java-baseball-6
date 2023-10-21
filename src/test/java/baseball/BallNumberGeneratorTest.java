package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BallNumberGeneratorTest {
    @Test
    @DisplayName("숫자 생성 테스트")
    void numberGenerateTest() {
        BallNumberGenerator ballNumberGenerator = new BallNumberGenerator();
        List<Integer> generated = ballNumberGenerator.generateBallNumber();
        //9보다 크거나 1보다 작은 값의 수가 0인지 확인
        assertThat(generated.stream().filter(a -> a > 9 || a < 1).count()).isEqualTo(0);
        //리스트 사이즈가 3인지 확인
        assertThat(generated.size()).isEqualTo(3);
    }
}
