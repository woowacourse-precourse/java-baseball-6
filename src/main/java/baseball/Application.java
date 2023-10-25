package baseball;
import java.util.Scanner;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static int[] threeUniqueNumber() {
        int[] digits = new int[3];
        boolean isDuplicate;
        do {
            int number = Randoms.pickNumberInRange(100, 999);
            isDuplicate = false;

            digits[0] = number / 100;
            digits[1] = (number / 10) % 10;
            digits[2] = number % 10;

            for (int i = 0; i < 2; i++) {
                for (int j = i + 1; j < 3; j++) {
                    if (digits[i] == digits[j]) {
                        isDuplicate = true;
                        break;
                    }
                }
            }
        } while (isDuplicate);
        return digits;
    }
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        int gameContinue = 1;
        while (gameContinue == 1){
            int[] computerNum = threeUniqueNumber();

            while(true){
                System.out.print("숫자를 입력해주세요 : ");
                String userInput = Console.readLine();

                if (userInput.length() != 3 || !userInput.matches("[1-9]+")) {
                    throw new IllegalArgumentException("올바른 3자리 숫자를 입력하세요.");
                }

                int userDigits = Integer.parseInt(userInput);
                int[] userNum = new int[3];
                userNum[0] = userDigits / 100;
                userNum[1] = (userDigits / 10) % 10;
                userNum[2] = userDigits % 10;

                int ball = 0;
                int strike = 0;

                for (int i = 0; i < 3; i++) {
                    if (userNum[i] == computerNum[i]) {
                        strike++;
                    } else if (userNum[i] == computerNum[(i + 1) % 3] || userNum[i] == computerNum[(i + 2) % 3]) {
                        ball++;
                    }
                }

                if (ball > 0){
                    System.out.print(ball+"볼");
                    if (strike > 0){
                        System.out.println(" "+ strike + "스트라이크");
                    } else{
                        System.out.print("\n");
                    }
                } else if (strike > 0){
                    System.out.println(strike+"스트라이크");
                } else{
                    System.out.println("낫싱");
                }

                if (strike == 3){
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            Scanner sc = new Scanner(System.in);
            gameContinue = sc.nextInt();
        }

    }
}
