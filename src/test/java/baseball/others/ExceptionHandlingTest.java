/*
 * package baseball.others;

 * import static org.junit.jupiter.api.Assertions.assertThrows;

 * import org.junit.jupiter.api.DisplayName;
 * import org.junit.jupiter.api.Test;
 * import org.junit.jupiter.params.ParameterizedTest;
 * import org.junit.jupiter.params.provider.ValueSource;

 * public class ExceptionHandlingTest {
 *    @DisplayName("Null값 예외 처리 테스트")
 *    @Test
 *    public void isNull_Test() {
 *        // Given
 *        String input = "";
 *
 *       // When and Then
 *        assertThrows(IllegalArgumentException.class, () -> {
 *            ExceptionHandling.isNull(input);
 *        });
 *    }
 *
 *    @DisplayName("3개의 값이 들어오지 않았을 때 예외 처리 테스트")
 *    @ParameterizedTest
 *    @ValueSource(strings = {"1", "56", "9782"})
 *    public void isThree_Test(String input) {
 *        // Given (provided by ValueSource)
 *
 *        // When and Then
 *        assertThrows(IllegalArgumentException.class, () -> {
 *            ExceptionHandling.isThree(input);
 *        });
 *    }
 *
 *    @DisplayName("1~9 이외의 값 예외 처리 테스트")
 *    @ParameterizedTest
 *    @ValueSource(strings = {"12A", "ABC", "9h4", "015"})
 *    public void isDigits_Test(String input) {
 *        // Given (provided by ValueSource)
 *
 *        // When and Then
 *        assertThrows(IllegalArgumentException.class, () -> {
 *            ExceptionHandling.isDigits(input);
 *        });
 *    }
 *
 *    @DisplayName("중복 예외 처리 테스트")
 *    @Test
 *    public void isDifferent_Test() {
 *        // Given
 *        String input = "112";
 *
 *        // When and Then
 *        assertThrows(IllegalArgumentException.class, () -> {
 *            ExceptionHandling.isDifferent(input);
 *        });
 *    }
 *}
 */