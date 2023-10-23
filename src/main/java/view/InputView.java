package view;

import camp.nextstep.edu.missionutils.Console;
import domain.NumberException;

public class InputView {
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public static String inputPlayerNumbers() {
        System.out.println(INPUT_MESSAGE);
        String numbers = Console.readLine();
        NumberException.numberException(numbers);
        return numbers;
    }




}
