package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private List<Integer> playerNumber;

    public void generatePlayerNumber() {
        String str = Console.readLine();
        this.playerNumber = Arrays.stream(str.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> getPlayerNumber() {
        return playerNumber;
    }

}
