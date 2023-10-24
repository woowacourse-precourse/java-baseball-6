package baseball.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class Validator {
    public static void validateListSize(List<Integer> list) {
        if(list.size() != 3) {
            throw new IllegalArgumentException("리스트의 크기는 3이어야 합니다!");
        }
    }

    public static void validateDuplicateList(List<Integer> list) {
        Set<Integer> validationList = new HashSet<>(list);
        if (validationList.size() != list.size()) {
            throw new IllegalArgumentException("리스트에 중복된 숫자가 존재합니다.");
        }
    }

    public static void validateInput(String input) {
        for (char c : input.toCharArray()) {
            if(!Character.isDigit(c) || c == '0') {
                throw new IllegalArgumentException("잘못된 값을 입력하였습니다. 프로그램을 종료합니다.");
            }
        }
    }

    public static void validateRestartInput(String input) {
        if(input.equals("1") || input.equals("2")) {
            return;
        }
        throw new IllegalArgumentException("잘못된 값을 입력하였습니다. 프로그램을 종료합니다.");
    }

    public static void validateInputDuplication(String input) {
        Set<String> duplication = new HashSet<>(List.of(input.split("")));
        if(duplication.size() == 3) {
            return;
        }
        throw new IllegalArgumentException("사용자의 입력값에 중복된 숫자가 존재합니다. 프로그램을 종료합니다.");
    }
}
