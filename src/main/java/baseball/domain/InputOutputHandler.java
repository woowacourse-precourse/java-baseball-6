package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;

public class InputOutputHandler {

    public List<Integer> inputUniqueNumbers(int numberLength) {
        String input = Console.readLine();
        if(!isNumeric(input) || hasDuplicateCharacters(input)) throw new IllegalStateException("오류발생");

        return input.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }

    public int inputNumber() {
        return -1;
    }

    public void printText(String text) {
        System.out.print(text);
    }

    public void printlnText(String text) {
        System.out.println(text);
    }

    private boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    private boolean hasDuplicateCharacters(String str) {
        return str.length() != str.chars().distinct().count();
    }


}
