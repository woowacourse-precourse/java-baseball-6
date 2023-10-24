package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> randomNumbers = makeRandomNumber();
        List<Integer> userNumbers = getUserNumber();
    }

    private static List<Integer> makeRandomNumber() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    private static List<Integer> getUserNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        List<Integer> numbers = new ArrayList<>();

        try {
            if (input.length() != 3) {
                throw new IllegalArgumentException();
            }
            Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < input.length(); i++) {
            int number = Character.getNumericValue(input.charAt(i));
            numbers.add(number);
        }
        if (numbers.stream().distinct().count() != 3) {
            throw new IllegalArgumentException();
        }
        return numbers;
    }
}