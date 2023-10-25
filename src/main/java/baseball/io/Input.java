package baseball.io;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.validation.Validation;
import java.util.ArrayList;
import java.util.List;

public class Input {
    private static final Validation validation = new Validation();

    public static List<Integer> playerInput(int dataType) {
        char[] player = readLine().toCharArray();
        validation.runValidation(player, dataType);
        return charIntoList(player);
    }


    private static List<Integer> charIntoList(char[] target) {
        List<Integer> convertedData = new ArrayList<>();

        for (char chr : target) {
            convertedData.add(chr - '0');
        }
        return convertedData;
    }
}