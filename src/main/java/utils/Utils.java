package utils;

import static baseball.Application.NUMBER_LENGTH;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utils {
    public List<Integer> stringToIntList(String input) {
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            int split_number = input.charAt(i) - 48;
            intList.add(split_number);
        }
        return intList;
    }

    public String intListToString(List input) {
        String string = "";
        for (int i = 0; i < input.size(); i++) {
            String split_number = String.valueOf(input.get(i));
            string = string + split_number;
        }
        return string;
    }

    public void inputLengthIsZero(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException("입력의 길이가 0입니다.");
        }
    }

    public void inputLengthIsOver(String input) {
        if (input.length() > NUMBER_LENGTH) {
            throw new IllegalArgumentException("입력된 숫자가 요구된 개수보다 많습니다.");
        }
    }

    public void inputLengthIsUnder(String input) {
        if (input.length() < NUMBER_LENGTH) {
            throw new IllegalArgumentException("입력된 숫자가 요구된 개수보다 적습니다.");
        }
    }

    public void inputIsNotNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            int ascii = input.charAt(i);
            if (ascii < 48 || ascii > 58) {
                throw new IllegalArgumentException("입력은 모두 숫자로 구성되어야 합니다.");
            }
        }
    }

    public void duplicateNumber(String input) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            set.add(input.charAt(i));
        }
        if (set.size() < NUMBER_LENGTH) {
            throw new IllegalArgumentException("입력된 숫자 중 중복된 것이 있습니다.");
        }
    }

    public void userGameStartValidation(String input) {
        inputLengthIsZero(input);
        inputIsNotNumber(input);
        inputLengthIsOver(input);
        inputLengthIsUnder(input);
        duplicateNumber(input);
    }

    public void userGameRestartOrEndValidation(String input) {
        inputLengthIsZero(input);
        inputIsNotNumber(input);
    }
}
