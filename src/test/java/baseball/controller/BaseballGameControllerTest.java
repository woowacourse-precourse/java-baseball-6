package baseball.controller;


import baseball.model.BaseballGameUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;

public class BaseballGameControllerTest {

    BaseballGameController baseballGameController = new BaseballGameController();
    BaseballGameUtils baseballGameUtils = new BaseballGameUtils();

    @Test
    @DisplayName("입력값 중복, 사이즈 검증 메서드 테스트")
    public void isVerifiedTest() {
        //given
        List<Integer> tempNumber1 = new ArrayList<>();
        List<Integer> tempNumber2 = new ArrayList<>();


        //when
        tempNumber1.add(1);
        tempNumber1.add(2);
        tempNumber1.add(1);

        tempNumber2.add(2);
        tempNumber2.add(3);
        tempNumber2.add(4);
        tempNumber2.add(9);


        //then
        Assertions.assertThatThrownBy(() -> {
            baseballGameController.isVerified(tempNumber1);
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> {
            baseballGameController.isVerified(tempNumber2);
        }).isInstanceOf(IllegalArgumentException.class);

    }
}
