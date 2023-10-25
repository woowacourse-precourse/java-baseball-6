package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    public static void main(String[] args) {
        while (true) {
            int[] computerNumber = randomComputerNumber();
            System.out.println("숫자 야구 게임을 시작합니다.");
            System.out.println();
            while (true) {
                int userNumber = insertUserNumber();
                int[] splitUserNumber = splitNumber(userNumber);
                int[] result = checkNum(computerNumber, splitUserNumber);
                System.out.println(resultPrint(result));
                if (result[0] == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int game = Integer.parseInt(Console.readLine());
            if (game == 2) {
                break;
            }
        }
    }

    public static int[] randomComputerNumber() {
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = Randoms.pickNumberInRange(1, 9);
            for (int j = 0; j < i; j++) {
                if (numbers[i] == numbers[j]) {
                    i--;
                    break;
                }
            }
        }
        return numbers;
    }

    public static int insertUserNumber() {
        while (true) {
            try {
                System.out.print("3자리 숫자를 입력해주세요 : ");
                int number = Integer.parseInt(Console.readLine());
                if (isValidUserNumber(number)) {
                    return number;
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static boolean isValidUserNumber(int number) {
        if (number >= 100 && number <= 999) {
            int[] digits = splitNumber(number);
            return digits[0] != digits[1] && digits[0] != digits[2] && digits[1] != digits[2];
        }
        return false;
    }

    public static int[] splitNumber(int number) {
        int[] num = new int[3];
        for (int i = 2; i >= 0; i--) {
            num[i] = number % 10;
            number /= 10;
        }
        return num;
    }

    public static int[] checkNum(int[] computerNumber, int[] userNumber) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumber[i] == userNumber[i]) {
                strike++;
            } else if (contains(computerNumber, userNumber[i])) {
                ball++;
            }
        }
        return new int[]{strike, ball};
    }

    public static boolean contains(int[] arr, int num) {
        for (int n : arr) {
            if (n == num) {
                return true;
            }
        }
        return false;
    }

    public static String resultPrint(int[] result) {
        int strike = result[0];
        int ball = result[1];
        String rs = "";
        if (strike == 0 && ball == 0) {
            return "낫싱";
        } else {
            if (ball > 0) {
                rs += ball + "볼 ";
            }
            if (strike > 0) {
                rs += strike + "스트라이크";
            }
        }
        return rs;
    }
}
