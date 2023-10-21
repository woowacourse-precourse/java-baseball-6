package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.utils.Utils;
import java.util.List;

public class InputView {
    public static List<Integer> inputBaseballNumbers() {
        List<Integer> playerNumbers = Utils.parseIntegerList(readLine());
        return playerNumbers;
    }

    public static int inputGameStateNumber() {
        int gameStateNumber = Integer.parseInt(readLine());
        return gameStateNumber;
    }
}
