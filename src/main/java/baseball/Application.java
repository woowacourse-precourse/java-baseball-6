package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static List<Integer> createAnswer() {
        List<Integer> answer = new ArrayList<>(3);
        while (answer.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(number)) {
                answer.add(number);
            }
        }
        return answer;
    }

    private static List<Integer> parseUserInput(String input) {
        List<Integer> userInput = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            userInput.add(Character.getNumericValue(input.charAt(i)));
        }
        return userInput;
    }

    private static int[] checkAnswer(List<Integer> answer, List<Integer> userInput) {
        int[] count = new int[2];
        for (int i = 0; i < 3; i++) {
            if (answer.get(i).equals(userInput.get(i))) {
                count[1]++;
                continue;
            }
            for (int j = 0; j < 3; j++) {
                if (i != j && answer.get(i).equals(userInput.get(j))) {
                    count[0]++;
                    break;
                }
            }
        }
        return count;
    }

    private static void validateUserInput(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("숫자가 아닌 입력값이 존재합니다.");
            }
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
                }
            }
        }
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력값의 길이가 올바르지 않습니다.");
        }
    }

    private static void validateReset(String reset) {
        if (reset.length() != 1) {
            throw new IllegalArgumentException("입력이 유효하지 않습니다.");
        } else if (!reset.equals("1") && !reset.equals("2")) {
            throw new IllegalArgumentException("입력이 유효하지 않습니다.");
        }
    }
}
