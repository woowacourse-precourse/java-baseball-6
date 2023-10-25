package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            // 사용자가 입력한 숫자를 배열에 저장
            System.out.print("숫자를 입력해주세요 : ");
            int input = Integer.parseInt(Console.readLine());

            // 입력값이 세자리 수인지 확인
            if (input < 100 || input > 999) {
                throw new IllegalArgumentException();
            }

            // 입력값이 서로 다른 세자리 수인지 확인
            int[] digits = new int[3];
            digits[0] = input / 100;
            digits[1] = (input / 10) % 10;
            digits[2] = input % 10;
            if (digits[0] == digits[1] || digits[1] == digits[2] || digits[0] == digits[2]) {
                throw new IllegalArgumentException();
            }

            // 입력값이 확인이 끝나면 배열에 저장
            int[] userNumbers = new int[3];
            userNumbers[0] = input / 100;       // 백의 자리 수
            userNumbers[1] = (input / 10) % 10; // 십의 자리 수
            userNumbers[2] = input % 10% 10;    // 일의 자리 수

            int[] computerNumbers = new int[3];
            int index = 0;
            // 랜덤으로 숫자생성
            while (index < 3) {
                int randomNum = Randoms.pickNumberInRange(1, 9);
                boolean checkSame = false;
            // 인덱스 순서에 따라 숫자가 중복되지 않으면 computerNumbers에 저장
                for (int i = 0; i < index; i++) {
                    if (computerNumbers[i] == randomNum) {
                        checkSame = true;
                        break;
                    }
                }

                if (!checkSame) {
                    computerNumbers[index] = randomNum;
                    index++;
                }
            }

            boolean gameEnd = false;
            //스트라이크, 볼, 낫싱
            while (!gameEnd) {
                int strikes = 0;
                int balls = 0;
            //i번 째 자리가 같으면 스트라이크 갯수 증가 , 볼은 숫자가 다른 자리에 존재하는지 확인
                for (int i = 0; i < 3; i++) {
                    if (userNumbers[i] == computerNumbers[i]) {
                        strikes++;
                    } else if (contains(computerNumbers, userNumbers[i])) { //숫자가 다른 자리에 있는지 확인하고 볼 갯수 증가
                        balls++;
                    }
                }
                //스트라이크와 볼이 둘다 0일 경우 낫싱
                if (strikes == 0 && balls == 0) {
                    System.out.println("낫싱");
                } else {
                    StringBuilder message = new StringBuilder();

                    if (balls > 0) {
                        message.append(balls).append("볼 ");
                    }

                    if (strikes > 0) {
                        message.append(strikes).append("스트라이크");
                    }

                    System.out.println(message);
                }

                if (strikes == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    gameEnd = true;
                } else {
                    // 사용자가 제시한 숫자를 다시 입력받음
                    System.out.print("숫자를 입력해주세요 : ");
                    input = Integer.parseInt(Console.readLine());

                    // 입력값이 세자리 수인지 확인
                    if (input < 100 || input > 999) {
                        throw new IllegalArgumentException();
                    }

                    // 입력값이 서로 다른 세자리 수인지 확인
                    digits[0] = input / 100;
                    digits[1] = (input / 10) % 10;
                    digits[2] = input % 10;
                    if (digits[0] == digits[1] || digits[1] == digits[2] || digits[0] == digits[2]) {
                        throw new IllegalArgumentException();
                    }

                    // 입력값이 확인이 끝나면 배열에 저장
                    userNumbers[0] = input / 100;       // 백의 자리 수
                    userNumbers[1] = (input / 10) % 10; // 십의 자리 수
                    userNumbers[2] = input % 10% 10;    // 일의 자리 수
                }
            }

            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
            int choice = Integer.parseInt(Console.readLine());

            if (choice != 1) {
                break;
            }
        }
    }

    // 볼 갯수 확인하기, arr는 랜덤생성된 세자리 숫자이고 targetValue는 유저 입력값
    public static boolean contains(int[] arr, int targetValue) {
        for (int num : arr) {
            if (num == targetValue) {
                return true;
            }
        }
        return false;
    }
}
