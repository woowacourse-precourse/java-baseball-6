package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class View {

    private static final String RETRY_NUMBER = "1";
    private static final String END_NUMBER = "2";

    public static List<Integer> getUserNumbers(int numberLength) {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> userInputNumbers = new ArrayList<>();
        try {
            String[] inputs = Console.readLine().split("");
            for (String numberStr : inputs) {
                int numberInt = Integer.parseInt(numberStr);
                if (userInputNumbers.contains(numberInt)) {
                    throw new IllegalArgumentException("중복된 수를 넣을 수 없습니다.");
                }
                userInputNumbers.add(numberInt);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력은 숫자여야 합니다.");
        }
        if (userInputNumbers.size() != numberLength) {
            throw new IllegalArgumentException(numberLength + "자리 수여야 합니다.");
        }
        return userInputNumbers;
    }

    public static boolean askRetry() {
        System.out.println("게임을 새로 시작하려면 " + RETRY_NUMBER + ", 종료하려면 " + END_NUMBER + "를 입력하세요.");
        String putNumber = Console.readLine();
        if (putNumber.equals(RETRY_NUMBER)) {
            return true;
        } else if (putNumber.equals(END_NUMBER)) {
            return false;
        } else {
            throw new IllegalArgumentException(RETRY_NUMBER + "이나 " + END_NUMBER + "를 입력하세요.");
        }
    }

    public static void printScore(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        }
        if (strikeCount == 0 && ballCount != 0) {
            System.out.println(ballCount + "볼");
        }
        if (strikeCount != 0 && ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
        }
        if (strikeCount != 0 && ballCount != 0) {
            System.out.print(ballCount + "볼 ");
            System.out.println(strikeCount + "스트라이크");
        }
    }

    public static void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printGameEnd(int numberLength) {
        System.out.println(numberLength + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
