package baseball.domain;

import baseball.utils.NumberUtils;
import baseball.utils.StringUtils;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;

public class InputOutputHandler {

    public List<Integer> inputUniqueNumbers(int numberLength) {
        String input = Console.readLine();

        if(input.length() != numberLength) throw new IllegalArgumentException(numberLength + "개의 숫자만 허용합니다.");
        if(!NumberUtils.isNumeric(input)) throw new IllegalArgumentException("숫자만 허용합니다.");
        if(StringUtils.hasDuplicateCharacters(input)) throw new IllegalArgumentException("중복된 숫자는 허용하지 않습니다.");


        return input.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }

    public int inputOneNumber() {
        String input = Console.readLine();
        if(input.length() != 1) throw new IllegalArgumentException("1개의 숫자만 허용합니다.");
        if(!NumberUtils.isNumeric(input)) throw new IllegalArgumentException("숫자만 허용합니다.");

        return Integer.parseInt(input);
    }

    public void printText(String text) {
        System.out.print(text);
    }

    public void printlnText(String text) {
        System.out.println(text);
    }


}
