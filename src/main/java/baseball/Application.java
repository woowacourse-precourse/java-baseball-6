package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int DIGIT_COUNT = 3;


    public static void main(String[] args) {

    }


    // 무작위 숫자 리스트를 반환
    private static List<Integer> createRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < DIGIT_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return new ArrayList<>(computer);
    }

    // 사용자 숫자 입력
    private static String getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    // 사용자 입력의 길이가 3인지 검증
    private static void validateInputLength(String input) {
        if (input.length() != DIGIT_COUNT) {
            throw new IllegalArgumentException("입력은 3자리 숫자여야 합니다.");
        }
    }

    // 사용자 입력이 숫자로만 이루어져 있는지 검증
    private static void validateInputIsNumeric(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("입력은 숫자여야 합니다.");
        }
    }

    // 사용자 입력의 각 숫자가 서로 다른지 검증
    private static void validateUniqueDigits(String input) {
        Set<Character> uniqueDigits = new HashSet<>();

        for (char digitChar : input.toCharArray()) {
            if (uniqueDigits.contains(digitChar)) {
                throw new IllegalArgumentException("서로 다른 숫자 3개를 입력해야 합니다.");
            }
            uniqueDigits.add(digitChar);
        }
    }


}
