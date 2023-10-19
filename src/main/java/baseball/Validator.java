package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Validator {
    private Pattern pattern;
    private Matcher matcher;
    private List<Integer> intArray;

    public List<Integer> validateAndGetIntArray (String str) throws IllegalArgumentException {
        if(!isNumber(str)) throw new IllegalArgumentException("숫자만 입력하세요");
        if(!isThreeDigits(str)) throw new IllegalArgumentException("세 자리 숫자가 아닙니다");
        if(!isUniqueSetOfNumbers(str)) throw new IllegalArgumentException("중복된 숫자가 있습니다");

        return this.intArray;
    }

    private boolean isNumber(String str) {
        String regex = "^\\d+$";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(str);
        return matcher.matches();
    }

    private boolean isThreeDigits(String str) {
        String regex = "^\\d{3}$";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(str);
        return matcher.matches();
    }

    private boolean isUniqueSetOfNumbers(String str) {
        List<Integer> numbers = parseNumbers(str);

        int first = numbers.get(0);
        int second = numbers.get(1);
        int third = numbers.get(2);

        if (first == second) return false;
        else if (first == third) return false;
        else if (second == third) return false;
        this.intArray = numbers;

        return true;
    }

    private List<Integer> parseNumbers(String str) {
        return Arrays.stream(str.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
