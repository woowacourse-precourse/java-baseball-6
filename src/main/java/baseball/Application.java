package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {

    private boolean playAgain;

    public Application() {
        this.playAgain = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void start() {
        while (playAgain) {
            String computerNumber = generateComputerNumber();
            playRound(computerNumber);
            playAgain = askForAnotherGame();
        }
    }

    private static String generateComputerNumber() {
        StringBuilder numbers = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            String num;
            String numbersString = numbers.toString();
            do {
                num = String.valueOf(pickNumberInRange(1, 9));
            } while (numbersString.contains(num));

            numbers.append(num);
        }
        return numbers.toString();
    }

    private static void playRound(String computerNumber) {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String userNumber = readLine();

            validateUserNumber(userNumber);

            int s = 0, b = 0;
            String userNumberSubstring, computerNumberSubstring;

            for (int i = 0; i < userNumber.length(); i++) {
                userNumberSubstring = userNumber.substring(i, i + 1);
                computerNumberSubstring = computerNumber.substring(i, i + 1);

                if (computerNumberSubstring.equals(userNumberSubstring)) {
                    s++;
                } else if (computerNumber.contains(userNumberSubstring)) {
                    b++;
                }
            }

            printResult(s, b);

            if (userNumber.equals(computerNumber)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private static void printResult(int s, int b) {
        if (s > 0 && b > 0) {
            System.out.println(b + "볼 " + s + "스트라이크");
        }
        if (s > 0 && b == 0) {
            System.out.println(s + "스트라이크");
        }
        if (s == 0 && b > 0) {
            System.out.println(b + "볼");
        }
        if (s == 0 && b == 0) {
            System.out.println("낫싱");
        }
    }

    private static boolean askForAnotherGame() {
        boolean playAgain = true;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String playAgainCode = readLine();
        if (playAgainCode.equals("2")) {
            playAgain = false;
        }
        if (playAgainCode.equals("1")) {
            playAgain = true;
        }
        if (!(playAgainCode.equals("1") || playAgainCode.equals("2"))) {
            throw new IllegalArgumentException("1 또는 2를 입력하세요.");
        }
        return playAgain;
    }

    private static void validateUserNumber(String userNumber) {

        try {
            Integer.valueOf(userNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("문자가 아닌 숫자를 입력하세요.", e);
        }

        if (userNumber.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력하세요.");
        }

        if (userNumber.charAt(0) == userNumber.charAt(1) ||
                userNumber.charAt(1) == userNumber.charAt(2) ||
                userNumber.charAt(2) == userNumber.charAt(0)) {
            throw new IllegalArgumentException("서로 다른 3자리의 수를 입력하세요.");
        }
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.start();
    }
}