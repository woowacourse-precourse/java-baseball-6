package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class NumberConverterTest {
    @Test
    void 사용자가_입력한_글자의_수가_3개인지_확인한다() {
        assertThat(NumberConverter.from("123"))
                .isEqualTo(List.of(1, 2, 3));
    }

    @Test
    void 사용자가_문자를_입력한_경우_예외를_발생시킨다() {
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                NumberConverter.from("일23"));
        assertEquals(e.getMessage(), "문자가 아닌 숫자를 입력해주세요");
    }

    @Test
    void 사용자가_입력한_숫자의_수가_3개_이하일_경우_예외를_발생시킨다() {
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                NumberConverter.from("1"));
        assertEquals(e.getMessage(), "1부터 9까지 3개의 숫자를 입력해주세요");
    }
}