package baseball;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class InputParserTest {

    @Test
    void 입력_전체_테스트() {
        String input = "815";
        int goal = 3;
        assertThat(InputParser.getUserNumbers(input, goal)).isEqualTo(List.of(8, 1, 5));
    }

    @Test
    void 검증_테스트() {
        String input = "815";
        int goal = 3;
        InputParser.validate(input, goal);
    }

    @Test
    void 숫자가_아니면_에러발생() {
        String input = "1ab";
        assertThatThrownBy(() -> InputParser.digitCheck(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("NOT A DIGIT");
    }

    @Test
    void 숫자를_더길거나_작게_입력하면_에러발생() {
        String input = "1234";
        int goal = 2;
        assertThatThrownBy(() -> InputParser.lengthCheck(input.length(), goal))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("BAD INPUT");
    }

    @Test
    void 숫자가_중복되면_에러발생() {
        String input = "122";
        assertThatThrownBy(() -> InputParser.duplicateCheck(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("DUPLICATE NUMBER");
    }
}
