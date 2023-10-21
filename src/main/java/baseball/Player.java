package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {

    List<Integer> saveThreeNumbers = new ArrayList<>(3);

    public List<Integer> getNumbers() {
        String inputText = Console.readLine();
        saveThreeNumbers = Validator.checkThreeNumbers(inputText);

        return saveThreeNumbers;
    }
}
