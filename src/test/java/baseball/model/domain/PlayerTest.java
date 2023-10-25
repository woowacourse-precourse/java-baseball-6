package baseball.model.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.model.service.Validator;
import baseball.model.service.ValidatorImp;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new ValidatorImp();
    }

    @Test
    @DisplayName("사용자가 게임을 위해 입력한 수를 검사한 후, 리턴합니다.")
    void 사용자_게임_숫자_입력() {
        String inputNumbers = "123";
        Player player = Player.of(inputNumbers, validator);
        List<Integer> playerNumbers = player.getPlayerNumbers();
        assertEquals(inputNumbers,
                playerNumbers.stream().map(Object::toString).reduce("", (num1, num2) -> num1 + num2));
    }
}
