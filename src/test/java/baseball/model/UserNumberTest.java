package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserNumberTest {

    @Test
    @DisplayName("중복된 숫자가 존재하여 exception 발생")
    void 숫자_중복_확인() throws Exception {
        //given
        String input = "122";
        //when

        //then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new UserNumber(input))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    @DisplayName("문자열에 숫자가 아닌 값이 존재하여 exception 발생")
    void 문자열_형식_확인() throws Exception {
        //given
        String input = "a12";
        //when

        //then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new UserNumber(input))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    @DisplayName("문자열에 0이 존재하여 exception 발생")
    void 문자열_0_포함_확인() throws Exception {
        //given
        String input = "012";
        //when

        //then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new UserNumber(input))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    @DisplayName("문자열의 길이가 맞지 않아 exception 발생")
    void 문자열_길이_확인() throws Exception {
        //given
        String input1 = "1234";
        String input2 = "12";
        //when

        //then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new UserNumber(input1))
                        .isInstanceOf(IllegalArgumentException.class));

        assertSimpleTest(() ->
                assertThatThrownBy(() -> new UserNumber(input2))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    @DisplayName("유저 숫자 생성 완료")
    void 유저숫자_생성_확인() throws Exception {
        //given
        String input1 = "123";
        String input2 = "456";
        String input3 = "789";
        //when
        List<Integer> userNumber1 = new UserNumber(input1).getNumber();
        List<Integer> userNumber2 = new UserNumber(input2).getNumber();
        List<Integer> userNumber3 = new UserNumber(input3).getNumber();
        //then
        assertThat(userNumber1).isEqualTo(List.of(1, 2, 3));
        assertThat(userNumber2).isEqualTo(List.of(4, 5, 6));
        assertThat(userNumber3).isEqualTo(new ArrayList<>(Arrays.asList(7, 8, 9)));
    }

}