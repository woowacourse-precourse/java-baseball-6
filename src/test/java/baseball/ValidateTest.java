package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidateTest {

    Validate validate = Validate.getInstance();

    @Test
    public void 입력_3개_이상_숫자() throws Exception {
        //given
        String[] input = {"1", "2", "3", "4"};
        //when
        Assertions.assertThatThrownBy(
                        () ->
                                validate.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
        //then
    }

    @Test
    public void 동일한_숫자_입력() throws Exception {
        //given
        Set<Integer> input = new HashSet<>(Arrays.asList(1, 2, 2));
        //when
        Assertions.assertThatThrownBy(
                        () ->
                                validate.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
        //then
    }

    @Test
    public void 숫자_이외의_입력() throws Exception {
        //given
        //when
        Assertions.assertThatThrownBy(
                        () ->
                                validate.validate("a"))
                .isInstanceOf(IllegalArgumentException.class);
        //then
    }

    @Test
    public void 재시작_숫자_이외의_입력() throws Exception {
        //given
        //when
        Assertions.assertThatThrownBy(
                        () ->
                                validate.validate(3))
                .isInstanceOf(IllegalArgumentException.class);
        //then
    }

}
