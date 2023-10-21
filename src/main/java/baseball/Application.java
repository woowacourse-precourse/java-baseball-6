package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Application {
    public Application() {

    }

    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        try {
            boolean flag = true;
            while (flag) {
                System.out.println("숫자 야구 게임을 시작합니다.");
                String number = requestNumber();
                isThreeDigit(number);
                List<Integer> computerNumbers = generateComputerNumbers();
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                flag = isRestartGame();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            Console.close();
        }
    }

    private static String requestNumber() {
        System.out.print("숫자를 입력해 주세요 : ");
        String input = Console.readLine();
        return input;
    }

    private static void isThreeDigit(String input) {
        if (!Pattern.matches("^\\d{3}$", input)) {
            throw new IllegalArgumentException("입력값이 잘못 되었습니다.");
        }
    }

    private static List<Integer> generateComputerNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }

    private static boolean isRestartGame() {
        int input = readUserInput();
        validateInput(input);
        return input == 1;
    }

    private static int readUserInput() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 잘못 되었습니다.");
        }
    }

    private static void validateInput(int input) {
        if (input != 1 && input != 2) {
            throw new IllegalArgumentException("입력값이 잘못 되었습니다.");
        }
    }
}

