package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        //  게임 시작 문구 출력
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean playAgain = true;
        while (playAgain) {
            int[] computerNumbers = generateRandomNumbers(); //  컴퓨터가 1~9까지 서로 다른 임의의 수 3개 선택
            int attempts = 0;

            while (true) {
                int[] userGuess = getUserGuess(); //  사용자 입력 받음
                attempts++;

                if (isCorrectGuess(computerNumbers, userGuess)) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료"); //  게임 종료 문구 출력
                    break;
                } else {
                    int[] result = calculateResult(computerNumbers, userGuess);
                    if (result[0] == 0 && result[1] == 0) {
                        System.out.println("낫싱"); //  결과 출력
                    } else {
                        System.out.println(result[1] + "볼 " + result[0] + "스트라이크"); 
                    }
                }
            }

            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
            int choice = Integer.parseInt(Console.readLine()); // 사용자 입력 받음
            if (choice == 2) {
                playAgain = false;
            }
        }

        System.out.println("게임을 종료합니다."); // 게임 종료 문구 출력
    }

    private static boolean isCorrectGuess(int[] computerNumbers, int[] userGuess) {
		return false;
	}

	//  컴퓨터가 1~9까지 서로 다른 임의의 수 3개 선택
    private static int[] generateRandomNumbers() {
        int[] computerNumbers = new int[3];
        int index = 0;
        while (index < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            boolean exists = false;
            for (int i = 0; i < index; i++) {
                if (computerNumbers[i] == randomNumber) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                computerNumbers[index] = randomNumber;
                index++;
            }
        }
        return computerNumbers;
    }

    //  사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 함
    private static int[] getUserGuess() {
        int[] userGuess = new int[3];
        while (true) {
            System.out.print("숫자를 입력해주세요: ");
            String input = Console.readLine();
            if (input.length() != 3) {
                System.out.println("3자리 숫자를 입력하세요.");
                //  잘못된 입력 시 예외 발생
                throw new IllegalArgumentException("3자리 숫자를 입력하세요.");
            }
            boolean validInput = true;
            for (int i = 0; i < 3; i++) {
                char c = input.charAt(i);
                if (c < '1' || c > '9') {
                    System.out.println("1부터 9 사이의 숫자만 입력하세요.");
                    //  잘못된 입력 시 예외 발생
                    throw new IllegalArgumentException("1부터 9 사이의 숫자만 입력하세요.");
                }
                userGuess[i] = c - '0';
            }
            if (validInput) {
                break;
            }
        }
        return userGuess;
    }

    //  프로그램 종료 시 System.exit()를 호출하지 않음

    //  테스트를 통해 프로그램이 예외를 올바르게 처리하는지 확인

    //  결과 출력
    private static int[] calculateResult(int[] computerNumbers, int[] userGuess) {
        int[] result = new int[2]; // result[0] - 스트라이크, result[1] - 볼
        for (int i = 0; i < 3; i++) {
            if (computerNumbers[i] == userGuess[i]) {
                result[0]++; // 스트라이크
            } else if (contains(computerNumbers, userGuess[i])) {
                result[1]++; // 볼
            }
        }
        return result;
    }

    //  숫자가 포함되어 있는지 확인
    private static boolean contains(int[] arr, int num) {
        for (int value : arr) {
            if (value == num) {
                return true;
            }
        }
        return false;
    }
}





