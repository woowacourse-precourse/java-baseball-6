package baseball.util;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationTest {


    private final Validation validation = new Validation();


    @Test
    @DisplayName("초기 유저숫자 입력시 나는 오류 체크!")
    void validateNumber(){
        String user_number_wrong="12a";
        String user_number_has_zero = "120";
        String user_number_wrong_length="1234";
        String user_no_number="\n";

        Assertions.assertThatThrownBy(() -> validation.validateNumber(user_number_wrong)).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> validation.validateNumber(user_number_has_zero)).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> validation.validateNumber(user_number_wrong_length)).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> validation.validateNumber(user_no_number)).isInstanceOf(IllegalArgumentException.class);
    }


}