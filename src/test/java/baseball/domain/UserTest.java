package baseball.domain;

import baseball.policy.ForbidDuplicationPolicy;
import baseball.policy.RandomNumberGeneratePolicy;
import baseball.policy.ThreeDigitPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {

    private final Rule rule = new Rule(
            new RandomNumberGeneratePolicy(),
            new ForbidDuplicationPolicy(),
            new ThreeDigitPolicy());

    @ParameterizedTest
    @ValueSource(strings = {"abc", "a1b", ":)", ".", " ", "  "})
    @DisplayName("입력이 숫자가 아닐 경우 예외가 발생한다")
    void failWhenInputIsNotNumber(String input) {
        // when, then
        assertThatThrownBy(() -> new User(input, rule))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "1234", "12345", "123456", "1234567", "12345678", "123456789"})
    @DisplayName("입력이 3자리가 아닐 경우 예외가 발생한다")
    void failWhenInputLengthIsNotThree(String input) {
        // when, then
        assertThatThrownBy(() -> new User(input, rule))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("입력이 음수일 경우 예외가 발생한다")
    void failWhenInputIsNegative() {
        // given
        String input = "-123";

        // when, then
        assertThatThrownBy(() -> new User(input, rule))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력이 1~9가 아닐 경우 예외가 발생한다")
    void failWhenInputContainsZero() {
        // given
        String input = "012";

        // when, then
        assertThatThrownBy(() -> new User(input, rule))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력이 서로 다른 수가 아닐 경우 예외가 발생한다")
    void failWhenInputContainsDuplicateNumber() {
        // given
        String input = "112";

        // when, then
        assertThatThrownBy(() -> new User(input, rule))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "145", "671", "216", "789"})
    @DisplayName("입력이 서로 다른 3자리일 경우 유저 객체 생성에 성공한다")
    void successWhenInputIsNotDuplicatedThreeNumber(String input) {
        // when, then
        assertThatNoException().isThrownBy(() -> new User(input, rule));
    }

    @Test
    @DisplayName("같은 값의 User의 동등성을 보장한다")
    void successEqualsAndHashCodeWhenInputIsSame() {
        // given
        User user1 = new User("123", rule);
        User user2 = new User("123", rule);

        // when, then
        assertThat(user1).isEqualTo(user2);
        assertThat(user1).hasSameHashCodeAs(user2);
    }

    @Test
    @DisplayName("다른 값의 User의 동등성을 보장하지 않는다")
    void failEqualsAndHashCodeWhenInputIsNotSame() {
        // given
        User user1 = new User("123", rule);
        User user2 = new User("456", rule);

        // when, then
        assertThat(user1).isNotEqualTo(user2);
        assertThat(user1).doesNotHaveSameHashCodeAs(user2);
    }

}
