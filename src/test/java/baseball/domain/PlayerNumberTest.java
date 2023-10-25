package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import baseball.constant.Constant;
import baseball.constant.errormessage.PlayerInputError;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerNumberTest {

    /**
     * 플레이어가 입력한 숫자가 정상 입력인 경우
     */
    @Test
    void 플레이어_정상입력() {
        //given
        List<Integer> playerNumbers = Arrays.asList(3, 1, 8);

        //when
        PlayerNumber playerNumber = new PlayerNumber(playerNumbers);

        //then
        Assertions.assertThat(playerNumber.getPlayerNumbers().size()).isEqualTo(Constant.GAME_NUMBERS_SIZE);
    }

    /**
     * 플레이어가 입력한 숫자가 게임에서 사용되는 범위를 초과하여 입력된 경우
     */
    @Test
    void 플레이어_입력_크기초과_예외처리() {
        //given
        List<Integer> playerNumbers = Arrays.asList(3, 1, 8, 2);

        //when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new PlayerNumber(playerNumbers));

        // Then
        assertEquals(exception.getMessage(), PlayerInputError.PLAYER_NUMBER_WRONG_INPUT_SIZE_MESSAGE);
    }

    /**
     * 플레이어가 입력한 숫자가 게임에서 사용되는 범위보다 작게 입력된 경우
     */
    @Test
    void 플레이어_입력_크기미만_예외처리() {
        //given
        List<Integer> playerNumbers = Arrays.asList(3, 1);

        //when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new PlayerNumber(playerNumbers));

        // Then
        assertEquals(exception.getMessage(), PlayerInputError.PLAYER_NUMBER_WRONG_INPUT_SIZE_MESSAGE);
    }

    /**
     * 플레이어의 입력값에 중복되는 숫자가 있는 경우
     */
    @Test
    void 플레이어_입력_중복숫자_예외처리() {
        //given
        List<Integer> playerNumbers = Arrays.asList(3, 3, 8);

        //when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new PlayerNumber(playerNumbers));

        // Then
        assertEquals(exception.getMessage(), PlayerInputError.PLAYER_NUMBER_WRONG_INPUT_DUPLICATE_MESSAGE);
    }

    /**
     * 플레이어의 입력값에 1~9 사이값이 아닌 수가 입력된 경우
     */
    @Test
    void 랜덤수_입력_숫자범위_예외처리() {
        //given
        List<Integer> playerNumbers = Arrays.asList(22, -1, 0);

        //when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new PlayerNumber(playerNumbers));

        // Then
        assertEquals(exception.getMessage(), PlayerInputError.PLAYER_NUMBER_WRONG_INPUT_RANGE_MESSAGE);
    }
}