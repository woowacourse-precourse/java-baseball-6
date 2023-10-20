package baseball.Input;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputAnswerImpl implements InputAnswer {

    @Override
    public List<Integer> inputAnswer() throws IllegalArgumentException {
        String input = Console.readLine();
        integrateValidation(input);
        return List.of(Integer.parseInt(String.valueOf(input.charAt(0))),
                Integer.parseInt(String.valueOf(input.charAt(1))),
                Integer.parseInt(String.valueOf(input.charAt(2))));
    }

    @Override
    public void integrateValidation(String input) {
        isInteger(input);
        rangeValidation(input);
        duplicateValidation(input);
    }

    @Override
    public void isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수만 입력해주세요." + "\n" + "입력값: " + input);
        }
    }

    @Override
    public void duplicateValidation(String input) {
        if (input.charAt(0) == input.charAt(1) ||
                input.charAt(0) == input.charAt(2) ||
                input.charAt(1) == input.charAt(2)) {
            throw new IllegalArgumentException("중복된 정수를 입력할 수 없습니다." + "\n" + "입력값: " + input);
        }
    }

    @Override
    public void rangeValidation(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("범위를 벗어난 정수를 입력할 수 없습니다." + "\n" + "입력값: " + input);
        }
    }
}
