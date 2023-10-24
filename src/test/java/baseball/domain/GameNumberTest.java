package baseball.domain;

import baseball.domain.number.UserNumber;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class GameNumberTest {

    @Test
    void 정상_숫자_생성() {
        //given
        List<Integer> integers = List.of(1, 3, 4);

        //when
        UserNumber userNumber = new UserNumber(integers);

        //then
        List<Integer> number = userNumber.getNumber();
        assertThat(number.size()).isEqualTo(3);
        assertThat(number).containsExactly(1, 3, 4);
    }

    @Test
    void 올바르지_않은_길이() {
        //given
        List<Integer> shortNumber = List.of(1, 2);
        List<Integer> longNumber = List.of(1, 2, 3, 4);

        //when & then
        assertThatThrownBy(
                () -> new UserNumber(shortNumber)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리 숫자를 입력해 주세요.");

        assertThatThrownBy(
                () -> new UserNumber(longNumber)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리 숫자를 입력해 주세요.");
    }

    @Test
    void 중복_숫자_입력() {
        //given
        List<Integer> duplicateNumber = List.of(1, 1, 2);

        //when & then
        assertThatThrownBy(
                () -> new UserNumber(duplicateNumber)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복 되지 않는 숫자를 입력해 주세요.");
    }

    @Test
    void 영_입력() {
        //given
        List<Integer> zeroNumber = List.of(0, 1, 2);

        //when & then
        assertThatThrownBy(
                () -> new UserNumber(zeroNumber)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0은 포함할 수 없습니다.");
    }

    @Test
    void 음수_입력() {
        //given
        List<Integer> negativeNumber = List.of(1, 2, -1);

        //when & then
        assertThatThrownBy(
                () -> new UserNumber(negativeNumber)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수는 포함할 수 없습니다.");
    }
}
