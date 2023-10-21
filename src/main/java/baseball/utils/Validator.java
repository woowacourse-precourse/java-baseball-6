package baseball.utils;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public void validateInputNumber(String inputNumber) {
        if (isNotIntegerType(inputNumber)) {
            throw new IllegalArgumentException("정수 타입이 아닙니다");
        }
        if (isNotCorrectLength(inputNumber)) {
            throw new IllegalArgumentException("길이가 일치하지 않습니다");
        }
        if (isDuplicateNumber(inputNumber)) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다");
        }
    }

    public void validatePlayButton(String playButton) {
        if (isNotIntegerType(playButton)) {
            throw new IllegalArgumentException("정수 타입이 아닙니다");
        }
        if (isNotCorrectButton(playButton)) {
            throw new IllegalArgumentException("버튼 입력은 1 또는 2만 가능합니다");
        }
    }

    public boolean isDuplicateNumber(String inputNumber) {
        HashSet<String> numberSet = new HashSet<>();
        String[] eachInputNumber = inputNumber.split("");

        for (String number : eachInputNumber) {
            if (numberSet.contains(number)) {
                return true;
            }
            numberSet.add(number);
        }
        return false;
    }

    public boolean isNotCorrectLength(String inputNumber) {
        return inputNumber.length() != 3;
    }

    public boolean isNotIntegerType(String inputNumber) {
        String integerCode = "^[-+]?\\d+$";
        Pattern pattern = Pattern.compile(integerCode);
        Matcher matcher = pattern.matcher(inputNumber);
        return !matcher.matches();
    }

    public boolean isNotCorrectButton(String playButton) {
        return !(playButton.equals("1") || playButton.equals("2"));
    }
}
