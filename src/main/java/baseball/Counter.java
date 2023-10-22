package baseball;

import java.util.List;
import java.util.stream.IntStream;

public class Counter {
    private final List<Integer> computerNumber;
    private final List<Integer> playerNumber;

    public Counter(ComputerNumber computerNumber, PlayerNumber playerNumber) {
        this.computerNumber = computerNumber.getComputerNumber();
        this.playerNumber = playerNumber.getPlayerNumber();
    }

    public int countBalls() {
        // 같은 자리에 있는 컴퓨터넘버와 플레이어넘버기 서로 같지 않고, 컴퓨터넘버에 플레이어넘버가 포함되는 경우
        return (int) IntStream.range(0, 3)
                .filter(i -> !computerNumber.get(i).equals(playerNumber.get(i)) && computerNumber.contains(
                        playerNumber.get(i))).count();
    }

    public int countStrikes() {
        // 같은 자리에 있는 컴퓨터넘버와 플레이어넘버가 서로 같은 경우
        return (int) IntStream.range(0, 3).filter(i -> computerNumber.get(i).equals(playerNumber.get(i)))
                .count();
    }
}
