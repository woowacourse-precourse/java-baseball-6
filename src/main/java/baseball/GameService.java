package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.IntStream;

public class GameService {

    public static final int MAX_DIGIT = 3;

    private int strike = 0;
    private int ball = 0;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void startGame() {
        Computer computer = new Computer();
        while (!isAllNumberMatched()) {
            Player player = new Player();

            Information.printInputNumber();
            player.guessNumber(Console.readLine());

            comparePlayerAndComputer(player, computer);
            Information.printBallAndStrike(ball, strike);
        }
    }

    private boolean isAllNumberMatched() {
        return strike == MAX_DIGIT;
    }

    private void comparePlayerAndComputer(Player player, Computer computer) {
        List<Integer> playerList = player.getPlayerNumbers();
        List<Integer> computerList = computer.getComputerNumbers();

        computeStrike(playerList, computerList);
        computeBall(playerList, computerList);
    }

    public void computeStrike(List<Integer> playerList, List<Integer> computerList) {
        strike = (int) IntStream.range(0, playerList.size())
            .filter(i -> playerList.get(i).equals(computerList.get(i)))
            .count();
    }

    public void computeBall(List<Integer> playerList, List<Integer> computerList) {
        ball = (int) IntStream.range(0, playerList.size())
            .filter(i -> playerList.get(i) != computerList.get(i)
                && computerList.contains(playerList.get(i)))
            .count();
    }
}
