package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BaseballGameNumbersTest {

    @DisplayName("숫자 야구 번호 생성시 정상적인 숫자가 입력되면 예외를 발생시키지 않는다.")
    @Test
    void normalTest() {
        //given
        //when
        BaseballGameNumbers baseballGameNumbers = BaseballGameNumbers.of(List.of(1, 2, 3));
        //then
        assertThat(baseballGameNumbers).isNotNull()
                .hasFieldOrPropertyWithValue("numbers", List.of(1, 2, 3));
    }

    @DisplayName("숫자 야구 번호 생성시 3자리가 아니면 예외를 발생시킨다.")
    @Test
    void exceptionSize() {
        //given
        //when
        //then
        assertThatThrownBy(() -> BaseballGameNumbers.of(List.of(1, 2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자 3개만 입력 가능합니다.");
    }

    @DisplayName("숫자 야구 번호 생성시 1~9가 아니면 예외를 발생시킨다.")
    @Test
    void exceptionRange() {
        //given
        //when
        //then
        assertThatThrownBy(() -> BaseballGameNumbers.of(List.of(1, 2, 10)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자 1부터 9까지만 입력 가능합니다.");
    }

    @DisplayName("숫자 야구 번호 생성시 중복된 숫자가 있으면 예외를 발생시킨다.")
    @Test
    void exceptionDistinct() {
        //given
        //when
        //then
        assertThatThrownBy(() -> BaseballGameNumbers.of(List.of(1, 2, 2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 중복하지 않게 입력해주세요.");
    }

    @DisplayName("숫자 야구 번호 생성시 정상적인 숫자가 입력되면 예외를 발생시키지 않는다.")
    @Test
    void normalTest2() {
        //given
        //when
        BaseballGameNumbers baseballGameNumbers = BaseballGameNumbers.of(List.of(1, 2, 3));
        //then
        assertThat(baseballGameNumbers).isNotNull()
                .hasFieldOrPropertyWithValue("numbers", List.of(1, 2, 3));
    }

    @DisplayName("[1, 2, 3]일 때 [1, 3, 2]이면 볼 2개를 반환한다.")
    @Test
    void countBall() {
        //given
        //when
        BaseballGameNumbers baseballGameNumbers = BaseballGameNumbers.of(List.of(1, 2, 3));
        BaseballGameNumbers opponent = BaseballGameNumbers.of(List.of(1, 3, 2));
        //then
        assertThat(baseballGameNumbers.countBall(opponent)).isEqualTo(2);
    }

    @DisplayName("[1, 2, 3]일 때 [1, 3, 2]이면 스트라이크 1개를 반환한다.")
    @Test
    void countStrike() {
        //given
        //when
        BaseballGameNumbers baseballGameNumbers = BaseballGameNumbers.of(List.of(1, 2, 3));
        BaseballGameNumbers opponent = BaseballGameNumbers.of(List.of(1, 3, 2));
        //then
        assertThat(baseballGameNumbers.countStrike(opponent)).isEqualTo(1);
    }
}