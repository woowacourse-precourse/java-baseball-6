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
        return computerNumbers.charAt(index) == playerNumbers.charAt(index);
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
        return (computerNumbers.charAt(index) != playerNumbers.charAt(index)) &&
                computerNumbers.contains(String.valueOf(playerNumbers.charAt(index)));
    }
}