package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Validator {

    public List<Integer> validateAndParseGuessedNumbers(String str) throws IllegalArgumentException {
        if(!isThreeDigitNumber(str)) throw new IllegalArgumentException("세 자리 숫자가 아닙니다");

        List<Integer> guessedNumbers = parseNumbers(str);
        if(!isUniqueSetOfNumbers(guessedNumbers)) throw new IllegalArgumentException("중복된 숫자가 있습니다");

        return guessedNumbers;
    }

    private boolean isThreeDigitNumber(String str) {
        String regex = "^\\d{3}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    private boolean isUniqueSetOfNumbers(List<Integer> guessedNumbers) {
        Set<Integer> numberSet = new HashSet<>(guessedNumbers);
        return numberSet.size() == 3;
    }

    private List<Integer> parseNumbers(String str) {
        return Arrays.stream(str.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
