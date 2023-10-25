package baseball.domain;

import baseball.constant.Constant;
import baseball.constant.errormessage.PlayerInputError;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    /**
     * 입력한 문자열에 중복되는 문자가 포함되어있는 경우 예외 발생
     *
     * @param playerNumbers : 랜덤으로 생성한 컴퓨터가 가진 수
     */
    private void validateDuplicate(List<Integer> playerNumbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(playerNumbers);
        if (nonDuplicateNumbers.size() != Constant.GAME_NUMBERS_SIZE) {
            throw new IllegalArgumentException(PlayerInputError.PLAYER_NUMBER_WRONG_INPUT_DUPLICATE_MESSAGE);
        }
    }
}
