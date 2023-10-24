package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class UserTest {
    @ParameterizedTest
    @DisplayName("유저는 입력한 값으로 Baseballs 을 생성하고 소유할 수 있다")
    @ValueSource(strings = {"123", "456", "789", "246"})
    public void createBaseballsTest(String input) {
        // given
        User user = new User();

        // when
        user.createBaseballs(input);

        // then
        Assertions.assertThat(user.getBaseballs()).isNotNull();
    }
}