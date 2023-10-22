package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;

import static baseball.Stationary.*;

public class Validation {

        // String을 HashSet으로 변환 -> 중복된 숫자가 있는지 확인 + 3자리인지 확인하기 위함
        public static HashSet<Character> convertStringToHashSet(String input) {
                HashSet<Character> set = new HashSet<>();
                for (int i = 0; i < input.length(); i++) {
                        set.add(input.charAt(i));
                }
                return set;
        }

        // 3자리인지 or 사용자가 입력한 값에 중복된 숫자가 있는지 확인
        public static void isContainDuplicate(String input) {
                HashSet<Character> set = convertStringToHashSet(input);
                if (set.size() != INPUT_LENGTH) {
                        throw new IllegalArgumentException();
                }
        }

        // 사용자가 입력한 값에 0이 포함되어 있는지 확인
        public static void isZeroIncluded(String input) {
                if (input.contains("0")) {
                        throw new IllegalArgumentException();
                }
        }

        // 사용자가 입력한 값이 숫자인지 확인
        public static void isNumber(String input) {
                try {
                        Integer.parseInt(input);
                } catch (NumberFormatException e) {
                        throw new IllegalArgumentException();
                }
        }

}
