package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GenerateRandomNumberTest {
    @Test
    @DisplayName("랜덤 숫자 생성 테스트")
    void randomTest() {
        GenerateRandomNumber generateRandomNumber = new GenerateRandomNumber();
        List<Integer> test = generateRandomNumber.create();
        assertThat(3).isEqualTo(test.size());
    }
}
