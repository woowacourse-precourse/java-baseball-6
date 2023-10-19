package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class UserTest {

    @Test
    void 입력길이가_3이_아닌_경우() {
        //given
        User user = new User();

        //when,then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.validateLength("2356");
        });
    }

    @Test
    void 입력길이가_3인_경우() {
        //given
        User user = new User();

        //when,then
        user.validateLength("235");

    }

    @Test
    void 입력에_중복_값이_있는_경우(){
        //given
        User user = new User();

        //when,then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.validateDuplicated("233");
        });
    }

    @Test
    void 입력에_중복_값이_없는_경우(){
        //given
        User user = new User();

        //when,then
        user.validateDuplicated("1234567890");
    }

    @Test
    void 입력에_0이_포함된_경우(){
        //given
        User user = new User();

        //when,then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.validateIncludedZreo("203");
        });
    }

    @Test
    void 입력에_0이_포함되지_않은_경우(){
        //given
        User user = new User();

        //when,then
        user.validateIncludedZreo("2333");
    }

    @Test
    void 숫자가_아닌_것이_포함된_경우(){
        //given
        User user = new User();

        //when,then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.validtaeNumeric("-203");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.validtaeNumeric("-2asd3");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.validtaeNumeric("303");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.validtaeNumeric("em3");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.validtaeNumeric("0.3");
        });
    }

    @Test
    void 숫자만_포함된_경우(){
        //given
        User user = new User();

        //when,then
       Assertions.assertEquals(List.of(2,3,3),user.validtaeNumeric("233"));
    }
}