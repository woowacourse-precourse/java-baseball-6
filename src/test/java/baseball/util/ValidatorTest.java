package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
class ValidatorTest {

    @Test
    @DisplayName("공백(space) 없애지는지에 대해 테스트")
    void 공백이_잘_없어지냐() throws Exception {
        //given
        String inputNum = "1234 5678";
        //when
        String afterInputNum = Validator.removeSpace(inputNum);
        //then
        assertThat(afterInputNum).isEqualTo("12345678");
    }

    @Test
    @DisplayName("공백이 입력된 경우 Illegal예외를 잘 던지는지에 대한 테스트")
    void 공백인_경우_Illegal_던지냐() throws Exception {
        //given
        String inputNum = "";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validator.validateEmptyInput(inputNum));
    }

    @Test
    @DisplayName("제대로 입력이 된 경우 Illegal예외를 던지지 않는지에 대한 테스트")
    void 정상값인_경우_Illegal_안던지냐() throws Exception {
        //given
        String inputNum = "123";
        //when
        //then
        assertThatNoException()
                .isThrownBy(() -> Validator.validateEmptyInput(inputNum));
    }
}