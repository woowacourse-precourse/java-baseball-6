package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        while (true) {
            boolean regame = playGame();
                if (!regame) {
                    break;
                }
            }
        }

    private static boolean playGame() throws IllegalArgumentException{
        List<Integer> computerNumber = new ArrayList<>();

            while (computerNumber.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computerNumber.contains(randomNumber)) {
                    computerNumber.add(randomNumber);
                }
            }

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            System.out.println("숫자를 입력해주세요 : ");

            int userInputNumber;

            try {
                userInputNumber = Integer.parseInt(readLine());

                if (userInputNumber < 100 || userInputNumber > 999 || !hasDifferentDigits(userInputNumber)) {
                    throw new IllegalArgumentException();
                }

            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }

            int strikes = 0;
            int balls = 0;

            List<Integer> userNumber = splitNumberToDigits(userInputNumber);

            for (int i = 0; i < 3; i++) {
                if (userNumber.get(i).equals(computerNumber.get(i))) {
                        strikes++;
                } else if (userNumber.contains(computerNumber.get(i))) {
                        balls++;
                }
            }

            if (strikes == 3) {
                System.out.println("3스트라이크\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return askForReplay();
            } else if (strikes == 0 && balls == 0) {
                System.out.println("낫싱");
            } else {
                    System.out.println(balls + "볼 " + strikes + "스트라이크");
            }
        }
    }


    private static List<Integer> splitNumberToDigits(int number) {
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int digit = number % 10;
            digits.add(0, digit);
            number /= 10;
        }
        return digits;
    }

    private static boolean hasDifferentDigits(int number) {
        int[] digits = new int[10];
        while (number > 0) {
            int digit = number % 10;
            if (digits[digit] > 0) {
                return false;
            }
            digits[digit]++;
            number /= 10;
        }
        return true;
    }

    private static boolean askForReplay() {
        System.out.println("다시 하려면 1, 종료하려면 2를 누르세요: ");
        String input = Console.readLine();
        return "1".equals(input);
    }
}