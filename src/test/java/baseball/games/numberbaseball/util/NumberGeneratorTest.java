package baseball.games.numberbaseball.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {
    @Test
    @DisplayName("플레이어의 알맞은 문자열 입력이 리스트 형태로 변환되어 리턴")
    void generatePlayerNumbers() {
        //given
        NumberGenerator generator = new NumberGenerator();
        //when
        List<Integer> numbers = generator.createValidatedNumbers("124");
        //then
        assertThat(numbers.size()).isEqualTo(3);
        assertThat(numbers).containsExactly(1, 2, 4);
    }
}