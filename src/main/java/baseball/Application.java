package baseball;
import java.util.Scanner;
import java.util.Random;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Random random = new Random();
        int[] digits = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] randomNumber = new int[3];
        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(10 - i);  // 8
            randomNumber[i] = digits[index];  // 첫번째 숫자는 8
            System.out.print(randomNumber[i]);
        }

        System.out.println();
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해 주세요 : ");  //서로 다른 임의의 수 3개 입력
        Scanner scanner = new Scanner(System.in);
        int InputNumber = scanner.nextInt();

        int digit1 = InputNumber / 100;
        int digit2 = (InputNumber % 100) / 10;
        int digit3 = (InputNumber % 100) % 10;
        int[] ComputerNumber = {digit1, digit2, digit3};


        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (randomNumber[i] == ComputerNumber[j]) {
                    if (i == j) {
                        strikeCount++;
                        break;
                    } else {
                        ballCount++;
                        break;
                    }
                }
            }
        }

        if (ballCount > 0 && strikeCount > 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        } else if (ballCount > 0) {
            System.out.println(ballCount + "볼 ");
        } else if (strikeCount > 0) {
            System.out.println(strikeCount + "스트라이크");
        }

        scanner.close();
    }
}


