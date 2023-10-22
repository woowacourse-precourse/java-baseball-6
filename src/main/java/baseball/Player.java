package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class Player {
    private String number;
    private List<Integer> playerNumber = new ArrayList<>();

    public Player(String number) {
        this.number = number;
        String[] str = Console.readLine().split("");

        for (int i = 0; i < 3; i++) {
            playerNumber.add(Integer.parseInt(str[i]));
        }
    }
}
