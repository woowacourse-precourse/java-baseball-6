package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            String target = generateRandomNumber();
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String guess = Console.readLine();

                if (!isValidInput(guess)) {
                    throw new IllegalArgumentException("Invalid input provided.");
                }

                String result = checkGuess(target, guess);
                System.out.println(result);
                if (result.equals("3스트라이크")) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }

            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
            String choiceInput = Console.readLine();
            if (!choiceInput.equals("1") && !choiceInput.equals("2")) {
                System.out.println("1 또는 2만 입력해주세요.");
                continue;
            }
            int choice = Integer.parseInt(choiceInput);
            if (choice == 2) {
                break;
            }
        }


    }
    private static String generateRandomNumber() { //겹치지 않는 3자리 수 생성
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            numbers.add(randomNumber);
        }
        StringBuilder result = new StringBuilder();
        for (Integer number : numbers) {
            result.append(number);
        }
        //System.out.println("결과: " + result.toString());
        return result.toString();
    }

    private static boolean isValidInput(String input) {
        if (input.length() != 3) { //길이가 3자리가 아닌경우
            return false;
        }
        if (!input.matches("[1-9]{3}")) { //1-9 3번
            return false;
        }
        return input.chars().distinct().count() == 3;
    }

    private static String checkGuess(String target, String guess) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (guess.charAt(i) == target.charAt(i)) {
                strikes++;
            } else if (target.contains(String.valueOf(guess.charAt(i)))) {
                balls++;
            }
        }

        if (strikes == 0 && balls == 0) {
            return "낫싱";
        } else if (strikes == 3) {
            return "3스트라이크";
        } else {
            return balls + "볼 " + strikes + "스트라이크";
        }
    }
}
