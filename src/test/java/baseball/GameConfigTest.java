package baseball;

import baseball.util.GameConfig;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameConfigTest {
    @Test
    void testGameNumSize() {
        // 게임 숫자 길이를 변경하고 확인
        GameConfig.GAME_NUM_SIZE.setValue(4);
        assertEquals(4, GameConfig.GAME_NUM_SIZE.getValue());

        // 다시 기본 값으로 변경
        GameConfig.GAME_NUM_SIZE.setValue(3);
    }

    @Test
    void testRandomMinValue() {
        // 최소 랜덤 값 범위를 변경하고 확인
        GameConfig.RANDOM_MIN_VALUE.setValue(0);
        assertEquals(0, GameConfig.RANDOM_MIN_VALUE.getValue());

        // 다시 기본 값으로 변경
        GameConfig.RANDOM_MIN_VALUE.setValue(1);
    }

    @Test
    void testRandomMaxValue() {
        // 최대 랜덤 값 범위를 변경하고 확인
        GameConfig.RANDOM_MAX_VALUE.setValue(10);
        assertEquals(10, GameConfig.RANDOM_MAX_VALUE.getValue());

        // 다시 기본 값으로 변경
        GameConfig.RANDOM_MAX_VALUE.setValue(9);
    }


}
