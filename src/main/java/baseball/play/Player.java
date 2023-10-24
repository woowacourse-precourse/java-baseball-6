package baseball.play;

import static baseball.util.Constant.DUP_NUM_ERR;
import static baseball.util.Constant.INPUT_MSG;
import static baseball.util.Constant.LENGTH_OF_NUMBERS;
import static baseball.util.Constant.MAX_NUM;
import static baseball.util.Constant.MIN_NUM;
import static baseball.util.Constant.NUM_ERR_MSG;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> numbers;

    public Player() {
        numbers = new ArrayList<>();
    }

    /* API 사용하여 사용자 숫자 입력받기 */
    public void inputUserNumber() {
        System.out.print(INPUT_MSG);
        String input = Console.readLine();
        validateUserInput(input);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    /* 사용자가 입력한 숫자가 유효한지 테스트 후 오류메시지 출력 */
    private void validateUserInput(String input) {
        if (input.length() != LENGTH_OF_NUMBERS) {
            throw new IllegalArgumentException(NUM_ERR_MSG);
        }

        List<Integer> newNumbers = new ArrayList<>();
        for (int i = 0; i < LENGTH_OF_NUMBERS; i++) {
            char digitChar = input.charAt(i);
            int digit = Character.getNumericValue(digitChar);

            if (!isValidDigit(digit, newNumbers)) {
                throw new IllegalArgumentException(DUP_NUM_ERR);
            }

            newNumbers.add(digit);
        }

        numbers = newNumbers;
    }

    /* 숫자 범위 지정 */
    private boolean isValidDigit(int digit, List<Integer> newNumbers) {
        return digit >= MIN_NUM && digit <= MAX_NUM && !newNumbers.contains(digit);
    }
}
