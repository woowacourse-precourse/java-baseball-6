package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import baseball.constant.Constant;
import baseball.constant.errormessage.ComputerInputError;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ComputerNumberTest {

    /**
     * 정답으로 처리될 컴퓨터가 가지는 랜덤 숫자가 정상 생성된 경우
     */
    @Test
    void 랜덤수_정상입력() {
        //given
        List<Integer> computerNumbers = Arrays.asList(3, 1, 8);

        //when
        ComputerNumber computerNumber = new ComputerNumber(computerNumbers);

        //then
        Assertions.assertThat(computerNumber.getComputerNumbers().size()).isEqualTo(Constant.GAME_NUMBERS_SIZE);
    }

    /**
     * 정답으로 처리될 컴퓨터가 가지는 랜덤 숫자가, 게임에서 사용되는 범위를 초과하여 생성된 경우
     */
    @Test
    void 랜덤수_리스트_크기초과_예외처리() {
        //given
        List<Integer> computerNumbers = Arrays.asList(3, 1, 8, 2);

        //when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new ComputerNumber(computerNumbers));

        // Then
        assertEquals(exception.getMessage(), ComputerInputError.COMPUTER_NUMBER_WRONG_INPUT_SIZE_MESSAGE);
    }

    /**
     * 정답으로 처리될 컴퓨터가 가지는 랜덤 숫자가, 게임에서 사용되는 범위보다 작게 생성된 경우
     */
    @Test
    void 랜덤수_입력_크기미만_예외처리() {
        //given
        List<Integer> computerNumbers = Arrays.asList(3, 1);

        //when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new ComputerNumber(computerNumbers));

        // Then
        assertEquals(exception.getMessage(), ComputerInputError.COMPUTER_NUMBER_WRONG_INPUT_SIZE_MESSAGE);
    }

    /**
     * 정답으로 처리될 컴퓨터가 가지는 랜덤 숫자가, 중복하여 저장된 경우
     */
    @Test
    void 랜덤수_리스트_중복숫자_예외처리() {
        //given
        List<Integer> computerNumbers = Arrays.asList(3, 3, 8);

        //when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new ComputerNumber(computerNumbers));

        // Then
        assertEquals(exception.getMessage(), ComputerInputError.COMPUTER_NUMBER_WRONG_INPUT_DUPLICATE_MESSAGE);
    }

    /**
     * 정답으로 처리될 컴퓨터가 가지는 랜덤 숫자가, 1~9 범위가 아닌 수가 포함된 경우
     */
    @Test
    void 랜덤수_리스트_숫자범위_예외처리() {
        //given
        List<Integer> computerNumbers = Arrays.asList(22, -1, 0);

        //when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new ComputerNumber(computerNumbers));

        // Then
        assertEquals(exception.getMessage(), ComputerInputError.COMPUTER_NUMBER_WRONG_INPUT_RANGE_MESSAGE);
    }
}