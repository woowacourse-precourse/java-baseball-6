package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Application {
    static int numberSize = 3;
    static int[] noCheck;
    public static void main(String[] args) {
        int start = 1;
        while (start == 1) {
            playBaseballGame();
            System.out.print("게임을 새로 시작 하려면 1, 종료 하려면 2를 입력 하세요.\n입력 : ");
            String input = Console.readLine();
            if (!input.equals("1") && !input.equals("2")) {
                throw new IllegalArgumentException("입력 값은 1 또는 2가 입력 되어야 합니다.");
            }
            start = Integer.parseInt(input);

        }

    }
    private static void playBaseballGame() {
        List<Integer> computerNumber = generateComputerNumber();
        boolean endGame = false;

        System.out.println("숫자 야구 게임을 시작 합니다.");
        while (!endGame) {
            System.out.print("숫자를 입력해 주세요 : ");
            String input = Console.readLine();
            if (!checkInputNumber(input)) {
                throw new IllegalArgumentException("서로 다른 " + numberSize + "개의 숫자가 입력 되어야 합니다.");
            }

            int strike = checkStrike(input, computerNumber);
            int ball = checkBall(input, computerNumber);
            if (printResult(ball, strike)) {
                endGame = true;
            }
        }
    }

    private static boolean checkInputNumber(String input) {
        return input.matches("^[1-9]{" + numberSize + "}$") && input.chars().distinct().count() == numberSize;
    }

    private static boolean printResult(int ball, int strike) {
        if (strike == numberSize) {
            System.out.println(strike + "스트라이크\n" + numberSize +  "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else if (ball > 0 && strike > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }

        return false;
    }

    public static List<Integer> generateComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < numberSize) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    private static int checkBall(String input, List<Integer> computerNumber) {
        int ballCount = 0;
            for (int i = 0; i < numberSize; i++) {
                if (noCheck[i] == 1) {
                    continue;
                }
                for (int j = 0; j < numberSize; j++) {
                    if (noCheck[i] == 1) {
                        continue;
                    }
                    if (computerNumber.get(i) == Integer.parseInt(String.valueOf(input.charAt(j)))) {
                        ballCount++;
                    }
                }
        }
        return ballCount;
    }

    private static int checkStrike(String input, List<Integer> computerNumber) {
        int strikeCount = 0;
        noCheck = new int[numberSize];
        for (int i = 0; i < numberSize; i++) {
            if (computerNumber.get(i) == Integer.parseInt(String.valueOf(input.charAt(i)))) {
                    strikeCount++;
                    noCheck[i] = 1;
            }
        }
        return strikeCount;
    }
}