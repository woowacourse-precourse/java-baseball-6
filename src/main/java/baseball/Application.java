package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 게임 시작 메시지 출력
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            // 무작위 3자리 수 생성
            int[] randomNumber = selectRandomNumbers();
            boolean gameWon = false;

            while (!gameWon) {
                // 사용자 입력 받기
                int[] userNumber = getUserInput();
                // 결과 계산
                int[] result = calculateResult(randomNumber, userNumber);
                // 결과 출력
                printResult(result);

                // 3스트라이크인 경우 게임 종료
                if (result[1] == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    gameWon = true;
                }
            }

            // 게임 재시작 또는 종료 여부 확인
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String choice = Console.readLine();
            if ("2".equals(choice)) {
                System.out.println("게임을 종료합니다. 감사합니다!");
                break;
            }
        }
    }

    // 무작위 3자리 수 생성
    static int[] selectRandomNumbers() {
        int[] randomNumber = new int[3];
        for (int i = 0; i < 3; i++) {
            randomNumber[i] = Randoms.pickNumberInRange(1, 9);
            for (int j = 0; j < i; j++) {
                // 중복된 숫자 방지
                if (randomNumber[j] == randomNumber[i]) {
                    i--; // 다시 생성
                    break;
                }
            }
        }
        return randomNumber;
    }

    // 사용자 입력 받기
    static int[] getUserInput() {
        System.out.print("숫자를 입력해주세요: ");
        String input = Console.readLine();
        // 입력값 유효성 검사
        if (input.length() != 3 || !input.matches("[1-9]{3}")) {
            throw new IllegalArgumentException("서로 다른 3자리의 수를 입력해야 합니다.");
        }
        int[] digits = new int[3];
        for (int i = 0; i < 3; i++) {
            digits[i] = Character.getNumericValue(input.charAt(i));
        }
        return digits;
    }

    // 결과 계산
    static int[] calculateResult(int[] randomNumber, int[] userNumber) {
        int[] result = new int[2];
        for (int i = 0; i < 3; i++) {
            if (randomNumber[i] == userNumber[i]) {
                result[1]++; // 스트라이크
            } else {
                for (int j = 0; j < 3; j++) {
                    if (randomNumber[i] == userNumber[j]) {
                        result[0]++; // 볼
                        break;
                    }
                }
            }
        }
        return result;
    }

    // 결과 출력
    static void printResult(int[] result) {
        if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println(result[0] + "볼 " + result[1] + "스트라이크");
        }
    }
}
