package mytest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.model.Game;
import baseball.util.InputManager;
import baseball.util.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ModelTest {
    // given
    private static final int SIZE = 3;
    private static final int MIN = 1;
    private static final int MAX = 9;
    private static final int RESTART = 1;
    private static final int EXIT = 2;

    // RandomNumberGenerator
    @DisplayName("컴퓨터가 고른 수의 길이 확인")
    @Test
    void pickedNumbersSizeTest() {
        // when
        int[] result = RandomNumberGenerator.pickRandomNumbers(SIZE, MIN, MAX);

        // then
        assertEquals(SIZE, result.length);
    }

    @DisplayName("컴퓨터가 고른 수에 중복된 숫자 없는지 확인")
    @Test
    void pickedNumbersDuplicatesTest() {
        // when
        int[] result = RandomNumberGenerator.pickRandomNumbers(SIZE, MIN, MAX);

        // then
        for (int i = 0; i < result.length; i++) {
            for (int j = i + 1; j < result.length; j++) {
                assertNotEquals(result[i], result[j]);
            }
        }
    }

    // InputManager
    @DisplayName("숫자로만 이루어져 있는지 확인")
    @Test
    void testIsAllDigits() {
        Throwable exception = assertThrows(RuntimeException.class, () ->
                InputManager.isAllDigits("asd", SIZE)
        );
        assertEquals(SIZE + "자리의 수를 입력해주세요.", exception.getMessage());
    }

    @DisplayName("입력이 범위 내에 있는지 확인")
    @Test
    void testIsNumberInRange() {
        Throwable exception = assertThrows(RuntimeException.class, () ->
                InputManager.isNumberInRange("012", MIN, MAX)
        );
        assertEquals(MIN + "~" + MAX + "에 해당하는 수만 입력해주세요.", exception.getMessage());
    }

    @DisplayName("입력 크기가 유효한지 확인")
    @Test
    void testIsSizeValid() {
        Throwable exception = assertThrows(RuntimeException.class, () ->
                InputManager.isSizeValid("12", SIZE)
        );
        assertEquals(SIZE + "자리의 수를 입력해주세요.", exception.getMessage());
    }

    @DisplayName("중복된 수가 있는지 확인")
    @Test
    void testHasDuplicates() {
        Throwable exception = assertThrows(RuntimeException.class, () ->
                InputManager.hasDuplicates("112", SIZE)
        );
        assertEquals("수를 중복되지 않게 입력해주세요.", exception.getMessage());
    }

    @DisplayName("재시작 및 종료의 입력이 숫자인지 확인")
    @Test
    void testIsRestartInputDigit() {
        Throwable exception = assertThrows(RuntimeException.class, () ->
                InputManager.isRestartInputDigit("one")
        );
        assertEquals("숫자 " + RESTART + " 혹은 " + EXIT + "를 입력해주세요.", exception.getMessage());
    }

    @DisplayName("재시작 및 종료의 입력이 유효한 숫자인지 확인")
    @Test
    void testIsRestartInputValidNumber() {
        Throwable exception = assertThrows(RuntimeException.class, () ->
                InputManager.isRestartInputValidNumber("3")
        );
        assertEquals(RESTART + " 혹은 " + EXIT + "를 입력해주세요.", exception.getMessage());
    }

    // Game
    @DisplayName("볼 개수 확인")
    @Test
    void testCountBalls() {
        int[] pickedNumbers = {1, 2, 3};
        assertEquals(3, Game.countBalls("312", pickedNumbers));
        assertEquals(0, Game.countBalls("456", pickedNumbers));
    }

    @DisplayName("스트라이크 개수 확인")
    @Test
    void testCountStrikes() {
        int[] pickedNumbers = {1, 2, 3};
        assertEquals(3, Game.countStrikes("123", pickedNumbers));
        assertEquals(2, Game.countStrikes("124", pickedNumbers));
    }

    @DisplayName("게임이 승리 상태에 도달했는지 확인")
    @Test
    void testIsGameWon() {
        int[] pickedNumbers = {1, 2, 3};
        Game.generateHint("123", pickedNumbers);
        assertTrue(Game.isGameWon());
    }
}
