package baseball.model;

public class TurnBasedPlay {
    public static ScoreBoard score;

    public static ScoreBoard CalculScore (int[] computer, int player) {
        score = new ScoreBoard();

        for (int i = computer.length - 1; i >= 0; i--) {
            int current = (player / (int)Math.pow(10, i)) % 10;

            for (int j = 0; j < computer.length; j++) {
                if (current == computer[j]) {
                    if (computer.length - i - 1 == j) {
                        score.strike++;
                    } else {
                        score.ball++;
                    }
                    break;
                }
            }
        }
        return score;
    }
}
