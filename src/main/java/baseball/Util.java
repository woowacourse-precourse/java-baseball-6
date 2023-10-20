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

    public static void validateUserString(String string) {

        validateStringOnlyNumbers(string);
        validateStringLength(string, 3);
        validateStringDuplicate(string);
    }

    private static void validateStringOnlyNumbers(String string) {

        for (char c : string.toCharArray()) {
            if(!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자만 입력해야 합니다.");
            }
            if(c == '0') {
                throw new IllegalArgumentException("1~9 사이의 값을 입력해야 합니다.");
            }
        }
    }

    private static void validateStringLength(String string, int length) {

        if(string.length() != length) {
            throw new IllegalArgumentException(length + "개의 수를 입력해야 합니다.");
        }
    }

    private static void validateStringDuplicate(String string) {

        for(int i = 0; i < string.length(); i++) {
            for(int j = i + 1; j < string.length(); j++) {
                if(string.charAt(i) == string.charAt(j)) {
                    throw new IllegalArgumentException("중복된 수를 입력할 수 없습니다.");
                }
            }
        }
    }

    public static List<Integer> stringToIntegerList(String string) {

        List<Integer> integerList = new ArrayList<>();
        for(String s : string.split("")) {
            integerList.add(Integer.parseInt(s));
        }

        return integerList;
    }
}
