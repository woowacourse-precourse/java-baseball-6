package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User {

    public List<Integer> input() {

        String inputData = inputData();
        isDigits(inputData);
        validateLength(inputData);
        validateSameDigits(inputData);
        List<Integer> inputNumbers = convertToList(inputData);
        validateNumbersRange(inputNumbers);
        return inputNumbers;
    }

    private String inputData() {
        return Console.readLine();
    }

    private void validateLength(String inputData) {
        if (inputData.length() != 3) {
            throw new IllegalArgumentException("숫자의 길이가 적절하지 않습니다.");
        }
    }

    private void isDigits(String inputData) {
        if (inputData == null || !inputData.matches("-?\\d+(\\.\\d+)?")) {
            throw new IllegalArgumentException("숫자가 아닌 문자가 입력되었습니다.");
        }
    }

    private void validateSameDigits(String inputData) {
        HashMap<Character, Integer> number = new HashMap<>();

        for (int k = 0; k < inputData.length(); k++) {
            number.put(inputData.charAt(k), number.getOrDefault(inputData.charAt(k), 0) + 1);
        }

        if (number.values().stream().anyMatch(x -> x > 1)) {
            throw new IllegalArgumentException("중복된 숫자가 입력되었습니다.");
        }
    }

    private void validateNumbersRange(List<Integer> inputNumbers) {
        if (inputNumbers.stream().anyMatch(x -> x > 9 || x < 1)) {
            throw new IllegalArgumentException("1~9의 범위를 벗어나는 숫자가 입력되었습니다.");
        }
    }

    private List<Integer> convertToList(String inputData) {
        List<Integer> inputNumbers = new ArrayList<>();

        for (int k = 0; k < inputData.length(); k++) {
            inputNumbers.add(convertToInt(inputData.charAt(k)));
        }

        return inputNumbers;
    }

    private Integer convertToInt(char n) {
        return n - '0';
    }
}
