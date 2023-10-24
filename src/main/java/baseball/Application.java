package baseball;

import java.util.Random;
import java.util.Scanner;

public class Application {
    private static int[] computerNumbers;
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            //컴퓨터가 무작위 숫자를 생성
            computerNumbers = randomNumbers();

            //사용자에게 숫자를 입력 받고 판정 진행
            gameStart();

            //게임이 끝나고 다음 게임 시작 혹은 게임 종료 선택지 출력
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice == 2) {
                break;
            }
        }
    }

    //컴퓨터가 무작위 숫자를 생성
    private static int[] randomNumbers() {
        Random random = new Random();
        int[] numbers = new int[3];

        // 서로 다른 3개의 수를 생성하고 배열에 저장
        for (int i = 0; i < 3; i++) {
            int num;
            do {
                num = random.nextInt(9) + 1;
            } while (contains(numbers, num));
            numbers[i] = num;
        }
        return numbers;
    }

    //배열에 숫자가 포함되어 있는지 확인
    private static boolean contains(int[] array, int value) {
        for (int num : array) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }

    //사용자에게 숫자를 입력 받고 판정 진행
    private static void gameStart() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");

            int[] userNumbers = new int[3];
            int input = scanner.nextInt();

            if (input < 100 || input > 999) {
                throw new IllegalArgumentException("3자리 수를 입력하세요.");
            }

            userNumbers[0] = input / 100;
            userNumbers[1] = (input % 100) / 10;
            userNumbers[2] = input % 10;

            int strikes = 0;
            int balls = 0;

            for (int i = 0; i < 3; i++) {
                if (userNumbers[i] == computerNumbers[i]) {
                    strikes++;
                } else if (contains(computerNumbers, userNumbers[i])) {
                    balls++;
                }
            }

            if (strikes > 0 && balls > 0) {
                System.out.println(strikes + "스트라이크 " + balls + "볼");
            } else if (strikes > 0) {
                System.out.println(strikes + "스트라이크");
            } else if (balls > 0) {
                System.out.println(balls + "볼");
            } else {
                System.out.println("낫싱");
            }

            if (strikes == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                computerNumbers = randomNumbers(); // 게임 종료 후 새로운 게임을 위해 컴퓨터의 숫자를 재설정
                break;
            }
        }
    }
}
