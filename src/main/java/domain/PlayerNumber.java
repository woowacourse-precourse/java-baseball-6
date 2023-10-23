package domain;

import camp.nextstep.edu.missionutils.Console;
import view.GameView;

import java.util.Arrays;
import java.util.List;

public class PlayerNumber {

    private static String playerNumber;
    public static boolean isWin = false;

    public static void inputPlayerNumber() {
        GameView.printInputMessage();
        NumberException.numberException(playerNumber = Console.readLine());
    }

    public List<Integer> getPlayerNumberToList() {
        return Arrays.stream(playerNumber.split("")).toList()
                .stream().mapToInt(Integer :: parseInt)
                .boxed().toList();
    }



}
