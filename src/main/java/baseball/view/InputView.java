package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputView {

    public String inputNumbers() {
        String input = Console.readLine();
        validateInput(input);
        return input;
    }

    public void validateInput(String input) {
        validateDigit(input);
        validateUnique(input);
    }

    private void validateDigit(String input) {
        boolean isThreeDigit = input.matches("/[1-9][1-9][1-9]/");
        if (!isThreeDigit) {
            throw new IllegalArgumentException("1부터 9사이의 세 자리 숫자로 입력해야 합니다.");
        }
    }

    private void validateUnique(String input) {
        Set<String> numberSet = new HashSet<>(Arrays.asList(input.split("")));

        boolean isUniqueDigit = numberSet.size() == 3;
        if (!isUniqueDigit) {
            throw new IllegalArgumentException("서로 다른 세 자리 숫자로 입력해야 합니다.");
        }
    }
}
