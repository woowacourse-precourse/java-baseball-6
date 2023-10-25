package baseball.others;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerTest {
    @DisplayName("공백 제거 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"  1 2 3   ", "  45  6   ", "  8 9 ", "   1 "})
    public void removeSpace_Test(String input) {
        // Given
        String expected = input.replaceAll(" ", "");
        // When
        String result = Player.removeSpace(input);
        // Then
        assertEquals(expected, result);
    }
}