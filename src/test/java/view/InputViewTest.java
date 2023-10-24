package view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @Test
    @DisplayName("숫자 외의 다른 문자 확인 테스트")
    public void checkOnlyNumberTest() throws Exception {
        //given
        String userInput = "123";
        //when
        boolean checkOnlyNumber = userInput.matches("^[1-9]{3}$");
        //then
        Assertions.assertThat(checkOnlyNumber).isEqualTo(true);
    }

}