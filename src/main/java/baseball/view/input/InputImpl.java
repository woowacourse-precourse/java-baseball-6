package baseball.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputImpl implements Input {

    private static final String REGEX_BASEBALL = "^[1-9]{3}$";

    @Override
    public String baseballInput() {
        String baseballInput = Console.readLine();
        validateBaseballInput(baseballInput);
        return baseballInput;
    }

    private void validateBaseballInput(String baseballInput) {
        String[] baseballNumber = baseballInput.split("");
        List<String> distinctNumber = Arrays.stream(baseballNumber)
                .distinct()
                .toList();
        if (!baseballInput.matches(REGEX_BASEBALL) || distinctNumber.size() != 3) {
            throw new IllegalArgumentException("서로 다른 3자리 숫자만 입력 가능합니다.");
        }
    }
}
