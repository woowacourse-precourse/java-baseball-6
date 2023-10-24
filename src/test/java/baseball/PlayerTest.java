package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PlayerTest {
    @ParameterizedTest
    @CsvSource({
            "123",
            "456",
            "789"
    })
    void 플레이어_숫자_유효성_성공_테스트(String playerNumbers) {
        Player player = new Player(playerNumbers);

        assertEquals(playerNumbers, player.getPlayerNumbers());
    }

    @ParameterizedTest
    @CsvSource({
            "1234",
            "q",
            "",
            "112"
    })
    void 플레이어_숫자_유효성_실패_테스트(String playerNumbers) {
        assertThrows(IllegalArgumentException.class,
                () -> new Player(playerNumbers));
    }
}
