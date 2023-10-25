package baseball.domain;

import baseball.constant.Constant;
import baseball.constant.errormessage.ComputerInputError;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComputerNumber {

    /**
     * 랜덤으로 생성한 숫자 배열의 길이가 3이 아닌 경우 예외 발생
     *
     * @param computerNumbers : 랜덤으로 생성한 컴퓨터가 가진 수
     */
    private void validateSize(List<Integer> computerNumbers) {
        if (computerNumbers.size() != Constant.GAME_NUMBERS_SIZE) {
            throw new IllegalArgumentException(ComputerInputError.COMPUTER_NUMBER_WRONG_INPUT_SIZE_MESSAGE);
        }
    }

    /**
     * 랜덤으로 생성한 숫자 배열에 중복되는 수가 있는 경우 예외 발생
     *
     * @param computerNumbers : 랜덤으로 생성한 컴퓨터가 가진 수
     */
    private void validateDuplicate(List<Integer> computerNumbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(computerNumbers);
        if (nonDuplicateNumbers.size() != Constant.GAME_NUMBERS_SIZE) {
            throw new IllegalArgumentException(ComputerInputError.COMPUTER_NUMBER_WRONG_INPUT_DUPLICATE_MESSAGE);
        }
    }

    /**
     * 랜덤으로 생성한 문자열에 1~9 사이의 수가 아닌 값이 포함된 경우 예외 발생
     *
     * @param computerNumbers : 랜덤으로 생성한 컴퓨터가 가진 수
     */
    private void validatePlayerInputRange(List<Integer> computerNumbers) {
        if (computerNumbers.stream()
                .anyMatch(number -> Constant.START_RANGE > number || number > Constant.END_RANGE)) {
            throw new IllegalArgumentException(ComputerInputError.COMPUTER_NUMBER_WRONG_INPUT_RANGE_MESSAGE);
        }
    }
}
