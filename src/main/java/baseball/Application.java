package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    private static final String START = "1";
    private static final String END = "2";
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean continueGame = true;

        while (continueGame) {
            String userChoice = playGame();

            if (userChoice.equals(START)) {
                continueGame = true;
            } else if (userChoice.equals(END)) {
                continueGame = false;
            } else {
                throw new IllegalArgumentException("Invalid input " + userChoice);
            }
        }
    }

    private static String playGame() {
        List<Integer> computer = generateComputer();
        System.out.println(computer.toString());
        while (true) {
            String inputNumber = getUserInput("숫자를 입력해주세요 : ");
            checkInputNumber(inputNumber);

            int[] strikeAndBall = calculateStrikeBall(computer,inputNumber);
            String result = printStrikeBall(strikeAndBall[0],strikeAndBall[1]);
            System.out.println(result);

            if (result.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return getUserInput("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            }
        }
    }
    public static List<Integer> generateComputer() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    private static int[] calculateStrikeBall(List<Integer> computer, String inputNumber) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < computer.size(); i++) {
            int digit = Character.getNumericValue(inputNumber.charAt(i));

            if (computer.get(i).equals(digit)) {
                strike++;
            } else if (computer.contains(digit)) {
                ball++;
            }
        }
        return new int[]{strike, ball};
    }
    private static String printStrikeBall(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        } else if (strike == 0) {
            return ball + "볼";
        } else if (ball == 0) {
            return strike + "스트라이크";
        } else {
            return ball + "볼 " + strike + "스트라이크";
        }
    }
    private static void checkInputNumber(String inputNumber) {
        String numberRegex = "^[1-9]+$";

        if (!inputNumber.matches(numberRegex)) {
            throw new IllegalArgumentException("Not a valid number: " + inputNumber);
        }

        if (inputNumber.length()!= 3) {
            throw new IllegalArgumentException("Invalid input number length : " + inputNumber);
        }

        Set<Character> uniqueDigits = new HashSet<Character>();

        for (char c : inputNumber.toCharArray()) {
            if (!uniqueDigits.add(c)) {
                throw new IllegalArgumentException("Duplicate digits in the input number: " + inputNumber);
            }
        }
    }
    private static String getUserInput(String prompt) {
        System.out.println(prompt);
        return Console.readLine();
    }
}
