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

    @Test
    @DisplayName("Ball Count 및 Strike Count의 Hint 문자열")
    void showHint() {
        String computerNumber1 = "123";
        String playerNumber1 = "123";
        GameUtil gameUtil1 = new GameUtil();

        String computerNumber2 = "143";
        String playerNumber2 = "532";
        GameUtil gameUtil2 = new GameUtil();

        String computerNumber3 = "143";
        String playerNumber3 = "132";
        GameUtil gameUtil3 = new GameUtil();

        gameUtil1.computeCount(computerNumber1, playerNumber1);
        gameUtil2.computeCount(computerNumber2, playerNumber2);
        gameUtil3.computeCount(computerNumber3, playerNumber3);


        Assertions.assertEquals(gameUtil1.showHint(), "3스트라이크");
        Assertions.assertEquals(gameUtil2.showHint(), "1볼");
        Assertions.assertEquals(gameUtil3.showHint(), "1볼 1스트라이크");

    }

    @Test
    @DisplayName("3스트라이크 시 게임 종료 여부 확인")
    void checkGameOver() {
        String computerNumber1 = "123";
        String playerNumber1 = "123";
        GameUtil gameUtil1 = new GameUtil();

        String computerNumber2 = "143";
        String playerNumber2 = "532";
        GameUtil gameUtil2 = new GameUtil();

        gameUtil1.computeCount(computerNumber1, playerNumber1);
        gameUtil2.computeCount(computerNumber2, playerNumber2);


        Assertions.assertTrue(gameUtil1.checkGameOver());
        Assertions.assertFalse(gameUtil2.checkGameOver());
    }
}