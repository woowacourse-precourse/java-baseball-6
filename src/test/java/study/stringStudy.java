package study;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

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

    @Test
    void setTest() {
        String input1 = "12345";
        String input2 = "11111";
        Set<Character> charSet1 = new HashSet<>();
        charSet1.add(input1.charAt(0));
        charSet1.add(input1.charAt(1));
        charSet1.add(input1.charAt(2));
        charSet1.add(input1.charAt(3));
        charSet1.add(input1.charAt(4));

        Set<Character> charSet2 = new HashSet<>();
        charSet2.add(input2.charAt(0));
        charSet2.add(input2.charAt(1));
        charSet2.add(input2.charAt(2));
        charSet2.add(input2.charAt(3));
        charSet2.add(input2.charAt(4));

        assertThat(charSet1.size()).isEqualTo(5);
        assertThat(charSet2.size()).isEqualTo(1);
    }
}
