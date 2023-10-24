package baseball;

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
        settingForInputStream(input);

        // when
        List<Integer> guessNumber = guessInputConverter.getValue();

        // then
        assertThat(guessNumber).isEqualTo(List.of(1, 2, 3));
    }

    @Test
    void 추측값_타입_예외_테스트() {
        // given
        String input = "avx\nㅁㄱㄴ\n\"   \"";
        settingForInputStream(input);

        // when & then
        String[] inputList = input.split("\n");
        for (int i = 0; i < inputList.length; i++) {
            assertThatThrownBy(() -> guessInputConverter.getValue())
                .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void 추측값_자리수_예외_테스트() {
        // given
        String input = "12\n1256\n9246";
        settingForInputStream(input);

        // when & then
        String[] inputList = input.split("\n");
        for (int i = 0; i < inputList.length; i++) {
            assertThatThrownBy(() -> guessInputConverter.getValue())
                .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void 추측값_범위_예외_테스트() {
        // given
        String input = "102\n012\n9086";
        settingForInputStream(input);

        // when & then
        String[] inputList = input.split("\n");
        for (int i = 0; i < inputList.length; i++) {
            assertThatThrownBy(() -> guessInputConverter.getValue())
                .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void 추측값_중복_예외_테스트() {
        // given
        String input = "112\n999\n9774";
        settingForInputStream(input);

        // when & then
        String[] inputList = input.split("\n");
        for (int i = 0; i < inputList.length; i++) {
            assertThatThrownBy(() -> guessInputConverter.getValue())
                .isInstanceOf(IllegalArgumentException.class);
        }
    }

    private void settingForInputStream(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

}