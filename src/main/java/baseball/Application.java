package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computerNumbers = generateRandomNumbers();
        System.out.println("컴퓨터가 숫자를 정했습니다.");

        while (true) {
            System.out.print("세 자리 숫자를 입력하세요: ");
            String input = Console.readLine();
            if (!isValidInput(input)) {
                System.out.println("잘못된 입력입니다. 1부터 9까지의 서로 다른 숫자를 입력하세요.");
                continue;
            }
        }
    }

    private static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(num)) {
                numbers.add(num);
            }
        }
        return numbers;
    }

    private static boolean isValidInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력 길이는 3이어야 합니다.");
        }
        for (char digit : input.toCharArray()) {
            if (digit < '1' || digit > '9') {
                throw new IllegalArgumentException("1부터 9까지의 숫자를 입력해야 합니다.");
            }
        }
        if (!areDigitsUnique(input)) {
            throw new IllegalArgumentException("서로 다른 숫자를 입력해야 합니다.");
        }
        return true;
    }

    private static boolean areDigitsUnique(String input) {
        return input.chars().distinct().count() == 3;
    }

}
