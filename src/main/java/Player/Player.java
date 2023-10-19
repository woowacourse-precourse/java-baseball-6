package Player;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> playerBaseballNumber;

    public List<Integer> inputPlayerNumber() {
        List<Integer> playerInputBaseballNumber = new ArrayList<>();
        String[] playerInput = Console.readLine().split("");
        for(int i = 0; i < 3; i++) {
            playerInputBaseballNumber.add(Integer.parseInt(playerInput[i]));
        }
        //TODO: 사용자 입력 검증 validatePlayerInput()
        setPlayerBaseballNumber(playerInputBaseballNumber);
        return playerInputBaseballNumber;
    }

    private void setPlayerBaseballNumber(List<Integer> playerBaseballNumber) {
        this.playerBaseballNumber = playerBaseballNumber;
    }
}
