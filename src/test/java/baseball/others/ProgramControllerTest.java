/* package baseball.others;
 *
 * import static org.junit.jupiter.api.Assertions.assertFalse;
 * import static org.junit.jupiter.api.Assertions.assertThrows;
 * import static org.junit.jupiter.api.Assertions.assertTrue;
 *
 * import org.junit.jupiter.api.DisplayName;
 * import org.junit.jupiter.api.Test;
 * import org.junit.jupiter.params.ParameterizedTest;
 * import org.junit.jupiter.params.provider.ValueSource;
 *
 * public class ProgramControllerTest {
 *    @DisplayName("재시작 값으로 1이 들어왔을 때 true 반환 테스트")
 *    @Test
 *    public void ifRestart_Test_WithInput1() {
 *        // Given
 *        String input = "1";
 *        // When and Then
 *        assertTrue(ProgramController.ifRestart(input));
 *    }
 *
 *    @DisplayName("재시작 값으로 2가 들어왔을 때 false 반환 테스트")
 *    @Test
 *    public void ifRestart_Test_WithInput2() {
 *        // Given
 *        String input = "2";
 *
 *        // When and Then
 *        assertFalse(ProgramController.ifRestart(input));
 *    }
 *
 *    @DisplayName("재시작 값으로 1 or 2 외의 값이 들어왔을 때 예외 처리 테스트")
 *    @ParameterizedTest
 *    @ValueSource(strings = {"3", "abc", "0"})
 *    public void ifRestart_Test_WithInvalidInput(String input) {
 *        // Given (provided by ValueSource)
 *
 *        // When and Then
 *        assertThrows(IllegalArgumentException.class, () -> {
 *            ProgramController.ifRestart(input);
 *       });
 *    }
 *}
 */