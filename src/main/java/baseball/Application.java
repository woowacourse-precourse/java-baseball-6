package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final int MAX_NUMBER = 3;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            List<Integer> computerNumbers = generateRandomNumbers();
            playGame(computerNumbers);

        } while (askRestartOrExit());
    }

    private static boolean askRestartOrExit() {
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            try {
                int choice = Integer.parseInt(Console.readLine());

                if (choice == 1) {
                    return true;
                } else if (choice == 2) {
                    return false;
                } else {
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요.");
            }
        }
    }

    private static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < MAX_NUMBER) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        // System.out.println(numbers);
        return numbers;
    }

    private static void playGame(List<Integer> computerNumbers) {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();

            if (input.length() != MAX_NUMBER) {
                throw new IllegalArgumentException("3자리의 숫자를 입력해주세요.");
            }

            List<Integer> userNumbers = convertToList(input);

            String result = checkNumbers(computerNumbers, userNumbers);
            System.out.println(result);

            if (result.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private static List<Integer> convertToList(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            numbers.add(Character.getNumericValue(ch));
        }
        return numbers;
    }

    private static String checkNumbers(List<Integer> computer, List<Integer> user) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < MAX_NUMBER; i++) {
            if (computer.get(i).equals(user.get(i))) {
                strikes++;
            } else if (computer.contains(user.get(i))) {
                balls++;
            }
        }

        if (strikes == 0 && balls == 0) {
            return "낫싱";
        }
        if (strikes == MAX_NUMBER) {
            return "3스트라이크";
        }

        return (balls > 0 ? balls + "볼 " : "") + (strikes > 0 ? strikes + "스트라이크" : "");
    }
}
