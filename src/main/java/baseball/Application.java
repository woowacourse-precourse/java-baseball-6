package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true) {
            List<Integer> randomNumber = Randoms.pickUniqueNumbersInRange(1, 9, 3);

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String inputNumber = Console.readLine();
                List<Integer> answer = parseInput(inputNumber);
                break;
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String choice = Console.readLine();
            if (choice.equals("2")) {
                break;
            }
        }
    }



    private static List<Integer> parseInput(String input) {
        validInput(input);
        List<Integer> parse = new ArrayList<>();
        input.split("");
        return parse;
    }

    private static int checkAnswer(List<Integer> randomNumber, List<Integer> answer) {

        return 1;
    }

    private static void validInput(String input) {
        if (!isThreeDigitNumber(input) || hasDuplicateDigits(input)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isThreeDigitNumber(String input) {
        return input.length() == 3 && input.chars().allMatch(Character::isDigit);
    }

    private static boolean hasDuplicateDigits(String input) {
        char[] digits = input.toCharArray();
        return digits[0] == digits[1] || digits[0] == digits[2] || digits[1] == digits[2];
    }

}