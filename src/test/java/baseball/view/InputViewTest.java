package baseball.view;

import baseball.error.ErrorException;
import baseball.error.GameInputErrorException;
import baseball.error.RetryInpurErrorException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class InputViewTest {
    @Test
    void 숫자_야구_게임의_입력한_값이_유효한_값인지_검사_기능_테스트(){
        //given
        ErrorException errorException = new GameInputErrorException();
        final String case1 = "123"; //유효
        final String case2 = "dsa"; //숫자가 아님
        final String case3 = "1234"; // 3자릿 수가 아님
        final String case4 = "012"; // 1~9 범위가 아님
        final String case5 = "444"; // 중복 숫자
        final String IS_NOT_NUMERIC_MESSAGE = "숫자만 입력이 가능합니다. 애플리케이션을 종료합니다.";
        final String IS_NOT_THREE_DIGITS_MESSAGE = "3자리 숫자만 입력 가능합니다. 애플리케이션을 종료합니다.";
        final String IS_NOT_VALID_RANGE_MESSAGE = "각 자릿 숫자는 1~9의 숫자만 입력 가능합니다. 애플리케이션을 종료합니다.";
        final String EXIST_DUPLICATE_NUMBER = "각 자리에 서로 다른 숫자를 입력해야 합니다. 애플리케이션을 종료합니다.";

        //when
        errorException.checkUserInputValidate(case1);
        Throwable throwable1 = catchThrowable(() -> {
            errorException.checkUserInputValidate(case2);
        });
        Throwable throwable2 = catchThrowable(() -> {
            errorException.checkUserInputValidate(case3);
        });
        Throwable throwable3 = catchThrowable(() -> {
            errorException.checkUserInputValidate(case4);
        });
        Throwable throwable4 = catchThrowable(() -> {
            errorException.checkUserInputValidate(case5);
        });

        //then
        assertThat(throwable1).isInstanceOf(IllegalArgumentException.class).hasMessage(IS_NOT_NUMERIC_MESSAGE);
        assertThat(throwable2).isInstanceOf(IllegalArgumentException.class).hasMessage(IS_NOT_THREE_DIGITS_MESSAGE);
        assertThat(throwable3).isInstanceOf(IllegalArgumentException.class).hasMessage(IS_NOT_VALID_RANGE_MESSAGE);
        assertThat(throwable4).isInstanceOf(IllegalArgumentException.class).hasMessage(EXIST_DUPLICATE_NUMBER);
    }

    @Test
    void 게임_끝난_경우_재시작_종료_입력_값_유효한_지_검사_테스트(){
        //given
        ErrorException errorException = new RetryInpurErrorException();
        final String IS_NOT_NUMERIC_MESSAGE = "숫자만 입력이 가능합니다. 애플리케이션을 종료합니다.";
        final String IS_NOT_ONE_OR_TWO_MESSAGE = "1이나 2만 입력이 가능합니다. 애플리케이션을 종료합니다.";
        final String case1 = "1";
        final String case2 = "2";
        final String case3 = "123";
        final String case4 = "x";

        //when
        errorException.checkUserInputValidate(case1);
        errorException.checkUserInputValidate(case2);
        Throwable throwable1 = catchThrowable(() -> {
            errorException.checkUserInputValidate(case3);
        });
        Throwable throwable2 = catchThrowable(() -> {
            errorException.checkUserInputValidate(case4);
        });

        //then
        assertThat(throwable1).isInstanceOf(IllegalArgumentException.class).hasMessage(IS_NOT_ONE_OR_TWO_MESSAGE);
        assertThat(throwable2).isInstanceOf(IllegalArgumentException.class).hasMessage(IS_NOT_NUMERIC_MESSAGE);
    }
}