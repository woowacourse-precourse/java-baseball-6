package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Objects;

public class Input {
    public static ArrayList<Integer> inputNumber() {
        String input = Console.readLine();
        return validate(input);
    }

    private static ArrayList<Integer> validate(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리가 아님");
        }
        if (!isAllNumber(input)){
            throw new IllegalArgumentException("숫자가 아님");
        }
        ArrayList<Integer> numbers = convertToNumbers(input);
        if (!isAllDifferent(numbers)){
            throw new IllegalArgumentException("같은 숫자가 있음");
        }
        return numbers;
    }

    private static boolean isAllNumber(String input){
        for(int i = 0;i < input.length();i++){
            if (!Character.isDigit(input.charAt(i)) || input.charAt(i) == '0'){
                return false;
            }
        }
        return true;
    }

    private static ArrayList<Integer> convertToNumbers(String input){
        ArrayList<Integer> numbers = new ArrayList<>(3);
        for(int i = 0;i < 3;i++){
            int digit = Character.getNumericValue(input.charAt(i));
            numbers.add(digit);
        }
        return numbers;
    }
    private static boolean isAllDifferent(ArrayList<Integer> numbers){
        return !Objects.equals(numbers.get(0), numbers.get(1)) && !Objects.equals(numbers.get(1), numbers.get(2)) && !Objects.equals(numbers.get(0), numbers.get(2));
    }
}
