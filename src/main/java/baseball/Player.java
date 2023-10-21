package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {

    List<Integer> saveThreeNumbers = new ArrayList<>(3);

    public List<Integer> getNumbers() {
        String inputText = Console.readLine();

        for (int i = 0; i < 3; i++) {
            char convertChar = inputText.charAt(i);
            int convertInt = Character.getNumericValue(convertChar);
            saveThreeNumbers.add(convertInt);
        }

        return saveThreeNumbers;
    }
}
