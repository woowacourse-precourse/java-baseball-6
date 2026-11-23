package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    private final InputStream originalIn = System.in;

    @AfterEach
    void tearDown() {
        System.setIn(originalIn);
        Console.close();
    }

    private void input(String text) {
        System.setIn(new ByteArrayInputStream(text.getBytes()));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "123123123123123", "9"})
    void 입력한_값을_그대로_반환한다(String value) {
        input(value + "\n");

        String result = new InputView().readUserInput();

        assertThat(result).isEqualTo(value);
    }

    @Test
    void 검증에_실패하면_예외를_발생시킨다(){
        input("\n");
        assertThatThrownBy(() -> new InputView().readUserInput())
                .isInstanceOf(IllegalArgumentException.class);
    }
}