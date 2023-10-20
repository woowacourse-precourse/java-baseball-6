package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class stringStudy {
    @Test
    void 공백을_가진_String에_대한_Test() {
        String input = "1 23";
        assertThat(input.contains(" ")).isEqualTo(true);
    }

    @Test
    void comma를_가진_String에_대한_test() {
        String input ="1,2,3";
        assertThat(input.contains(",")).isEqualTo(true);
    }

    @Test
    void String_에서_인덱스_값의_test() {
        String input = "123g0";
        assertThat(Character.isDigit(input.charAt(0))).isEqualTo(true);
        assertThat(Character.isDigit(input.charAt(3))).isEqualTo(false);
        assertThat(input.charAt(4)).isEqualTo('0');
    }
}
