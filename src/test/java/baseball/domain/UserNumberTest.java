package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class UserNumberTest {

    @Test
    void 입력_값_정상_작동_테스트() {
        String input = "124";
        List<Integer> userNumbs = new UserNumber(input).getUserNumber();
        List<Integer> userNumbsList = List.of(1, 2, 4);
        assertThat(userNumbs).isEqualTo(userNumbsList);
    }

    @Test
    void 숫자_조건_범위_예외_테스트() {
        String input = "023";
        assertThatThrownBy(() -> new UserNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_외_문자_예외_테스트() {
        String input = "1~4";
        assertThatThrownBy(() -> new UserNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력_값_길이_초과_예외_테스트() {
        String input = "1234";
        assertThatThrownBy(() -> new UserNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_중복_예외_테스트() {
        String input = "144";
        assertThatThrownBy(() -> new UserNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
