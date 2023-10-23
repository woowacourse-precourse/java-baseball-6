package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        playBaseballGame();
    }

    private static void playBaseballGame() {
        String gameCode;
        do {
            List<Integer> randomNumber = createRandomNumber();
            gameCode = checkUserNumber(randomNumber);
        } while (gameCode.equals("1"));
    }

    private static String checkUserNumber(List<Integer> randomNumber) {
        while (true) {
            List<Integer> userNumber = getUserNumber();
            int ball = 0;
            int strike = 0;

            for (int i = 0; i < 3; i++) {
                if (randomNumber.get(i).equals(userNumber.get(i))) {
                    strike += 1;
                } else if (randomNumber.contains(userNumber.get(i))) {
                    ball += 1;
                }
            }
            printResult(strike, ball);
            if (strike == 3) {
                break;
            }
        }
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return (Console.readLine());
    }

    private static void printResult(int strike, int ball) {
        if (strike == 3) {
            System.out.println(strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if ((ball > 0) && (strike > 0) && (strike < 3)) {
            System.out.println(ball + "볼" + " " + strike + "스트라이크");
        } else if (ball > 0) {
            System.out.println(ball + "볼");
        } else if (strike > 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println("낫싱");
        }
    }

    private static List<Integer> createRandomNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static List<Integer> getUserNumber() {
        List<Integer> userNumber = new ArrayList<>();
        String Number;
        String[] tempNumber;
        boolean isValid;

        System.out.print("숫자를 입력해주세요 : ");
        Number = Console.readLine();
        isValid = isValidNumber(Number);

        if (isValid) {
            tempNumber = Number.split("");
            for (String s : tempNumber) {
                userNumber.add(Integer.parseInt(s));
            }
        } else if (!isValid) {
            throw new IllegalArgumentException();
        }

        return userNumber;
    }

    private static boolean isValidNumber(String input) {
        if (input.length() != 3) {
            return false;
        }

        for (char ch : input.toCharArray()) {
            if (ch < '1' || ch > '9') {
                return false;
            }
        }

        if (input.charAt(0) == input.charAt(1)
                || input.charAt(0) == input.charAt(2)
                || input.charAt(1) == input.charAt(2)) {
            return false;
        }

        return true;
    }
}