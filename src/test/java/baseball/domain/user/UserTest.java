package baseball.domain.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {
    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    @DisplayName("재시작 여부 문자열을 숫자로 변환합니다")
    void getWouldRestartGame() {
        // GIVEN
        String userOption = "1";
        Integer expectedUserOption = 1;

        try {
            // WHEN
            Integer wouldRestartGame = user.getWouldRestartGame(userOption);

            // THEN
            assertThat(wouldRestartGame).isEqualTo(expectedUserOption);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    @DisplayName("옵션에 없는 재시작 여부 옵션 선택 시, 예외 처리합니다.")
    void validateGameOption() {
        // GIVEN
        Integer outOfOption = 4;

        assertThatThrownBy(() -> user.validateGameOption(outOfOption)) // WHEN
                .isInstanceOf(IllegalArgumentException.class); // THEN
    }

    @Test
    @DisplayName("입력한 야구 게임 정답값을 파싱합니다.")
    void getInputsFromUser() throws Exception {

        // GIVEN
        String userAnswer = "142";
        List<Integer> expectedAnswers = new ArrayList<>();
        expectedAnswers.add(1);
        expectedAnswers.add(4);
        expectedAnswers.add(2);

        try {
            // WHEN
            List<Integer> parsedUserAnswer = User.parseUserAnswer(userAnswer);
            boolean hasParsedCorrectly = parsedUserAnswer.equals(expectedAnswers);

            // THEN
            assertThat(hasParsedCorrectly).isEqualTo(true);
        } catch (Exception e) {
            throw e;
        }
    }

    @Test
    @DisplayName("입력한 야구 게임 정답값의 길이에 대한 예외처리를 합니다.")
    void validateLengthOnUserAnswer() {
        // GIVEN
        String userAnswer = "1234";

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> { // THEN
            user.parseUserAnswer(userAnswer); // WHEN
        });
    }

    @Test
    @DisplayName("입력한 야구 게임 정답값이 숫자인지 대한 예외처리를 합니다.")
    void validateNumericOnUserAnswer() {
        // GIVEN
        String userAnswer = "14a";

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> { // THEN
            user.parseUserAnswer(userAnswer); // WHEN
        });
    }
}