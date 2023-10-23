package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GenerateRandomNumTest {

    @Test
    @DisplayName("랜덤 숫자 생성")
    void create() {
        // given
        GenerateRandomNum generateRandomNum = new GenerateRandomNum();

        // when
        List<Integer> integers = generateRandomNum.create();

        // then
        assertThat(3).isEqualTo(integers.size());

    }
}