package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        while (true) {
            boolean gameContinues = playGame();
            if (!gameContinues) {
                break;
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = Console.readLine();
            if (input.equals("2")) {
                break;
            }
        }
    }

    private static List<Integer> generateNumber() {

        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println(computer);
        return computer;
    }

    private static int[] compareNumbers(List<Integer> computer, List<Integer> userNumber) {
        int strike = 0;
        int ball = 0;

        for (int i=0; i<3; i++) {
            if (userNumber.get(i).equals(computer.get(i))) {
                strike++;
            } else if (computer.contains(userNumber.get(i))) {
                ball++;
            }
        }
        return new int[]{strike, ball};
    }

    private static boolean playGame() {
        List<Integer> computerNumbers = generateNumber();
        System.out.print("숫자 야구 게임을 시작합니다.");

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();

            List<Integer> userNumbers;
            try {
                userNumbers = validateInput(userInput);
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 입력입니다.");
                return false;
            }

            int[] result = compareNumbers(computerNumbers, userNumbers);
            if (result[0] == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return true;
            }

            if (result[0] == 0 && result[1] == 0) {
                System.out.println("낫싱");
            } else {
                if (result[1] > 0) {
                    System.out.print(result[1] + "볼 ");
                }
                if (result[0] > 0) {
                    System.out.print(result[0] + "스트라이크");
                }
                System.out.println();
            }
        }
    }

    private static List<Integer> validateInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        List<Integer> numbers = new ArrayList<>();

        // 숫자로 변환이 되지 않으면 숫자외에 잘못된 문자가 있는것이므로, 각 문자를 숫자로 변환해본다.
        for (char c : input.toCharArray()) {
            int numericValue = Character.getNumericValue(c);

            // 숫자가 아닌 문자 또는 1~9 범위 밖의 숫자가 있는 경우
            if (numericValue < 1 || numericValue > 9) {
                throw new IllegalArgumentException();
            }

            numbers.add(numericValue);
        }

        return numbers;
    }
}