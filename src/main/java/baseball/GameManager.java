package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameManager {
    private static final int FIXED_PLAYER_NUMBERS_LENGTH = 3;
    private static final int NOTHING = 0;
    private static final int INCREMENT_VALUE = 1;
    private static final int WINNING_STRIKE_COUNT = 3;


    private static final char MIN_INPUT_VALUE = '1';
    private static final char MAX_INPUT_VALUE = '9';

    public static void validPlayerNumbers(String playerNumbers) {
        if (playerNumbers.length() != FIXED_PLAYER_NUMBERS_LENGTH) {
            throw new IllegalArgumentException("입력은 " + FIXED_PLAYER_NUMBERS_LENGTH + "자리 숫자이어야 합니다.");
        }

        char[] charNumbers = playerNumbers.toCharArray();
        Set<Character> uniqueCharNumbers = new HashSet<>();
        for (char charNumber : charNumbers) {
            if (charNumber < MIN_INPUT_VALUE || charNumber > MAX_INPUT_VALUE) {
                throw new IllegalArgumentException("입력의 각 자리 숫자는 " + MIN_INPUT_VALUE + "에서 " + MAX_INPUT_VALUE + " 사이의 정수이어야 합니다.");
            }
            if (uniqueCharNumbers.contains(charNumber)) {
                throw new IllegalArgumentException("입력의 각 자리 숫자는 서로 다른 숫자이어야 합니다.");
            }
            uniqueCharNumbers.add(charNumber);
        }
    }

    public static boolean compareNumbers(List<Integer> computerNumbers, String playerNumbers) {
        int strikeCount = NOTHING;
        int ballCount = NOTHING;
        for (int i=0; i<playerNumbers.length(); i++) {
            int playerNumber = playerNumbers.charAt(i) - '0';
            int computerNumber = computerNumbers.get(i);
            if (playerNumber == computerNumber) {
                strikeCount += INCREMENT_VALUE;
            }
            if (playerNumber != computerNumber && computerNumbers.contains(playerNumber)) {
                ballCount += INCREMENT_VALUE;
            }
        }
        printResult(strikeCount, ballCount);

        return checkThreeStrike(strikeCount);
    }

    private static void printResult(int strikeCount, int ballCount) {
        if (strikeCount != NOTHING && ballCount == NOTHING) {
            System.out.println(strikeCount + "스트라이크");
        }
        if (strikeCount == NOTHING && ballCount != NOTHING) {
            System.out.println(ballCount + "볼");
        }
        if (strikeCount != NOTHING && ballCount != NOTHING) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
        if (strikeCount == NOTHING && ballCount == NOTHING) {
            System.out.println("낫싱");
        }
    }

    private static boolean checkThreeStrike(int strikeCount) {
        if(strikeCount == WINNING_STRIKE_COUNT) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }
        return true;
    }
}