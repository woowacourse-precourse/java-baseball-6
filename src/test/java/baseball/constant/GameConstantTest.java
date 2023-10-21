package baseball.constant;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class GameConstantTest {
    @Test
    void 같은_value를_가진_두_Enum은_다른_객체여야_한다() {
        GameConstant constant1 = GameConstant.MIN_BALL_NUM;
        GameConstant constant2 = GameConstant.RESTART;

        assertAll(
                () -> assertEquals(constant1.getValue(), constant2.getValue()),
                () -> assertNotEquals(constant1, constant2)
        );
    }
}
