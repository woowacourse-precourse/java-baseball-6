package baseball.domain;


import java.util.List;

public class Baseball {

    private final List<Integer> computerNumber;

    public Baseball(List<Integer> computerNumber) {
        this.computerNumber = computerNumber;
    }

    public int countStrikes(List<Integer> playerNumber) {
        int strikes = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumber.get(i).equals(playerNumber.get(i))) {
                strikes++;
            }
        }
        return strikes;
    }


    public int countBalls(List<Integer> playerNumber) {
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            int playerDigit = playerNumber.get(i);
            if (computerNumber.contains(playerDigit) && computerNumber.indexOf(playerDigit) != i) {
                balls++;
            }
        }
        return balls;
    }
}
