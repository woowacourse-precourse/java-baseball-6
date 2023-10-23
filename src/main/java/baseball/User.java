package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static List<Integer> validateInput(String input) {
        // 입력받은 문자열을 한 글자씩 숫자로 변환하여 리스트에 저장
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char digit = input.charAt(i);
            if (Character.isDigit(digit)) {
                int number = Character.getNumericValue(digit);
                numbers.add(number);
            }
        }
        // 입력에 3개의 숫자가 아닌 경우 IllegalArgumentException
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("3개의 숫자를 입력해야 합니다.");
        }
        return numbers;
    }

    public static List<Integer> getNumberFromUser() {

        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        List<Integer> numbers = validateInput(input);

        return numbers;

    }

    public boolean getUserChoice() {

        String input = Console.readLine();
        int choice = Integer.parseInt(input);
        if (choice == 1) {
            return true;
        } else if (choice == 2) {
            return false;
        } else {
            throw new IllegalArgumentException("1또는 2를 입력해야 합니다.");
        }


    }

}
