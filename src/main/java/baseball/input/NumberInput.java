package baseball.input;

import baseball.validation.BaseballInputValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자로부터 야구 게임에 사용될 숫자를 입력받는 클래스입니다.
 *
 * <p>해당 클래스는 사용자로부터 3자리의 야구 숫자를 입력받으며,
 * 입력된 숫자에 대한 유효성 검사를 {@link BaseballInputValidator}를 통해 수행합니다.</p>
 */
public class NumberInput implements Input<List<Integer>> {

    private final BaseballInputValidator validator;

    /**
     * 생성자에서 {@link BaseballInputValidator} 객체를 초기화합니다.
     */
    public NumberInput() {
        this.validator = new BaseballInputValidator();
    }

    /**
     * 사용자로부터 야구 숫자를 입력받고, 해당 입력에 대한 유효성 검사를 수행한 후 숫자 리스트로 반환합니다.
     *
     * @return 사용자로부터 입력받은 야구 숫자 리스트
     */
    @Override
    public List<Integer> getInput() {
        String input = Console.readLine();
        validator.validate(input);
        return parseInput(input);
    }

    /**
     * 입력된 문자열을 정수 리스트로 파싱합니다.
     *
     * @param input 사용자로부터 입력받은 문자열
     * @return 파싱된 정수 리스트
     */
    private List<Integer> parseInput(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            numbers.add(Character.getNumericValue(ch));
        }
        return numbers;
    }
}
