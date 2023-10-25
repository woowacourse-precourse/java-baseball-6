package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        boolean restart = true;

        while (restart) {
            // 랜덤으로 세 자리 숫자 생성
            int randomNumber = Randoms.pickNumberInRange(1, 999);

            int[] randomDigits = {
                    randomNumber / 100,        // 백의 자리수 추출
                    (randomNumber / 10) % 10,  // 십의 자리수 추출
                    randomNumber % 10          // 일의 자리수 추출
            };

            System.out.println("숫자 야구 게임을 시작합니다");
            System.out.print("숫자를 입력해주세요: ");
            String userInputString = Console.readLine();
            // 사용자로부터 세 자리 숫자 입력 받기
            int userInput = Integer.parseInt(userInputString);

            // 입력된 숫자와 랜덤 숫자 비교하여 스트라이크와 볼 판정
            int strike = 0;
            int ball = 0;

            int[] userInputDigits = {
                    userInput / 100,           // 백의 자리수 추출
                    (userInput / 10) % 10,    // 십의 자리수 추출
                    userInput % 10             // 일의 자리수 추출
            };

            for (int i = 0; i < 3; i++) {
                if (userInputDigits[i] == randomDigits[i]) {
                    strike++;
                } else {
                    for (int j = 0; j < 3; j++) {
                        if (userInputDigits[i] == randomDigits[j]) {
                            ball++;
                            break;
                        }
                    }
                }
            }

            // 결과 출력
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            } else if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
            } else if (strike > 0 && ball > 0) {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            } else if (strike > 0) {
                System.out.println(strike + "스트라이크");
            } else if (ball > 0) {
                System.out.println(ball + "볼");
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = Console.readLine();
            restart = input.equals("1");
        }

        System.out.println("종료합니다");
    }
}
