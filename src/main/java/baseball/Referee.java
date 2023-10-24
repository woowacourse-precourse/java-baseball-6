package baseball;

import static baseball.Constant.MAX_NUMBER_LENGTH;

public class Referee {
    public GameResult judge(Computer computer, Player player) {
        String computerNumbers = computer.getComputerNumbers();
        String playerNumbers = player.getPlayerNumbers();
        return new GameResult(getBallCount(computerNumbers, playerNumbers), getStrikeCount(computerNumbers, playerNumbers));
    }

    public int getStrikeCount(String computerNumbers, String playerNumbers) {
        int strikeCount = 0;
        for (int index = 0; index < MAX_NUMBER_LENGTH; index++) {
            if (isStrike(computerNumbers, playerNumbers, index)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private boolean isStrike(String computerNumbers, String playerNumbers, int index) {
        char computerDigit = computerNumbers.charAt(index);
        char playerDigit = playerNumbers.charAt(index);
        return computerDigit == playerDigit;
    }

    public int getBallCount(String computerNumbers, String playerNumbers) {
        int ballCount = 0;
        for (int index = 0; index < MAX_NUMBER_LENGTH; index++) {
            if (isBall(computerNumbers, playerNumbers, index)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private boolean isBall(String computerNumbers, String playerNumbers, int index) {
        char computerDigit = computerNumbers.charAt(index);
        char playerDigit = playerNumbers.charAt(index);
        return (computerDigit != playerDigit) &&
                computerNumbers.contains(String.valueOf(playerDigit));
    }
}