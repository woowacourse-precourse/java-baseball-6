package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("숫자 일급 컬렉션의 객체에")
class NumbersTest {

    @Test
    @DisplayName("인덱스에 해당하는 값 요청시 그에 맞는 값을 반환하는가")
    void getByIndex() {
        // given
        final Numbers numbers = new Numbers(List.of(1, 2, 3));

        // when
        final Number result = numbers.getByIndex(0);

        // then
        Assertions.assertThat(result).isEqualTo(new Number(1));
    }

    @Test
    @DisplayName("")
    void contains() {}

    @Test
    @DisplayName("")
    void hasSameIndexAndValue() {}
}
