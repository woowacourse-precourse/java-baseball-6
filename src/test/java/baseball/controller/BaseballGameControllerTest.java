package baseball.controller;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGameControllerTest {

    BaseballGameController baseballGameController = new BaseballGameController();

    @Test
    @DisplayName("입력값 범위 검증 메서드 테스트")
    public void isVerifiedTest() {
        //given
        int userInput1;
        int userInput2;

        //when
        userInput1 = Randoms.pickNumberInRange(1, 99);
        userInput2 = Randoms.pickNumberInRange(1000, Integer.MAX_VALUE - 1); // pickNumberInRange에서 Integer_MAX값이 전달되면 예외처리 해버리므로 -1 해줌

        //then
        Assertions.assertThatThrownBy(() -> {
            baseballGameController.isVerified(userInput1);
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> {
            baseballGameController.isVerified(userInput2);
        }).isInstanceOf(IllegalArgumentException.class);


    }
}
