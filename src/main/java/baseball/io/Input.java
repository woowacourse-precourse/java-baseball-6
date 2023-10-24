package baseball.io;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.validation.Validation;
import java.util.ArrayList;
import java.util.List;

public class Input {

    Validation validation = new Validation();


    public List<Integer> playerInput(int dataType) {
        char[] player = readLine().toCharArray();
        validation.runValidation(player, dataType);
        return charIntoList(player);
    }


    private List<Integer> charIntoList(char[] target) {
        List<Integer> convertedData = new ArrayList<>();

        for (char chr : target) {
            convertedData.add(chr - '0');
        }
        return convertedData;
    }
}