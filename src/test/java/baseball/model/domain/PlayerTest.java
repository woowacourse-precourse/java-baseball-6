package baseball.model.domain;

import static baseball.model.constants.Constant.NUMBER_SIZE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    @DisplayName("사용자가 입력한 수를 검사한 후, 리턴합니다.")
    void 사용자입력수리턴() {
        String numbers = "123";
        Player player = new Player(numbers);

        List<Integer> playerNumbers = player.getPlayerNumbers();

        assertNotNull(numbers);
        assertEquals(NUMBER_SIZE, playerNumbers.size());
    }
}
