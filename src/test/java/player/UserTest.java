package player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("플레이어의 입력이 123인지 확인하는 테스트")
    void 플레이어_입력_정상_테스트() {
        //given
        final String playerInput = "123";
        provideUserInput(playerInput);
        List<Integer> baseballNumbers = new ArrayList<>();
        baseballNumbers.add(1);
        baseballNumbers.add(2);
        baseballNumbers.add(3);

        //when
        player.inputBaseballNumbers();
        BaseballNumbers playerBaseballNumber = player.getBaseballNumbers();

        //then
        assertThat(playerBaseballNumber).isEqualTo(new BaseballNumbers(baseballNumbers));
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
}
