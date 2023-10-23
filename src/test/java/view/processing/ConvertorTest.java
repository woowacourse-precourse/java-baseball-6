package view.processing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ConvertorTest {

    private Convertor convertor = new Convertor();

    @Test
    void inputToBaseballNumber() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3));

        List<Integer> baseballNumber = convertor.inputToBaseballNumber("123");

        assertThat(baseballNumber).isEqualTo(numbers);
    }

    @Test
    void ballCountToHint_3스트라이크() {
        int strike = 3;
        int ball = 0;
        String input = convertor.ballCountToHint(strike, ball);

        assertThat(input).contains("3스트라이크");
    }

    @Test
    void ballCountToHint_낫싱() {
        int strike = 0;
        int ball = 0;
        String input = convertor.ballCountToHint(strike, ball);

        assertThat(input).contains("낫싱");
    }

    @Test
    void ballCountToHint_3볼() {
        int strike = 0;
        int ball = 3;
        String input = convertor.ballCountToHint(strike, ball);

        assertThat(input).contains("3볼");
    }
}