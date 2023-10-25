package baseball.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.domain.Result;
import baseball.global.ComputerSingleton;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ServiceTest {

    private final Service service = new Service();

    @Test
    @DisplayName("값을 반환해주는지 확인")
    void testCalculateGameResult() {
        // Given
        ComputerSingleton computerSingleton = ComputerSingleton.getInstance();
        List<Integer> computerNumbers = computerSingleton.getComputerNumbers();
        String input = computerNumbers.stream()
            .map(Object::toString)
            .collect(Collectors.joining());

        // When
        Result gameResult = service.calculateGameResult(input);

        // Then
        assertEquals(3, gameResult.getStrike());
        assertEquals(0, gameResult.getBall());
    }

    @Test
    @DisplayName("게임 재시작 확인")
    void testIsRestart_GameRestart() {
        // When
        boolean restart = service.isRestart("1");

        // Then
        assertTrue(restart); // 게임이 재시작되어야 함
    }

    @Test
    @DisplayName("게임 종료 확인")
    void testIsRestart_GameExit() {
        // When
        boolean restart = service.isRestart("2");

        // Then
        assertFalse(restart); // 게임이 종료되어야 함
    }
}