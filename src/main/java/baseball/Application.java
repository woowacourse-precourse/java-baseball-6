package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        while (true) {
            String s = playBaseballGame();
            if (s.length() != 1) throw new IllegalArgumentException("입력한 숫자는 1자리여야 합니다.");
            if (s.equals("1")) {
            } else if (s.equals("2")) {
                break;
            } else {
                throw new IllegalArgumentException("입력한 숫자는 1 또는 2 이어야 합니다");
            }

        }
    }
    public static String playBaseballGame() {
        int[] randomNumber = generateRandomNumber();
        int strikes = 0;
        int balls = 0;

            System.out.println("숫자 야구 게임을 시작합니다.");

            while (strikes != 3) {

            System.out.print("숫자를 입력해주세요: ");
            String inputNumber = Console.readLine();
            int[] inputNumber2Array = processInputNumber(inputNumber);

            strikes = calculateStrikes(inputNumber2Array, randomNumber);
            balls = calculateBalls(inputNumber2Array, randomNumber);

            printResult(strikes, balls);
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료 \n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

    private static int[] generateRandomNumber() {
        int[] randomNumber = new int[3];
        for (int i = 0; i < 3; i++) {
            randomNumber[i] = Randoms.pickNumberInRange(1, 9);
        }
        return randomNumber;
    }

    private static int[] processInputNumber(String inputNumber) {
        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException("입력한 숫자는 3자리여야 합니다.");
        }

        int[] inputNumber2Array = new int[3];
        for (int i = 0; i < 3; i++) {
            inputNumber2Array[i] = inputNumber.charAt(i) - '0';
        }
        return inputNumber2Array;
    }

    private static int calculateStrikes(int[] inputNumber, int[] randomNumber) {
        int strikes = 0;
        for (int i = 0; i < 3; i++) {
            if (inputNumber[i] == randomNumber[i]) {
                strikes++;
            }
        }
        return strikes;
    }

    private static int calculateBalls(int[] inputNumber, int[] randomNumber) {
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            if (contains(randomNumber, inputNumber[i]) && inputNumber[i] != randomNumber[i]) {
                balls++;
            }
        }
        return balls;
    }

    private static boolean contains(int[] array, int num) {
        for (int i : array) {
            if (i == num) {
                return true;
            }
        }
        return false;
    }

    private static void printResult(int strikes, int balls) {
        if (strikes > 0 && balls == 0) {
            System.out.println(strikes + "스트라이크");
        } else if (balls > 0 && strikes == 0) {
            System.out.println(balls + "볼");
        } else if (strikes > 0 && balls > 0) {
            System.out.println(balls + "볼 " + strikes + "스트라이크");
        } else {
            System.out.println("낫싱");
        }
    }
}
