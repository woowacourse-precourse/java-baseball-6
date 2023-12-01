package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PracticeApplication {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println(computerNumbers());

        System.out.println(isNumbers("123"));
        System.out.println(isNotDuplication("133"));
//        System.out.println(userNumbers());

        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> user = Arrays.asList(1, 2, 4);

        System.out.println(ballCount(computer, user, 1));

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
    public static List<Integer> userNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumbers = Console.readLine();
        if (isValid(inputNumbers)) {
            List<Integer> numbers = new ArrayList<>();
            for (char ch : inputNumbers.toCharArray()) {
                numbers.add(Character.getNumericValue(ch));
            }
            return numbers;
        } else {
            throw new IllegalArgumentException("중복되지 않은 3자리 수를 입력해주세요.");
        }
    }

    private static boolean isValid(String numbers) {
        if (isNumbers(numbers) && isNotDuplication(numbers)) {
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

    // 숫자 비교하여 결과를 판단하는 메서드
//    public static String judgment(List<Integer> computerNumbers, List<Integer> userNumbers) {
//        //
//    }

    // 스트라이크로 이미 카운트가 되었다면 볼에는 포함이 되면 안됨
    private static int ballCount(List<Integer> computerNumbers, List<Integer> userNumbers, int strikeCount) {
        int count = 0;
        for (int userNumber : userNumbers()) {
            if (computerNumbers.contains(userNumber)) {
                count++;
            }
        }
        return count - strikeCount;
    }

    private static int strikeCount(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int count = 0;
        for (int i = 0; i < computerNumbers.size(); i++) {
            if (computerNumbers.get(i).equals(userNumbers.get(i))) {
                count++;
            }
        }
        return count;
    }


}


