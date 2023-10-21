package baseball;

public class Referee {
    public int getStrikeCount(String computer, String player) {
        int strikeCount = 0;
        for (int index = 0; index < computer.length(); index++) {
            if (isStrike(computer, player, index)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private boolean isStrike(String computer, String player, int index) {
        return computer.charAt(index) == player.charAt(index);
    }

    public int getBallCount(String computer, String player) {
        int ballCount = 0;
        for (int index = 0; index < computer.length(); index++) {
            if (isBall(computer, player, index)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private boolean isBall(String computer, String player, int index) {
        return (computer.charAt(index) != player.charAt(index)) && computer.contains(
                String.valueOf(player.charAt(index)));
    }
}