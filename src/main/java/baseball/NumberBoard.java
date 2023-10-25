package baseball;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import random.RandomArray;

public class NumberBoard {
    private static final int START_RANGE = 0;
    private static final int END_RANGE = 9;
    private static final int SIZE = 3;
    private int[] answer;

    public NumberBoard(int[] answer) {
        this.answer = answer;
    }

    public NumberBoard(String input) {
        validateInput(input, SIZE);
        int[] inputToArray = inputToArray(input);
        this.answer = inputToArray;
    }

    public static NumberBoard makeRandomBoard() {
        return new NumberBoard(RandomArray.makeRandomArray(START_RANGE, END_RANGE, SIZE));
    }

    private static void validateInput(String input, int size) {
        if (validateInputByTypeAndSize(input, size) || nonDuplicateNumber(input, size)) {
            throw new IllegalArgumentException("길이가 " + size + "인 중복되지 않는 숫자를 입력해주세요.");
        }
    }

    private static boolean nonDuplicateNumber(String input, int size) {
        return input.chars()
                .distinct()
                .count() != size;
    }

    private static boolean validateInputByTypeAndSize(String input, int size) {
        String regex = String.format("[0-9]{%d}", size);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return !matcher.matches();
    }

    private static int[] inputToArray(String input) {
        return input.chars()
                .map(i -> i - '0')
                .toArray();
    }

    public int get(int index) {
        return answer[index];
    }

    public int size() {
        return SIZE;
    }
}
