package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;

public class ConsoleIO {

    private static ConsoleIO consoleIO;
    private ConsoleIO() {
    }

    public static List<Integer> insert() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine().chars()
                .mapToObj(ch -> (char) ch)
                .filter(Character::isDigit)
                .map(Character::getNumericValue)
                .collect(Collectors.toList());
    }
}
