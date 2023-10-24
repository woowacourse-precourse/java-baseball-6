package baseball.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


class GameUtilTest {

    @InjectMocks
    private GameUtil gameUtil = new GameUtil();

    @Test
    @DisplayName("Ball Count 확인")
    void computeBallCount() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String computerNumber1 = "123";
        String playerNumber1 = "321";

        String computerNumber2 = "143";
        String playerNumber2 = "328";

        Method method = gameUtil.getClass().getDeclaredMethod("computeBallCount", String.class, String.class);
        method.setAccessible(true);

        Assertions.assertEquals(method.invoke(gameUtil, computerNumber1, playerNumber1), 2);
        Assertions.assertEquals(method.invoke(gameUtil, computerNumber2, playerNumber2), 1);
    }

    @Test
    @DisplayName("Ball Count 확인")
    void computeStrikeCount() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String computerNumber1 = "123";
        String playerNumber1 = "123";

        String computerNumber2 = "143";
        String playerNumber2 = "523";

        Method method = gameUtil.getClass().getDeclaredMethod("computeStrikeCount", String.class, String.class);
        method.setAccessible(true);

        Assertions.assertEquals(method.invoke(gameUtil, computerNumber1, playerNumber1), 3);
        Assertions.assertEquals(method.invoke(gameUtil, computerNumber2, playerNumber2), 1);
    }
}