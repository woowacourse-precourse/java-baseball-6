package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;

public class InputOutputHandler {

    public List<Integer> inputUniqueNumbers(int numberLength) {
        String input = Console.readLine();
        if(
                input.length() != numberLength ||
                        isNumeric(input) ||
                hasDuplicateCharacters(input)
        )
            throw new IllegalArgumentException("오류발생");

        return input.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }

    public int inputOneNumber() {
        String input = Console.readLine();
        if(input.length() != 1 || isNumeric(input))
            throw new IllegalArgumentException("오류발생");

        return Integer.parseInt(input);
    }

    public void printText(String text) {
        System.out.print(text);
    }

    public void printlnText(String text) {
        System.out.println(text);
    }

    private boolean isNumeric(String str) {
        return !str.matches("\\d+");
    }

    private boolean hasDuplicateCharacters(String str) {
        return str.length() != str.chars().distinct().count();
    }


}
