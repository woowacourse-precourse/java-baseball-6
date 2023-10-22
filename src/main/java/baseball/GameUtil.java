package baseball;

import java.util.ArrayList;
import java.util.List;

public class GameUtil {
    // 게임 전반적으로 필요한 메소드를 제공하는 클래스
    public static List<Integer> inputParse(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("[세자리 수] 세 자리의 숫자를 입력해 주세요.");
        }

        List<Integer> integers = new ArrayList<>();

        try {
            integers.add(Integer.parseInt(String.valueOf(input.charAt(0))));
            integers.add(Integer.parseInt(String.valueOf(input.charAt(1))));
            integers.add(Integer.parseInt(String.valueOf(input.charAt(2))));
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[형식 오류] 올바르지 않은 숫자 형식입니다.");
        }

        integers.forEach(GameUtil::validateValue);
        validateDuplicate(integers);

        return integers;
    }

    public static void validateValue(int value) {
        if (value > 9 || value < 1) {
            throw new IllegalArgumentException("[벗어난 수] 1부터 9사이의 값을 입력해 주세요.");
        }
    }

    public static void validateDuplicate(List<Integer> integerList) {
        long size = integerList.stream()
                .distinct()
                .count();

        if (size != 3) {
            throw new IllegalArgumentException("[중복된 수] 서로 다른 3개의 숫자를 입력해 주세요.");
        }
    }
}
