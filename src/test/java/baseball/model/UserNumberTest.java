package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserNumberTest {
    @Test
    @DisplayName("유효한 숫자를 입력했을 때 제대로 생성되는지 테스트한다.")
    public void 유저_생성자_테스트() throws Exception {
        // given
        String input = "123";

        // when
        List<Integer> user = new UserNumber(input).getUserNumber();

        // then
        assertThat(user.get(0)).isNotEqualTo(user.get(1));
        assertThat(user.get(1)).isNotEqualTo(user.get(2));
        assertThat(user.get(2)).isNotEqualTo(user.get(0));

    }

    @Test
    @DisplayName("중복이 있는 숫자를 입력했을 때 예외가 발생한다.")
    public void 유저_생성자_중복_자리수_예외_테스트() throws Exception {
        // given
        String input = "111";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new UserNumber(input));
    }

    @Test
    public void 유저_생성자_문자열_입력시_예외_테스트() throws Exception {
        // given
        String input = "문자열";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new UserNumber(input));
    }
}