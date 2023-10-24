package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class InputDevice {
    // 값을 입력 받는 클래스
    // 값을 잘못 입력한 경우 IllegalArgumentException를 throw해야함
    // 1~9 3가지의 각자 다른 정수를 입력 받는 메서드 >> String으로 받기
    // 1또는 2를 입력받는 메서드
    private InputDevice() {
    }

    private static List<Integer> parseStringToInteger(String s) {
        List<Integer> result = new ArrayList<>();
        for (String t : s.split("")) {
            result.add(Integer.parseInt(t));
        }
        return result;
    }

    private static void validateSize(final List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("입력된 값이 없습니다.");
        }
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("3개의 숫자를 입력해주세요.");
        }
    }

    private static void validateNumbersInRange(final List<Integer> numbers, final int endInclusive) {
        for (Integer n : numbers) {
            if (n < 1 || n > endInclusive) {
                throw new IllegalArgumentException("1 ~" + endInclusive + " 사이의 값이 아닙니다.");
            }
        }
    }

    private static void validateduplication(final List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("중복 값이 있습니다.");
        }
    }
}
