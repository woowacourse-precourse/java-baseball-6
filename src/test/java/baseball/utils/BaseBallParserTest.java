package baseball.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.Test;

class BaseBallParserTest {

    @Test
    void parseTest() {
        String input = "123";
        int size = 3;

        List<Integer> parse = BaseBallParser.parse(input, size);

        assertThat(parse).isEqualTo(List.of(1, 2, 3));
    }

    @Test
    void nonCharTest() {
        String input = "12a";
        int size = 3;

        assertThatThrownBy(() -> {
            BaseBallParser.parse(input, size);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void lengthErrorTest() {
        String input = "123";
        int size = 2;

        assertThatThrownBy(() -> {
            BaseBallParser.parse(input, size);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void duplicateTest() {
        String input = "121";
        int size = 4;

        assertThatThrownBy(() -> {
            BaseBallParser.parse(input, size);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}