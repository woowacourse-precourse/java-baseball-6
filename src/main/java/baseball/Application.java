package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        while (true) {
            int[] randomNumber = CreatingRandomNumber.RandomNumber();
            // 결과 체크
            System.out.println("컴퓨터의 숫자: " + randomNumber[0] + randomNumber[1] + randomNumber[2]);

            System.out.println("숫자 야구 게임을 시작합니다.");

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String input = Console.readLine();

                int[] answer = StringInputToInt.stringInputToInt(input);

                // 입력 값과 랜덤값 비교
                int[] result = checkAnswer(randomNumber, answer);
                // 결과 출력
                printAnswer(result);

                // 3스트라이크일 경우 게임 종료
                if (result[1] == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }


            }

            // 재시작, 종료 확인
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
            String choice = Console.readLine();

            if (choice != "1") {
                break;
            }
        }
    }


    // 랜덤숫자랑 입력값 비교해서 볼이나 스트라이크 체크
    private static int[] checkAnswer(int[] randomNumber, int[] answer) {
        int[] result = {0, 0}; // {볼, 스트라이크}

        for (int i = 0; i < 3; i++) {
            if (randomNumber[i] == answer[i]) {
                result[1]++; // 스트라이크
            }
            else {
                for (int j = 0; j < 3; j++) {
                    if (randomNumber[i] == answer[j]) {
                        result[0]++; // 볼
                        break;
                    }
                }
            }
        }

        return result;
    }

    // 스트라이크나 볼 출력
    private static void printAnswer(int[] result) {
        if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
        } else if (result[0] > 0 && result[1] > 0) {
            System.out.println(result[0] + "볼 " + result[1] + "스트라이크");
        } else if (result[0] > 0) {
            System.out.println(result[0] + "볼");
        } else if (result[1] > 0) {
            System.out.println(result[1] + "스트라이크");
        }
    }
}
