package baseball.service;

import baseball.domain.User;
import baseball.servcie.BaseballGameService;
import baseball.validation.BaseballGameValidation;
import baseball.view.BaseballGameView;
import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

class BaseballGameServiceTest {

    private final BaseballGameService baseballGameService;

    BaseballGameServiceTest() {
        this.baseballGameService = new BaseballGameService(new User(), new BaseballGameValidation(), new BaseballGameView());
    }


    @Test
    @DisplayName("재시작 시 입력 값 1 입력(True) - 성공")
    public void checkRestartTrueSuccess() {
        //given
        String checkString = "1";

        //when
        System.setIn(new ByteArrayInputStream(checkString.getBytes()));
        boolean checkContinue = baseballGameService.checkRestart();

        //then
        Assertions.assertThat(checkContinue).isTrue();


        Console.close();
    }

    @Test
    @DisplayName("재시작 시 입력 값 2 입력(False) - 성공")
    public void checkRestartFalseSuccess() {
        //given
        String checkString = "2";

        //when
        System.setIn(new ByteArrayInputStream(checkString.getBytes()));
        boolean checkContinue = baseballGameService.checkRestart();

        //then
        Assertions.assertThat(checkContinue).isFalse();


        Console.close();
    }

    @Test
    @DisplayName("재시작 시 입력 값 잘못 입력 - 실패")
    public void checkRestartFail() {
        //given
        String checkString = "123";

        //when
        System.setIn(new ByteArrayInputStream(checkString.getBytes()));

        //then
        Assertions.assertThatThrownBy(() -> baseballGameService.checkRestart())
                .isInstanceOf(IllegalArgumentException.class);


        Console.close();
    }
    
    @Test
    @DisplayName("유효성 검증 - 실패")
    public void validateFail() {
        //given
        User user = new User();
        String inputBaseballNumber = "333";
        System.setIn(new ByteArrayInputStream(inputBaseballNumber.getBytes()));

        List<Integer> baseballNumbers = List.of(2, 3);

        //when
        user.readBaseballNumber();

        //then
        Assertions.assertThatThrownBy(() -> baseballGameService.checkValidation(user, baseballNumbers))
                .isInstanceOf(IllegalArgumentException.class);

        Console.close();
    }
    
    
    @Test
    @DisplayName("값 비교 3스트라이크일 때 - True")
    public void compareNumberTrue() {
        //given
        List<Integer> userNumber = List.of(3, 7, 4);
        List<Integer> computerNumber = List.of(3, 7, 4);

        //when
        boolean checkStrike = baseballGameService.compareNumber(userNumber, computerNumber);

        //then
        Assertions.assertThat(checkStrike).isTrue();
        
    }

    @Test
    @DisplayName("값 비교 3스트라이크 아닐 때 - False")
    public void compareNumberFalse() {
        //given
        List<Integer> userNumber = List.of(3, 7, 4);
        List<Integer> computerNumber = List.of(3, 2, 7);

        //when
        boolean checkStrike = baseballGameService.compareNumber(userNumber, computerNumber);

        //then
        Assertions.assertThat(checkStrike).isFalse();

    }
}