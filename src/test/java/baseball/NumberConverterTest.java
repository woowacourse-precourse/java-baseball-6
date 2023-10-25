package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class NumberConverterTest {
    @Test
    void 문자열을_Integer_리스트로_반환한다() {
        assertThat(NumberConverter.from("123"))
                .isEqualTo(List.of(1, 2, 3));
    }

    @Test
    void 문자인_경우_예외를_발생시킨다() {
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                NumberConverter.from("일23"));
        assertEquals(e.getMessage(), "문자가 아닌 숫자를 입력해주세요");
    }

    @Test
    void 숫자의_수가_3개_이하일_경우_예외를_발생시킨다() {
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                NumberConverter.from("1"));
        assertEquals(e.getMessage(), "1부터 9까지 3개의 숫자를 입력해주세요");
    }

    @Test
    void 숫자가_0을_포함할_경우_예외를_발생시킨다() {
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                NumberConverter.from("012"));
        assertEquals(e.getMessage(), "1부터 9까지 3개의 숫자를 입력해주세요");
    }

    @Test
    void 중복되는_숫자가_존재할_경우_예외를_발생시킨다() {
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                NumberConverter.from("112"));
        assertEquals(e.getMessage(), "서로 다른 숫자들을 입력해주세요");
    }
}