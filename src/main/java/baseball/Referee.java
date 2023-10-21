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
}