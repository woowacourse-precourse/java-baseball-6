package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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


}