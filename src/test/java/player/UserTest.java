package player;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserTest {

    private final User player = new User();

    void provideUserInput(String userInput) {
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
    }

    @AfterEach
    void afterEach() {
        Console.close();
    }

    @Test
    @DisplayName("올바르지 않은 입력시 IllegalArgumentException 발생하는지")
    void 플레이어_입력_오류_테스트() {
        //given
        final String playerInput = "1234";
        provideUserInput(playerInput);

        //when, then
        assertThatThrownBy(player::inputBaseballNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리의 숫자만 입력가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"qwe", "asd", "zxc"})
    @DisplayName("올바르지 않은 입력시 IllegalArgumentException 발생하는지")
    void 플레이어_숫자_외_입력__예외_테스트(String input) {
        //given
        final String playerInput = input;
        provideUserInput(playerInput);

        //when, then
        assertThatThrownBy(player::inputBaseballNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력 가능합니다.");
    }
}
