package baseball;

import baseball.core.CompareNumber;
import baseball.validation.GameValidation;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    void 사용자_게임_입력_값_중복인_경우_예외_테스트(){
        //given
        String input_value = "122";

        //when
        assertThatThrownBy(()->GameValidation.verifyForGameValue(input_value,input_length))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[Err] 입력 값이 중복되었습니다. 중복되지 않은값을 입력하여 주세요.");
    }

    @Test
    void 사용자_게임_입력_값_0부터_9사이의_값이_아닌_경우_예외_테스트(){
        //given
        String input_value = "089";

        //when
        assertThatThrownBy(()->GameValidation.verifyForGameValue(input_value,input_length))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[Err] 입력 값은 1부터 9사이의 숫자여야합니다.");
    }

    @Test
    void 사용자_재도전_입력_값_1또는_2의_값이_아닌_경우_예외_테스트(){
        //given
        String input_value = "3";
        int user_input_retry = 1;

        //when
        assertThatThrownBy(()->GameValidation.verifyForRetryValue(input_value,user_input_retry))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[Err] 게임을 새로시작 혹은 종료하기 위해선 1 또는 2 값을 입력하여야합니다.");
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

    @Test
    void 사용자_게임_입력값_검증_통과_테스트(){
        //given
        String user_input_value = "123";

        //when
        boolean verify_result = GameValidation.verifyForGameValue(user_input_value,input_length);

        //then
        assertThat(verify_result).isTrue();
    }

    @Test
    void 사용자_재도전_입력값_검증_통과_테스트(){
        //given
        String user_input_value = "2";
        int user_input_retry = 1;

        //when
        boolean verify_result = GameValidation.verifyForRetryValue(user_input_value,user_input_retry);

        //then
        assertThat(verify_result).isTrue();
    }

    @Test
    void 사용자_입력_리스트_컴퓨터_리스트_개수_비교_예외_테스트(){
        //given
        List<Integer> user = List.of(1, 2, 3);
        List<Integer> computer = List.of(1, 2, 3, 4);

        //when
        assertThatThrownBy(()->CompareNumber.compareNumberList(user,computer))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[Err] 유저 입력값과 컴퓨터 생성의 수의 개수가 다릅니다.");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
