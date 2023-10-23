package baseball;

import baseball.validation.GameValidation;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest extends NsTest {
    private final int input_length = 3;
    @Test
    void 사용자_게임_입력_값_빈_문자열_예외_테스트(){
        //given
        String input_value="";

        //when
        assertThatThrownBy(()->GameValidation.verifyForGameValue(input_value,input_length))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[Err] 입력 값이 빈 문자열입니다.");
    }

    @Test
    void 사용자_게임_입력_값_문자열_길이_예외_테스트(){
        //given
        String input_value = "1234";

        //when
        assertThatThrownBy(()->GameValidation.verifyForGameValue(input_value,input_length))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[Err] 입력 값의 길이가 초과 또는 부족입니다.");
    }

    @Test
    void 사용자_게임_입력_값_공백_예외_테스트(){
        //given
        String input_value = "1 3";

        //when
        assertThatThrownBy(()->GameValidation.verifyForGameValue(input_value,input_length))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[Err] 입력 값에 공백이 포함되어 있습니다.");
    }

    @Test
    void 사용자_게임_입력_값_숫자가_아닐경우_예외_테스트(){
        //given
        String input_value = "12a";

        //when
        assertThatThrownBy(()->GameValidation.verifyForGameValue(input_value,input_length))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[Err] 입력 값이 숫자가 아닙니다.");
    }

    @ParameterizedTest
    @DisplayName("사용자 게임 입력 값 예외 통합 테스트")
    @ValueSource(strings = {"1234","12","1 3","12a","222","012",""})
    void 사용자_게임_입력_값_예외_통합_테스트(String input_value){
        assertThatThrownBy(()->GameValidation.verifyForRetryValue(input_value,input_length))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[Err]");
    }

    @ParameterizedTest
    @DisplayName("사용자 게임 재도전 여부 입력 값 예외 통합 테스트")
    @ValueSource(strings = {"3","12",""," ","a"})
    void 사용자_게임_재도전_여부_입력_값_예외_통합_테스트(String input_retry){
        assertThatThrownBy(()->GameValidation.verifyForRetryValue(input_retry,input_length))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[Err]");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
