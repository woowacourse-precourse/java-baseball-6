package baseball.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PlayerValidationTest {
    @Test
    @DisplayName("입력받은 값이 문자인지 확인")
    public void isNotNumber() throws Exception{
        //given (주어진 값)
        String number = "aaa";

        //than (기능 작동 후 결과)
        Assertions.assertThrows(IllegalArgumentException.class, () -> PlayerValidation.isCheckedNumber(number));
    }

    @Test
    @DisplayName("입력받은 값의 크기가 3이 아닐때")
    public void isNotNumberSize() throws Exception{
        //given (주어진 값)
        String number = "1234";
        int size = 3;

        //than (기능 작동 후 결과)
        Assertions.assertThrows(IllegalArgumentException.class, () -> PlayerValidation.isCheckedSize(number,size));
    }

    @Test
    @DisplayName("중복이 있을 경우")
    public void isDuplication() throws Exception{
        //given (주어진 값)
        String number = "112";

        //than (기능 작동 후 결과)
        Assertions.assertThrows(IllegalArgumentException.class, () -> PlayerValidation.isDifferentNumbers(number));
    }

    @Test
    @DisplayName("중복이 없을경우")
    public void isNotDuplication() throws Exception{
        //given (주어진 값)
        String number = "123";
        List<Integer> listNumber = new ArrayList<>(Arrays.asList(1, 2, 3));

        //when (기능 작동)
        List<Integer> numbers = PlayerValidation.isDifferentNumbers(number);

        //then (기능 작동 후 결과)
        org.assertj.core.api.Assertions.assertThat(numbers).isEqualTo(listNumber);
    }

    @Test
    @DisplayName("입력받은 값이 1 혹은 2가 아닐경우")
    public void isNotCheckOneOrTwo() throws Exception{
        //given (주어진 값)
        String number = "3";

        //then (기능 작동 후 결과)
        assertThrows(IllegalArgumentException.class, () -> PlayerValidation.isCheckedOneOrTwo(number));
    }
}