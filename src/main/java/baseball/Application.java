package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int choice;

        do {
            int[] computerNumber = generateRandomNumber();
            System.out.println("숫자야구 게임을 시작합니다!");
            playGame(computerNumber);

            System.out.println("게임을 계속하려면 1을, 종료하려면 2를 입력하세요: ");
            choice = Console.readLineAsInt();

        } while (choice == 1);
        System.out.println("게임을 종료합니다.");
    }

    // 랜덤한 세 자리 숫자 생성
    public static int[] generateRandomNumber() {
        int[] number = new int[3];
        for (int i = 0; i < 3; i++) {
            number[i] = Randoms.pickNumberInRange(1, 9);
            for (int j = 0; j < i; j++) {
                if (number[j] == number[i]) {
                    i--;
                    break;
                }
            }
        }
        return number;
    }

    // 나머지 코드는 이전과 동일합니다.

    // playGame 메서드 추가
    public static void playGame(int[] computerNumber) {
        int attempts = 0;
        while (true) {
            System.out.print("세 자리 숫자를 입력하세요: ");
            String userInput = Console.readLine();

            try {
                if (!isValidInput(userInput)) {
                    throw new IllegalArgumentException("올바른 입력이 아닙니다. 세 자리 숫자를 입력하세요.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            int[] userNumber = convertInputToNumber(userInput);
            int[] result = calculateResult(computerNumber, userNumber);

            if (result[0] == 0 && result[1] == 0) {
                System.out.println("낫싱");
            } else {
                if (result[0] > 0) {
                    System.out.print(result[0] + " 스트라이크 ");
                }
                if (result[1] > 0) {
                    System.out.print(result[1] + " 볼 ");
                }
                System.out.println();
            }

            attempts++;

            if (result[0] == 3) {
                System.out.println("축하합니다! " + attempts + "번 만에 맞추셨습니다.");
                break;
            }
        }
    }
}



