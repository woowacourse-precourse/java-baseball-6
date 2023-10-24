package baseball;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JudgementResultTest {
    CompareNumber compareNumber;
    JudgementResult judgementResult;

    @BeforeEach
    void setUp() {
        compareNumber = new CompareNumber();
        judgementResult = new JudgementResult();
    }

    @Test
    @DisplayName("3볼 확인")
    void checkBall() {
        assertThat("3볼").isEqualTo(judgementResult.judgementResult(Arrays.asList(3,1,2),Arrays.asList(1,2,3)));
    }

    @Test
    @DisplayName("3스트라이크 확인")
    void checkStrike() {
        assertThat("3스트라이크").isEqualTo(judgementResult.judgementResult(Arrays.asList(1,2,3),Arrays.asList(1,2,3)));
    }

    @Test
    @DisplayName("낫싱 확인")
    void checkNothing(){
        assertThat("낫싱").isEqualTo(judgementResult.judgementResult(Arrays.asList(1,2,3),Arrays.asList(4,5,6)));
    }
}
