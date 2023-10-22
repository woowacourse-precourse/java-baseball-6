package baseball;

import java.util.List;

public class GameService {

    public static final int MAX_DIGIT = 3;

    private int strike = 0;
    private int ball = 0;

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public boolean isAllNumberMatched() {
        return strike == MAX_DIGIT;
    }

    public void comparePlayerAndComputer(Player player, Computer computer) {
        List<Integer> playerList = player.getPlayerNumbers();
        List<Integer> computerList = computer.getComputerNumbers();

        computeStrike(playerList, computerList);
        computeBall(playerList, computerList);
    }

    private void computeStrike(List<Integer> playerList, List<Integer> computerList) {
        int newStrike = 0;
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i) == computerList.get(i)) {
                newStrike += 1;
            }
        }
        strike = newStrike;
    }

    private void computeBall(List<Integer> playerList, List<Integer> computerList) {
        int newBall = 0;
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i) != computerList.get(i) && computerList.contains(
                playerList.get(i))) {
                newBall += 1;
            }
        }
        ball = newBall;
    }
}
