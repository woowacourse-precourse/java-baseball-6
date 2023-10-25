package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComNumberGeneratorTest {
    @DisplayName("중복된 숫자를 넣었을 때, 중복이 제거된 정수 리스트를 정확히 리턴하는지 확인합니다.")
    @Test
    void generate_ReturnCorrectList() {
        ComNumberGenerator comNumberGenerator = spy(new ComNumberGenerator());
        when(comNumberGenerator.getRandomNumber())
                .thenReturn(1, 5, 1, 5, 9, 6, 3, 2);

        List<Integer> expected = List.of(1, 5, 9);

        assertThat(comNumberGenerator.generate()).isEqualTo(expected);
    }
}