package view.processing;

import java.util.ArrayList;
import java.util.List;

public class Convertor {
    public List<Integer> convertStringToBaseballNumber(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char c : input.toCharArray()) {
            int number = Character.getNumericValue(c);
            numbers.add(number);
        }
        return numbers;
    }
    
}
