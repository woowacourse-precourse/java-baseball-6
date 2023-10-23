package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class InputParserTest {

    @Test
    void 사용자의_수_변환_테스트_01() {
        String userNumber = "123";
        List<Integer> expectedResult = List.of(1, 2, 3);
        List<Integer> result = InputParser.parseUserNumber(userNumber);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void 사용자의_수_변환_테스트_02() {
        String userNumber = "456";
        List<Integer> expectedResult = List.of(4, 5, 6);
        List<Integer> result = InputParser.parseUserNumber(userNumber);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void 사용자의_수_변환_테스트_03() {
        String userNumber = "789";
        List<Integer> expectedResult = List.of(7, 8, 9);
        List<Integer> result = InputParser.parseUserNumber(userNumber);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void 사용자의_수_변환_테스트_04() {
        String userNumber = "147";
        List<Integer> expectedResult = List.of(1, 4, 7);
        List<Integer> result = InputParser.parseUserNumber(userNumber);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void 사용자의_수_변환_테스트_05() {
        String userNumber = "258";
        List<Integer> expectedResult = List.of(2, 5, 8);
        List<Integer> result = InputParser.parseUserNumber(userNumber);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void 사용자의_수_변환_테스트_06() {
        String userNumber = "369";
        List<Integer> expectedResult = List.of(3, 6, 9);
        List<Integer> result = InputParser.parseUserNumber(userNumber);

        assertThat(result).isEqualTo(expectedResult);
    }

}