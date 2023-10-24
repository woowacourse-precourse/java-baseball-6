package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CompareNumberTest {
    CompareNumber compareNumber;

    @BeforeEach
    void setUp() {
        compareNumber = new CompareNumber();
    }

    @Test
    @DisplayName("같은 수가 몇 개인지 확인")
    void count(){
        assertThat(3).isEqualTo(compareNumber.countSameNumber(Arrays.asList(1,2,3), Arrays.asList(3,1,2)));
    }

    @Test
    @DisplayName("스트라이크 개수 확인")
    void strike() {
        assertThat(1).isEqualTo(compareNumber.countStrike(Arrays.asList(3,2,4), Arrays.asList(3,1,2)));
    }
}
