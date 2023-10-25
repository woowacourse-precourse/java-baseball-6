package baseball.domain.player;

import static baseball.domain.script.Script.GAME_END;
import static baseball.domain.script.Script.GAME_RESTART;
import static baseball.domain.script.Script.NUMS_INPUT;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class PlayerService {
    private final Player player;

    public PlayerService(Player player) {
        this.player = player;
    }

    public Player getPlayerInput() {
        System.out.print(NUMS_INPUT.getMessage());
        List<Integer> numbers = new ArrayList<>();
        String numberLine = readLine();
        playerInputError(numberLine);
        for (int i = 0; i < 3; i++) {
            numbers.add(numberLine.charAt(i) - '0');
        }
        player.updateNumbers(numbers);
        return player;
    }

    public boolean getPlayerEnd() {
        System.out.println(GAME_END.getMessage());
        System.out.println(GAME_RESTART.getMessage());
        int n = Integer.parseInt(readLine());
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        throw new IllegalArgumentException();
    }

    public void playerInputError(String line) {
        if (line.length() != 3) {
            throw new IllegalArgumentException("Invalid Length");
        }
        int[] numberList = new int[3];
        for (int i = 0; i < 3; i++) {
            int number = line.charAt(i) - '0';
            numberList[i] = number;
            if (!(number >= 1 && number <= 9)) {
                throw new IllegalArgumentException("Invalid Number");
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = i + 1; j < 2; j++) {
                if (numberList[i] == numberList[j]) {
                    throw new IllegalArgumentException("Invalid Same Number");
                }
            }
        }
    }
}
