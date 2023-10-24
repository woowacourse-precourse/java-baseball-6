package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        try {
            // 컴퓨터의 랜덤 숫자
            int[] computerNumbers = generateRandomNumbers();

            // 게임 루프
            while (true) {
                int[] userNumbers = getUserInput(); // 유저가 입력한 숫자
                int[] result = calculateResult(computerNumbers, userNumbers); // 컴퓨터 숫자와 유저 입력값 비교
                System.out.println("컴퓨터숫자: " + computerNumbers[0]+computerNumbers[1]+computerNumbers[2]);
//                int threeDigitNumber = computerNumbers[0] * 100 + computerNumbers[1] * 10 + computerNumbers[2];
                displayResult(result); // 결과 출력 메서드

                if (result[0] == 3) { // 스트라이크 3개면 종료 또는 재시작 선택
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String choice = Console.readLine();

                    if (choice.equals("1")) {
                        computerNumbers = generateRandomNumbers(); // 새로운 랜덤 숫자 생성
                    } else if (choice.equals("2")) {
                        System.out.println("게임을 종료합니다.");
                        break; // 게임 종료
                    } else {
                        System.out.println("유효하지 않은 선택입니다. 게임을 종료합니다.");
                        break; // 게임 종료
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력: " + e.getMessage());
        }
    }

    // 1부터 9까지 서로 다른 3개의 숫자 무작위 선택
    public static int[] generateRandomNumbers() {
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            int randomNumber;
            do {
                randomNumber = Randoms.pickNumberInRange(1, 9);
            } while (contains(numbers, randomNumber));
            numbers[i] = randomNumber;
        }
        return numbers;
    }

    // 사용자로부터 3자리 숫자 입력 받기
    public static int[] getUserInput() {
        int[] numbers = new int[3];
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            if (input.matches("^[1-9]{3}$")) {
                for (int i = 0; i < 3; i++) {
                    numbers[i] = Integer.parseInt(input.substring(i, i + 1));
                }
                return numbers;
            } else {
                throw new IllegalArgumentException("서로 다른 3자리 숫자를 입력하세요.");
            }
        }
    }

    // 결과 계산 메서드
    public static int[] calculateResult(int[] computerNumbers, int[] userNumbers) {
        int[] result = new int[2]; // result[0]: 스트라이크, result[1]: 볼

        for (int i = 0; i < 3; i++) {
            if (computerNumbers[i] == userNumbers[i]) {
                result[0]++; // 스트라이크
            } else if (contains(computerNumbers, userNumbers[i])) {
                result[1]++; // 볼
            }
        }
        return result;
    }

    // 배열에 특정 숫자가 포함되어 있는지 확인하는 메서드
    public static boolean contains(int[] arr, int num) {
        for (int i : arr) {
            if (i == num) {
                return true;
            }
        }
        return false;
    }

    // 결과 출력 메서드
    public static void displayResult(int[] result) {
        if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
        } else if (result[0] > 0 && result[1] == 0) {
            System.out.println(result[0] + "스트라이크");
        } else if (result[0] == 0 && result[1] > 0) {
            System.out.println(result[1] + "볼");
        } else {
            System.out.println(result[1] + "볼 " + result[0] + "스트라이크");
        }
    }
}
