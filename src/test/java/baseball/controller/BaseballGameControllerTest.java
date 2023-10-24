package baseball.controller;

import baseball.model.UserNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballGameControllerTest {
    @Test
    @DisplayName("입력값 중복, 사이즈 검증 메서드 테스트")
    public void isVerifiedTest() {
        //given
        int input1;
        int input2;

        //when
        input1 = 121;
        input2 = 2349;

        //then
        Assertions.assertThatThrownBy(() -> {
            new UserNumber(input1);
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> {
            new UserNumber(input2);
        }).isInstanceOf(IllegalArgumentException.class);

    }
}
