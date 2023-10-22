package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            List<Integer> computerNumbers = generateComputerNumbers();

            boolean gameWon = false;

            while (!gameWon) {
                int[] userNumbers = getUserGuess();
                int[] result = checkGuess(userNumbers, computerNumbers);
                displayResult(result);

                // 3개의 숫자를 모두 맞히면 게임 종료
                if (result[1] == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    gameWon = true;
                }
            }

            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
            int choice = getIntegerInput();

            if (choice == 2) {
                return; // 프로그램 종료
            }
        }
    }

    // 컴퓨터의 무작위 숫자 생성
    private static List<Integer> generateComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }

    // 사용자로부터 숫자 추측 입력을 받음
    private static int[] getUserGuess() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        int[] userNumbers = new int[3];

        // 입력 검증: 3자리 숫자 여부 확인
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해야 합니다.");
        }

        // 입력 검증: 1에서 9 사이의 숫자 여부 확인
        for (int i = 0; i < 3; i++) {
            userNumbers[i] = Character.getNumericValue(input.charAt(i));
            if (userNumbers[i] < 1 || userNumbers[i] > 9) {
                throw new IllegalArgumentException("1에서 9 사이의 숫자를 입력해야 합니다.");
            }
        }
        return userNumbers;
    }

    // 사용자의 추측을 평가하고 결과 변환
    private static int[] checkGuess(int[] userNumbers, List<Integer> computerNumbers) {
        int strikes = 0;
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            if (userNumbers[i] == computerNumbers.get(i)) {
                strikes++;
            } else if (computerNumbers.contains(userNumbers[i])) {
                balls++;
            }
        }
        return new int[]{balls, strikes};
    }


    // 게임 결과를 출력
    private static void displayResult(int[] result) {
        if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
        } else if (result[0] == 0) {
            System.out.println(result[1] + "스트라이크");
        } else if (result[1] == 0) {
            System.out.println(result[0] + "볼");
        } else {
            System.out.println(result[0] + "볼 " + result[1] + "스트라이크");
        }
    }

    // 정수 입력을 받는 메서드 (1 또는 2만 허용)
    private static int getIntegerInput() {
        while (true) {
            try {
                String input = Console.readLine();
                int choice = Integer.parseInt(input);
                if (choice == 1 || choice == 2) {
                    return choice;
                } else {
                    System.out.println("1 또는 2를 입력하세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 1 또는 2를 입력하세요.");
            }
        }
    }
}
