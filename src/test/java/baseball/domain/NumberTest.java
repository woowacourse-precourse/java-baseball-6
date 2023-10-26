package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class NumberTest {

    @Test
    void 동일한_위치의_수는_1개() {
        // given
        List<Integer> list1 = new ArrayList<>(List.of(1, 2, 3));
        List<Integer> list2 = new ArrayList<>(List.of(5, 1, 3));

        Number number1 = new Number(list1);
        Number number2 = new Number(list2);

        // when
        int samePositionCount = number1.getSamePositionCount(number2);

        // then
        assertThat(samePositionCount).isEqualTo(1);
    }

    @Test
    void 동일한_위치를_제외한_다른_번호와_동일한_수는_1개() {
        // given
        List<Integer> list1 = new ArrayList<>(List.of(1, 2, 3));
        List<Integer> list2 = new ArrayList<>(List.of(5, 1, 3));

        Number number1 = new Number(list1);
        Number number2 = new Number(list2);

        // when
        int containNumberCount = number1.getContainNumberCount(number2);

        // then
        assertThat(containNumberCount).isEqualTo(1);
    }

    @Test
    void 생성된_번호_범위_예외_테스트() {
        // given
        List<Integer> list1 = new ArrayList<>(List.of(1, 2, 3, 4));

        // then
        assertThatThrownBy(() -> new Number(list1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 생성된_번호_중복_예외_테스트() {
        // given
        List<Integer> list1 = new ArrayList<>(List.of(1, 3, 3));

        // then
        assertThatThrownBy(() -> new Number(list1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 생성된_번호_길이_예외_테스트() {
        // given
        List<Integer> list1 = new ArrayList<>(List.of(1, 2, 3, 4));

        // then
        assertThatThrownBy(() -> new Number(list1)).isInstanceOf(IllegalArgumentException.class);
    }
}