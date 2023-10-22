package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int NUM_DIGITS = 3;

    public static void main(String[] args) {
        boolean isGameRunning = true;
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (isGameRunning) {
            playGame();

            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int userAnswer = Integer.parseInt(Console.readLine());
            isGameRunning = (userAnswer == 1);
        }
    }

    private static void playGame() {
        List<Integer> computerRandomNumber = getComputerRandomNumber();

        while (true) {
            List<Integer> userGuessNumber = getUserGuessNumber();
            int[] result = getStrikeAndBallCount(computerRandomNumber, userGuessNumber);
            int strikeCount = result[0];
            int ballCount = result[1];
            printResult(strikeCount, ballCount);

            if (strikeCount == NUM_DIGITS) {
                System.out.printf("%d개의 숫자를 모두 맞혔습니다! 게임 종료\n", NUM_DIGITS);
                break;
            }
        }
    }

    private static void printResult(int strikeCount, int ballCount) {
        StringBuilder sb = new StringBuilder();

        if (ballCount > 0) {
            sb.append(ballCount).append("볼");
            if (strikeCount > 0) {
                sb.append(" ");
            } else {
                sb.append("\n");
            }
        }

        if (strikeCount > 0) {
            sb.append(strikeCount).append("스트라이크\n");
        }

        if (ballCount == 0 && strikeCount == 0) {
            sb.append("낫싱\n");
        }

        System.out.print(sb);
    }

    private static int[] getStrikeAndBallCount(List<Integer> computerRandomNumber, List<Integer> userGuessNumber) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < NUM_DIGITS; i++) {
            if (computerRandomNumber.get(i).equals(userGuessNumber.get(i))) {
                strikeCount++;
            } else if (computerRandomNumber.contains(userGuessNumber.get(i))) {
                ballCount++;
            }
        }

        return new int[]{strikeCount, ballCount};
    }

    private static List<Integer> getComputerRandomNumber() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < NUM_DIGITS) {
            int number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        return numbers;
    }

    private static List<Integer> getUserGuessNumber() {
        try {
            System.out.print("숫자를 입력해주세요 : ");
            String userInputString = Console.readLine();
            System.out.print(userInputString + "\n");

            if (userInputString.length() != NUM_DIGITS) {
                throw new IllegalArgumentException(String.format("%d개의 숫자를 입력하세요.", NUM_DIGITS));
            }

            List<Integer> userGuessNumberList = new ArrayList<>(NUM_DIGITS);
            for (char digit : userInputString.toCharArray()) {
                int number = Character.getNumericValue(digit);
                if (number < MIN_NUMBER || number > MAX_NUMBER) {
                    throw new IllegalArgumentException(String.format("%d에서 %d 사이의 숫자만 입력하세요.", MIN_NUMBER, MAX_NUMBER));
                }
                if (userGuessNumberList.contains(number)) {
                    throw new IllegalArgumentException("서로 다른 숫자만 입력하세요.");
                }
                userGuessNumberList.add(number);
            }
            return userGuessNumberList;
        } catch (Exception e) {
            throw new IllegalArgumentException("올바른 입력이 아닙니다.");
        }
    }
}
