package baseball;

import static baseball.Result.calculateResult;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    protected static void start(String randomNumber) {
        String userNumber;

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");

            userNumber = Console.readLine();
            inputValidation(userNumber);

            // 입력된 숫자에 대한 스트라이크, 볼, 낫싱 계산
            if (calculateResult(randomNumber, userNumber)) {
                return;
            }
        }
    }

    private static void inputValidation(String number) {
        try {
            Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        if (number.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    protected static boolean end() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int check = Integer.parseInt(Console.readLine());

        if (check == 1) {
            return false;
        } else if (check == 2) {
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
