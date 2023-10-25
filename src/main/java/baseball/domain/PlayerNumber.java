package baseball.domain;

import baseball.constant.Constant;
import baseball.constant.errormessage.PlayerInputError;
import java.util.List;

public class PlayerNumber {

    /**
     * 입력한 문자열의 길이가 3이 아닌 경우 예외 발생
     *
     * @param playerNumbers : 랜덤으로 생성한 컴퓨터가 가진 수
     */
    private void validateSize(List<Integer> playerNumbers) {
        if (playerNumbers.size() != Constant.GAME_NUMBERS_SIZE) {
            throw new IllegalArgumentException(PlayerInputError.PLAYER_NUMBER_WRONG_INPUT_SIZE_MESSAGE);
        }
    }
}
