package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import util.GameMessage;

public class GameView {
    private List<Integer> userNumbers = new ArrayList<>();

    public void startGameView() {
        System.out.println(GameMessage.START_MESSAGE);
    }

    public String userInput() {
        System.out.print(GameMessage.NUMBER_INPUT_MESSAGE);
        String userInput = Console.readLine();
        return userInput;
    }

}
