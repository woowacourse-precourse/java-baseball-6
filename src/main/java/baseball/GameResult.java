// GameResult.java
package baseball;

import java.util.List;

public class GameResult {
    private int strikes;
    private int balls;
    private boolean gameEnd;

    public GameResult(int strikes, int balls, boolean gameEnd) {
        this.strikes = strikes;
        this.balls = balls;
        this.gameEnd = gameEnd;
    }

    public static GameResult calculateResult(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (userNumbers.get(i).equals(computerNumbers.get(i))) {
                strikes++;
            } else if (computerNumbers.contains(userNumbers.get(i))) {
                balls++;
            }
        }

        boolean gameEnd = strikes == 3;

        return new GameResult(strikes, balls, gameEnd);
    }

    public void printResult() {
        if (strikes > 0 && balls > 0) {
            System.out.println(balls + "볼" + " " + strikes + "스트라이크");
        } else if (strikes > 0) {
            System.out.println(strikes + "스트라이크");
        } else if (balls > 0) {
            System.out.println(balls + "볼");
        } else {
            System.out.println("낫싱");
        }
    }

    public boolean isGameEnd() {
        return gameEnd;
    }
}
