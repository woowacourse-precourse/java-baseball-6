package domain;

import camp.nextstep.edu.missionutils.Console;
import view.GameView;

import java.util.ArrayList;
import java.util.List;

public class PlayerNumber {

    List<Integer> playerNumbers = new ArrayList<>();

    public static void inputPlayerNumber() {
        GameView.printInputMessage();
        NumberException.numberException(Console.readLine());
    }



}
