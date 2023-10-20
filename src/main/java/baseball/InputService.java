package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputService {
    public List<Integer> input() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputValue = Console.readLine();

        // 입력값 검증
        if(!validateLength(inputValue) || !validateType(inputValue)) return null;

        // 입력값 List<Integer>로 매핑
        List<Integer> inputValueList = new ArrayList<>();
        mapping(inputValue, inputValueList);

        return inputValueList;
    }

    // 입력값의 길이를 검증하는 로직
    private Boolean validateLength(String inputValue) {
        try {
            if (inputValue.length() != 3) {
                throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    // 입력값의 타입을 검증하는 로직
    private Boolean validateType(String inputValue) {
        for (int i = 0; i < 3; i++) {
            int intValue = inputValue.charAt(i) - 48;
            try {
                if (!(1 <= intValue && intValue <= 9)) {
                    throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    // 입력값을 List<Integer>로 매핑하는 로직
    private void mapping(String inputValue, List<Integer> inputValueList) {
        for (int i = 0; i < 3; i++) {
            inputValueList.add(inputValue.charAt(i) - 48);
        }
    }
}
