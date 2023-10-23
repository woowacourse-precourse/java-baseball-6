package baseball.model.domain;

import static baseball.model.constants.GameConstants.GAME_NUMBERS_SIZE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import baseball.model.service.PlayerNumbersValidator;
import baseball.model.service.PlayerNumbersValidatorImp;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    @DisplayName("사용자가 입력한 수를 검사한 후, 리턴합니다.")
    void 사용자입력수리턴() {
        PlayerNumbersValidator playerNumbersValidator = new PlayerNumbersValidatorImp();
        String inputNumbers = "123";
        Player player = Player.of(inputNumbers, playerNumbersValidator);

        List<Integer> playerNumbers = player.getPlayerNumbers();

        assertNotNull(inputNumbers);
        assertEquals(GAME_NUMBERS_SIZE, playerNumbers.size());
    }
}
