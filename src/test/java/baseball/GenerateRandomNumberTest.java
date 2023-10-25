package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GenerateRandomNumberTest {

    @Test
    @DisplayName("랜덤 숫자 생성")
    void create() {
        // given
        GenerateRandomNumber generateRandomNumber = new GenerateRandomNumber();

        // when
        List<Integer> integers = generateRandomNumber.create();

        // then
        assertThat(3).isEqualTo(integers.size());

    }
}