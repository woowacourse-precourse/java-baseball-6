package baseball;

import java.util.List;

public class GameService {

    private int strike = 0;
    private int ball = 0;

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
