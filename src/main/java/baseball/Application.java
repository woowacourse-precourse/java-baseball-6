package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true) {
            List<Integer> randomNumber = generateUniqueNumbers();

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String inputNumber = Console.readLine();
                List<Integer> answer = parseInput(inputNumber);
                if (isSameAnswerAndRandomNumber(randomNumber, answer)) {
                    break;
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String choice = Console.readLine();
            if (choice.equals("2")) {
                Console.close();
                break;
            }
        }
    }

    private static List<Integer> generateUniqueNumbers() {
        List<Integer> uniqueNumbers = new ArrayList<>();
        int min = 1;
        int max = 9;

        while (uniqueNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(min, max);
            if (!uniqueNumbers.contains(randomNumber)) {
                uniqueNumbers.add(randomNumber);
            }
        }
        return uniqueNumbers;
    }

    private static List<Integer> parseInput(String input) {
        validInput(input);
        return input.chars()
                .mapToObj(Character::getNumericValue)
                .toList();
    }

    private static boolean isSameAnswerAndRandomNumber(List<Integer> randomNumber, List<Integer> answer) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < randomNumber.size(); i++) {
            if (randomNumber.get(i).equals(answer.get(i))) {
                strikes++;
            } else if (answer.contains(randomNumber.get(i))) {
                balls++;
            }
        }

        if (strikes > 0 || balls > 0) {
            System.out.println(ballsAndStrikesFormatted(strikes, balls));
        } else {
            System.out.println("낫싱");
        }

        if (strikes == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    private static String ballsAndStrikesFormatted(int strikes, int balls) {
        StringBuilder sb = new StringBuilder();
        if (balls > 0) {
            sb.append(balls).append("볼 ");
        }
        if (strikes > 0) {
            sb.append(strikes).append("스트라이크");
        }
        return sb.toString().trim();
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