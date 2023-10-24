package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<Integer> numberList = new ArrayList<>();

    public Player() {
    }

    public void enterNumber() {
        String input = Console.readLine();
        InputValidator.checkPlayerInputFormat(input);
        setNumberList(input);
    }

    private void setNumberList(String input) {
        String[] inputList = input.split("");
        numberList.clear();
        for (String number : inputList) {
            numberList.add(Integer.parseInt(number));
        }
    }

    public List<Integer> getNumberList() {
        return numberList;
    }
}
