package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class PracticeApplication {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println(computerNumbers());

        System.out.println(isNumbers("123"));
        System.out.println(isNotDuplication("133"));

    }

    // 중복되지 않은 3개의 랜덤한 숫자
    public static List<Integer> computerNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        return numbers;
    }

    // 사용자로부터 중복되지 않은 3개의 숫자 입력받기
//    public static List<Integer> userNumbers() {
//        String numbers = Console.readLine();
//        while (true) {
//            // 세 자리인가 O
//            // 숫자인가 O
//            // 중복되는 숫자를 입력하지 않았는가 X
//            if (isValid(numbers)) {
//
//            }
//
//        }
//    }
//
    private static boolean isValid(boolean isNumbers, boolean isNotDuplication) {
        if (isNumbers && isNotDuplication) {
            return true;
        }
        return false;
    }

    private static boolean isNumbers(String numbers) {
        if (numbers.matches("^[1-9]{3}$")) {
            return true;
        }
        return false;
    }

    // 콤마 없이 연속해서 입력하기 때문에 .split(",") 로 하면 중복 검사가 제대로 이루어지지 않음
    // 문자열을 문자 단위 (char) 단위로 분리해서 비교하는 방법을 취해야 함
    private static boolean isNotDuplication(String numbers) {
        char[] numbersArr = numbers.toCharArray();
        for (int i = 0; i < numbersArr.length; i++) {
            for (int j = i + 1; j < numbersArr.length; j++) {
                if (numbersArr[i] == numbersArr[j]) {
                    return false;
                }
            }
        }
        return true;
    }


}


