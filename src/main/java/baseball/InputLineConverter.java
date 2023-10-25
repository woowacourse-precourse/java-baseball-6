package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class InputLineConverter {

    private final IllegalCheck illegalcheck = new IllegalCheck();

    public Optional<ArrayList<Integer>> stringToIntegerList() {
        ArrayList<Integer> ConvertedList = null;

        String inputLine = Console.readLine();
        if (illegalcheck.gameNumberAvailable(inputLine)) {
            ConvertedList = new ArrayList<>();
            for (char charNumber : inputLine.toCharArray()) {
                int numericValue = Character.getNumericValue(charNumber);
                ConvertedList.add(numericValue);
            }
        }

        return Optional.ofNullable(ConvertedList);
    }

    public Optional<Integer> commandNumber() {
        Integer convertedInteger = null;

        String inputLine = Console.readLine();
        if (illegalcheck.commandAvailable(inputLine)) {
            convertedInteger = Integer.parseInt(inputLine);
        }

        return Optional.ofNullable(convertedInteger);
    }

}
