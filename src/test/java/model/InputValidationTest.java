package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


public class InputValidationTest {

    @Test
    void 예외처리_테스트(){
        //given
        List<Integer> number = List.of(1,2,3,4);
        InputValidation iv = new InputValidation();
        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> iv.validation(number));
        //then
        assertThat(e.getMessage()).isEqualTo("3자리 수를 입력해야합니다.");

    }
}
