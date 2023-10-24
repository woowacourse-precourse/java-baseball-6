package study;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import baseball.constant.MessageConstant;
import baseball.utils.Utils;
import baseball.utils.Validator;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StudyTest {

    @DisplayName("공백 입력 테스트")
    @Test
    void 예외_테스트_공백_입력() {
        //given
        final Validator validator = new Validator();

        //when
        String playerInput1 = "123";
        String playerInput2 = " ";
        String playerInput3 = "  ";

        //then
        assertThatCode(() ->
                validator.checkInputForNonBlank(playerInput1))
                .doesNotThrowAnyException();
        assertThatThrownBy(() ->
                validator.checkInputForNonBlank(playerInput2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MessageConstant.BLANK_EXCEPTION_MSG);
        assertThatThrownBy(() ->
                validator.checkInputForNonBlank(playerInput3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MessageConstant.BLANK_EXCEPTION_MSG);
    }

    @DisplayName("숫자가 아닌 문자 입력 테스트")
    @Test
    void 예외_테스트_문자_입력() {
        //given
        final Validator validator = new Validator();

        //when
        String playerInput1 = "123";
        String playerInput2 = "1a3";

        //then
        assertThatCode(() ->
                validator.checkInputOfDigit(playerInput1))
                .doesNotThrowAnyException();
        assertThatThrownBy(() ->
                validator.checkInputOfDigit(playerInput2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MessageConstant.NON_DIGIT_EXCEPTION_MSG);
    }

    @DisplayName("입력 길이 테스트")
    @Test
    void 예외_테스트_입력_길이() {
        //given
        final Validator validator = new Validator();
        List<Integer> playerCorrectInput = new ArrayList<>();
        List<Integer> playerWrongInput = new ArrayList<>();

        //when
        playerCorrectInput.add(1);
        playerCorrectInput.add(2);
        playerCorrectInput.add(3);

        playerWrongInput.add(1);
        playerWrongInput.add(2);
        playerWrongInput.add(3);
        playerWrongInput.add(4);

        //then
        assertThatCode(() ->
                validator.checkListLengthThree(playerCorrectInput))
                .doesNotThrowAnyException();
        assertThatThrownBy(() ->
                validator.checkListLengthThree(playerWrongInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MessageConstant.INPUT_LENGTH_EXCEPTION_MSG);
    }

    @DisplayName("입력값의 범위 테스트")
    @Test
    void 예외_테스트_입력값_범위() {
        //given
        final Validator validator = new Validator();
        List<Integer> playerCorrectInput = new ArrayList<>();
        List<Integer> playerWrongInput = new ArrayList<>();

        //when
        playerCorrectInput.add(1);
        playerCorrectInput.add(2);
        playerCorrectInput.add(3);

        playerWrongInput.add(0);
        playerWrongInput.add(2);
        playerWrongInput.add(3);

        //then
        assertThatCode(() ->
                validator.checkDigitInRange(playerCorrectInput))
                .doesNotThrowAnyException();
        assertThatThrownBy(() ->
                validator.checkDigitInRange(playerWrongInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MessageConstant.NUMBER_RANGE_EXCEPTION_MSG);
    }

    @DisplayName("입력값에서 중복값 확인 테스트")
    @Test
    void 예외_테스트_중복값() {
        //given
        final Validator validator = new Validator();
        List<Integer> playerCorrectInput = new ArrayList<>();
        List<Integer> playerWrongInput = new ArrayList<>();

        //when
        playerCorrectInput.add(1);
        playerCorrectInput.add(2);
        playerCorrectInput.add(3);

        playerWrongInput.add(1);
        playerWrongInput.add(1);
        playerWrongInput.add(3);

        //then
        assertThatCode(() ->
                validator.checkDuplicateInList(playerCorrectInput))
                .doesNotThrowAnyException();
        assertThatThrownBy(() ->
                validator.checkDuplicateInList(playerWrongInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MessageConstant.NUMBER_DUPLICATE_EXCEPTION_MSG);
    }

    @DisplayName("재시작 혹은 종료 숫자 테스트")
    @Test
    void 예외_테스트_재시작_종료_숫자() {
        //given
        final Validator validator = new Validator();

        //when
        String playerInput1 = "1";
        String playerInput2 = "2";
        String playerInput3 = "3";

        //then
        assertThatCode(() ->
                validator.validateRestartOrExitNumber(playerInput1))
                .doesNotThrowAnyException();
        assertThatCode(() ->
                validator.validateRestartOrExitNumber(playerInput2))
                .doesNotThrowAnyException();
        assertThatThrownBy(() ->
                validator.validateRestartOrExitNumber(playerInput3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MessageConstant.INVALID_CHOICE_EXCEPTION_MSG);
    }

    @DisplayName("문자열을 정수형 리스트로 변환 테스트")
    @Test
    void 문자열을_정수형_리스토로_변환() {
        //given
        String input1 = "123";
        String input2 = "456";

        //when
        List<Integer> result1 = Utils.convertStringToIntList(input1);
        List<Integer> result2 = Utils.convertStringToIntList(input2);

        //then
        assertThat(result1).isEqualTo(List.of(1, 2, 3));
        assertThat(result2).isEqualTo(List.of(4, 5, 6));
    }
}
