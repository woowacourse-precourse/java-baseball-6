package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputService {
    private final ValidateService validateService;

    public InputService() {
        this.validateService = new ValidateService();
    }

    public List<Integer> input() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputValue = Console.readLine();

        // 입력값 검증
        if(!validateService.validateLength(inputValue) || !validateService.validateType(inputValue)
                || !validateService.validateDuplicateValue(inputValue)) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }

        // 입력값 List<Integer>로 매핑
        List<Integer> inputValueList = new ArrayList<>();
        mapping(inputValue, inputValueList);

        return inputValueList;
    }

    // 입력값을 List<Integer>로 매핑하는 로직
    private void mapping(String inputValue, List<Integer> inputValueList) {
        for (int i = 0; i < 3; i++) {
            inputValueList.add(inputValue.charAt(i) - 48);
        }
    }
}
