package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class GuessInputConverterTest {

    GuessInputConverter guessInputConverter = new GuessInputConverter();

    @AfterEach
    void closeScanner() {
        Console.close();
    }

    @Test
    void 추측값_정상_로직_테스트() {
        // given
        String input = "123";
        command(input);

        // when
        List<Integer> guessNumber = guessInputConverter.getValue();

        // then
        assertThat(guessNumber).isEqualTo(List.of(1, 2, 3));
    }

    @Test
    void 추측값_타입_예외_테스트() {
        // given
        String input = "avx";
        command(input);

        // when & then
        assertSimpleTest(() ->
            assertThatThrownBy(() -> guessInputConverter.getValue())
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 추측값_2자리_예외_테스트() {
        // given
        String input = "12";
        command(input);

        // when & then
        assertSimpleTest(() ->
            assertThatThrownBy(() -> guessInputConverter.getValue())
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 추측값_4자리_예외_테스트() {
        // given
        String input = "9246";
        command(input);

        // when & then
        assertSimpleTest(() ->
            assertThatThrownBy(() -> guessInputConverter.getValue())
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 추측값_범위_예외_테스트() {
        // given
        String input = "102";
        command(input);

        // when & then
        assertSimpleTest(() ->
            assertThatThrownBy(() -> guessInputConverter.getValue())
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 추측값_중복_예외_테스트() {
        // given
        String input = "122";
        command(input);

        // when & then
        assertSimpleTest(() ->
            assertThatThrownBy(() -> guessInputConverter.getValue())
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    private void command(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

}