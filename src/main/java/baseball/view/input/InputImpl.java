package baseball.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputImpl implements Input {

    private static final String REGEX_BASEBALL = "^[1-9]{3}$";
    private static final String REGEX_END = "[12]{1}";

    @Override
    public String baseballInput() {
        String baseballInput = Console.readLine();
        validateBaseballInput(baseballInput);
        return baseballInput;
    }

    @Override
    public String endInput() {
        String endInput = Console.readLine();
        validateEndInput(endInput);
        return endInput;
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

    private void validateEndInput(String endInput) {
        if (!endInput.matches(REGEX_END)) {
            throw new IllegalArgumentException("새로운 게임을 시작혀려면 1, 종료하려면 2를 입력하세요.");
        }
    }
}
