package baseball;

import java.util.HashSet;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        while (true) {
            int targetNumber = generateRandomNumber();
            boolean gameWon = false;

            System.out.println("숫자 야구 게임을 시작합니다.");

            while (!gameWon) {
                System.out.print("숫자를 입력해주세요 : ");
                String userInput = readLine();

                try {
                    if (isValidInput(userInput)) {
                        int guess = Integer.parseInt(userInput);
                        int result = checkGuess(targetNumber, guess);
                        int strikes = result / 10;
                        int balls = result % 10;

                        if (strikes == 3) {
                            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                            gameWon = true;
                        }
                        else if (result == 0) {
                            System.out.println("낫싱");
                        }
                        else {
                            if (strikes == 0) {
                                System.out.println(balls + "볼");
                            }
                            else if (balls == 0) {
                                System.out.println(strikes + "스트라이크");
                            }
                            else {
                                System.out.println(balls + "볼 " + strikes + "스트라이크");
                            }
                        }
                    }
                    else {
                        throw new IllegalArgumentException("잘못된 입력입니다.");
                    }
                } catch (NumberFormatException e) {
                    System.err.println(e.getMessage());
                    return;
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String playAgain = readLine().toLowerCase();

            if (!playAgain.equals("1")) {
                break;
            }
        }
    }

    private static int generateRandomNumber() {
        // 중복을 피하기 위해 HashSet을 사용합니다.
        HashSet<Integer> set = new HashSet<>();

        while (set.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            set.add(randomNumber);
        }

        Integer[] uniqueNumbers = set.toArray(new Integer[0]);

        int result = uniqueNumbers[0] * 100 + uniqueNumbers[1] * 10 + uniqueNumbers[2];

        return result;
    }

    private static boolean isValidInput(String input) {
        if (input.length() != 3) {
            return false;
        }
        for (char c : input.toCharArray()) {
            if (c < '1' || c > '9') {
                return false;
            }
        }
        return true;
    }

    private static int checkGuess(int target, int guess) {
        String targetStr = Integer.toString(target);
        String guessStr = Integer.toString(guess);
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (targetStr.charAt(i) == guessStr.charAt(i)) {
                strikes++;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (targetStr.contains(String.valueOf(guessStr.charAt(i))) && targetStr.charAt(i) != guessStr.charAt(i)) {
                balls++;
            }
        }

        return (strikes * 10) + balls;
    }
}