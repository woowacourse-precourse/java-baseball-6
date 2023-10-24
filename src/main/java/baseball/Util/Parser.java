package baseball.Util;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static List<Integer> convertStringToArrayList(String input) {
        List<Integer> convertedInput = new ArrayList<Integer>();
        String[] inputElements = input.split("");
        for (String inputElement : inputElements) {
            int number = Integer.parseInt(inputElement);
            convertedInput.add(number);
        }
        return convertedInput;
    }
}
