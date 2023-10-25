package baseball.view;

import baseball.constant.errormessage.PlayerInputError;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    /**
     * 정답으로 유추되는 수를 문자열로 입력하고, 입력값을 검증 후 List<Integer> 형식으로 변환
     *
     * @return : 입력한 수를 List<Integer> 형식으로 반환
     * @func validatePlayerInputIsNumber(numbers) : 입력값에 수가 아닌 문자가 포함되어 있으면 예외 발생
     */
    public List<Integer> generateInputList() {
        System.out.print(INPUT_MESSAGE);
        String numbers = Console.readLine();
        validatePlayerInputIsNumber(numbers);
        return numberInput(numbers);
    }

    /**
     * 사용자로부터 입력받은 문자열을 List<Integer>로 변환시킴
     *
     * @param numbers : 사용자로부터 입력받은 문자열
     * @return : 입력받은 수를 List<Integer> 형식으로 반환
     */
    private List<Integer> numberInput(String numbers) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length(); ++i) {
            list.add(Integer.parseInt(String.valueOf(numbers.charAt(i))));
        }
        return list;
    }

    /**
     * 입력한 문자열 내의 문자가 1~9 사이의 수가 아닌 문자가 포함되어 있으면 예외처리
     *
     * @param numbers : 사용자로부터 입력받은 문자열
     */
    private void validatePlayerInputIsNumber(String numbers) {
        for (int i = 0; i < numbers.length(); ++i) {
            if (numbers.charAt(i) < 49 || numbers.charAt(i) > 57) {
                throw new IllegalArgumentException(PlayerInputError.PLAYER_NUMBER_WRONG_INPUT_NOT_INTEGER_MESSAGE);
            }
        }
    }
}
