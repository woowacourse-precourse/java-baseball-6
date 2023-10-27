package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class UserNumberTest {

    @Test
    void 입력_값_정상_작동_테스트() {
        String input = "124";
        UserNumber userNumbs = new UserNumber(input);
        List<Integer> computerNumbs = List.of(4, 2, 1);

        assertThat(userNumbs.isBall(computerNumbs.get(0), 0)).isTrue();
        assertThat(userNumbs.isBall(computerNumbs.get(1), 1)).isFalse();
        assertThat(userNumbs.isBall(computerNumbs.get(2), 2)).isTrue();

        assertThat(userNumbs.isStrike(computerNumbs.get(0), 0)).isFalse();
        assertThat(userNumbs.isStrike(computerNumbs.get(1), 1)).isTrue();
        assertThat(userNumbs.isStrike(computerNumbs.get(2), 2)).isFalse();
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
