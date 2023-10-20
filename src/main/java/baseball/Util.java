package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public static List<Integer> getRandomNumber(int length) {

        List<Integer> numbers = new ArrayList<>();
        while(numbers.size() < length) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public static void validateUserString(String input) {

        validateStringOnlyNumbers(input);
        validateStringLength(input, 3);
        validateStringDuplicate(input);
    }

    public static void validateStringOnlyNumbers(String input) {

        for (char c : input.toCharArray()) {
            if(!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자만 입력해야 합니다.");
            }
            if(c == '0') {
                throw new IllegalArgumentException("1~9 사이의 값을 입력해야 합니다.");
            }
        }
    }

    public static void validateStringLength(String input, int length) {

        if(input.length() != length) {
            throw new IllegalArgumentException(length + "개의 수를 입력해야 합니다.");
        }
    }

    public static void validateStringDuplicate(String input) {

        for(int i = 0; i < input.length(); i++) {
            for(int j = i + 1; j < input.length(); j++) {
                if(input.charAt(i) == input.charAt(j)) {
                    throw new IllegalArgumentException("중복된 수를 입력할 수 없습니다.");
                }
            }
        }
    }

    public static List<Integer> stringToIntegerList(String input) {

        List<Integer> integerList = new ArrayList<>();
        for(String s : input.split("")) {
            integerList.add(Integer.parseInt(s));
        }

        return integerList;
    }
}
