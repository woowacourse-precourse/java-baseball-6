package baseball;

import java.util.Map;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public Map<Integer, Integer> validateAndParseGuessedNumbers(String str) throws IllegalArgumentException {
        if(!isThreeDigitNumber(str)) throw new IllegalArgumentException("세 자리 숫자가 아닙니다");
        Map<Integer, Integer> guessedNumbers = parseNumbers(str);
        if(!isUniqueSetOfNumbers(guessedNumbers)) throw new IllegalArgumentException("중복된 숫자가 있습니다");

        return guessedNumbers;
    }

    private boolean isThreeDigitNumber(String str) {
        String regex = "^\\d{3}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    private boolean isUniqueSetOfNumbers(Map<Integer, Integer> guessedNumbers) {
        return guessedNumbers.size() == 3;
    }

    private Map<Integer, Integer> parseNumbers(String str) {
        int index = 0;
        Map<Integer, Integer> guessedNumbers = new HashMap<>();
        for (char c:str.toCharArray()) {
            int number = (int) c - '0';
            if(guessedNumbers.containsKey(number)) continue;
            guessedNumbers.put(number, index++);
        }
        return guessedNumbers;
    }
}
