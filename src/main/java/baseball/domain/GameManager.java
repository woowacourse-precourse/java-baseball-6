package baseball.domain;

import baseball.utils.MessagePrinter;
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

    private int strikeCount;
    private int ballCount;

    public void validPlayerNumbers(String playerNumbers) {
        if (playerNumbers.length() != FIXED_PLAYER_NUMBERS_LENGTH) {
            throw new IllegalArgumentException("입력은 " + FIXED_PLAYER_NUMBERS_LENGTH + "자리 숫자이어야 합니다.");
        }
        validPlayerNumbersBoundaryAndUnique(playerNumbers);
    }

    private void validPlayerNumbersBoundaryAndUnique(String playerNumbers) {
        char[] charNumbers = playerNumbers.toCharArray();
        Set<Character> uniqueCharNumbers = new HashSet<>();
        for (char charNumber : charNumbers) {
            validPlayerNumbersBoundary(charNumber);
            if (!uniqueCharNumbers.add(charNumber)) {
                throw new IllegalArgumentException("입력의 각 자리 숫자는 서로 다른 숫자이어야 합니다.");
            }
        }
    }

    private void validPlayerNumbersBoundary(char charNumber) {
        if (charNumber < MIN_INPUT_VALUE || charNumber > MAX_INPUT_VALUE) {
            throw new IllegalArgumentException(
                    "입력의 각 자리 숫자는 " + MIN_INPUT_VALUE + "에서 " + MAX_INPUT_VALUE + " 사이의 정수이어야 합니다.");
        }
    }

    public boolean compareNumbers(List<Integer> computerNumbers, String playerNumbers) {
        strikeCount = NOTHING;
        ballCount = NOTHING;
        for (int i = 0; i < playerNumbers.length(); i++) {
            int playerNumber = playerNumbers.charAt(i) - '0';
            int computerNumber = computerNumbers.get(i);
            checkStrikeAndBall(playerNumber, computerNumber, computerNumbers);
        }
        checkGameResult();
        return checkThreeStrike();
    }

    private void checkStrikeAndBall(int playerNumber, int computerNumber, List<Integer> computerNumbers) {
        if (playerNumber == computerNumber) {
            strikeCount += INCREMENT_VALUE;
        }
        if (playerNumber != computerNumber && computerNumbers.contains(playerNumber)) {
            ballCount += INCREMENT_VALUE;
        }
    }

    private void checkGameResult() {
        StringBuilder result = new StringBuilder();
        if (ballCount > NOTHING) {
            result.append(ballCount + "볼 ");
        }
        if (strikeCount > NOTHING) {
            result.append(strikeCount + "스트라이크");
        }
        if (strikeCount == NOTHING && ballCount == NOTHING) {
            result.append("낫싱");
        }
        MessagePrinter.printStrikeAndBallMessage(result.toString());
    }

    private boolean checkThreeStrike() {
        if (strikeCount == WINNING_STRIKE_COUNT) {
            MessagePrinter.printWinnerMessage();
            return false;
        }
        return true;
    }
}