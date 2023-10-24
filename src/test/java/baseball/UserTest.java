package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
    }

    @Test
    public void 사용자입력_길이_3인경우() {
        // given

        // when
        List<Integer> result = user.changeStringToIntegerList("735");

        // then
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    public void 사용자입력_길이_3아닌경우() {
        // given

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            user.changeStringToIntegerList("47");
        });
    }

    @Test
    public void 사용자입력_중복된숫자_있는경우() {
        // given

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            user.changeStringToIntegerList("113");
        });
    }
}