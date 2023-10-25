package baseball.Io;

import baseball.validation.InputValidation;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {
    public static List<Integer> numbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        InputValidation.numbers(input);

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            numbers.add(Integer.parseInt(input.charAt(i) + ""));
        }
        return numbers;
    }

    public static boolean endCommand() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        InputValidation.endCommand(input);
        return "1".equals(input);
    }
}
