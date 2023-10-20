package baseball;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class GameUtilTest {

    @Test
    void inputTest() {
        //given
        List<Integer> integerList = GameUtil.inputParse("123");

        //then
        assertThat(integerList.get(0)).isEqualTo(1);
        assertThat(integerList.get(1)).isEqualTo(2);
        assertThat(integerList.get(2)).isEqualTo(3);

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> GameUtil.inputParse("1234"))
                .withMessage("%s", "[세자리 수] 세 자리의 숫자를 입력해 주세요.");

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> GameUtil.inputParse("1nd"))
                .withMessage("%s", "[형식 오류] 올바르지 않은 숫자 형식입니다.");
    }

    @Test
    void validateValue() {
        //given
        int v1 = 10;
        int v2 = 0;
        int v3 = 1;

        //when
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> GameUtil.validateValue(v1))
                .withMessage("%s", "[벗어난 수] 1부터 9사이의 값을 입력해 주세요.");

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> GameUtil.validateValue(v2))
                .withMessage("%s", "[벗어난 수] 1부터 9사이의 값을 입력해 주세요.");

        assertDoesNotThrow(() -> GameUtil.validateValue(v3));
    }

    @Test
    void validateDuplicate() {
        //given
        List<Integer> integerList = GameUtil.inputParse("113");

        //then
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> GameUtil.validateDuplicate(integerList))
                .withMessage("%s", "[중복된 수] 서로 다른 3개의 숫자를 입력해 주세요.");
    }
}