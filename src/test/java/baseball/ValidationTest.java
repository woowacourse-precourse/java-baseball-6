package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class ValidationTest {
    private static void command(String... args) {
        System.setIn(
                new ByteArrayInputStream(
                        String.join("\n", args).getBytes()
                ));
    }

    @Test
    void throwExceptionIfInputIsAlphabet() {
        String alphabetInput = "abc";
        command(alphabetInput);
        assertThatThrownBy(() -> Application.main(new String[]{})).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void throwExceptionIfInputIsKorean() {
        final String koreanInput = "가나다";
        command(koreanInput);
        assertThatThrownBy(() -> Application.main(new String[]{})).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void throwExceptionIfInputIsShorterThanThree() {
        final String shortNumbers = "23";
        command(shortNumbers);
        assertThatThrownBy(() -> Application.main(new String[]{})).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void throwExceptionIfInputIsLongerThanThree() {
        final String longNumbers = "23553";
        command(longNumbers);
        assertThatThrownBy(() -> Application.main(new String[]{})).isInstanceOf(IllegalArgumentException.class);
    }

    @AfterEach
    void closeScanner() {
        Console.close();
    }
}
