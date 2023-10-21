package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class UserTest {


    @Test
    @DisplayName("입력 값 테스트 - 성공")
    public void readBaseballNumberSuccess() {
        //given
        User user = new User();
        String inputBaseballNumber = "123";

        //when
        System.setIn(new ByteArrayInputStream(inputBaseballNumber.getBytes()));
        user.readBaseballNumber();

        //then
        Assertions.assertThat(inputBaseballNumber).isEqualTo(user.getBaseballNumberList());
    }
}