package baseball;

import java.util.ArrayList;
import java.util.List;

public class Parsing {
    public static List<Character> parseIntoList(String userInput) {

        List<Character> numbers = new ArrayList<>();

        for (int i = 0; i < userInput.length(); i++) {
            Character number = userInput.charAt(i);

            numbers.add(number);
        }

        return numbers;
    }
}
