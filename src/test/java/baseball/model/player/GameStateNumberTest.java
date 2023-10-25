package baseball.model.player;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameStateNumberTest {

    private GameStateNumber gameStateNumber;

    @BeforeEach
    void init() {
        gameStateNumber = new GameStateNumber();
    }

    @Test
    @DisplayName("재시작/종료 여부의 필드값이 2이면 true를 반환한다.")
    void isExit_True_Test() throws NoSuchFieldException, IllegalAccessException {
        // when
        setStateNumber(2);

        // then
        assertTrue(gameStateNumber.isExit());
    }

    @Test
    @DisplayName("재시작/종료 여부의 필드값이 1이면 false를 반환한다.")
    void isExit_False_Test() throws NoSuchFieldException, IllegalAccessException {
        // when
        setStateNumber(1);

        // then
        assertFalse(gameStateNumber.isExit());
    }

    private void setStateNumber(Integer restartOrExit) throws NoSuchFieldException, IllegalAccessException {
        Field stateNumber = gameStateNumber.getClass().getDeclaredField("stateNumber");
        stateNumber.setAccessible(true);
        stateNumber.set(gameStateNumber, restartOrExit);
    }
}