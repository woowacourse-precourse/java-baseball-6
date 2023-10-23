package baseball.view;
import static baseball.enums.MessageEnum.*;

import baseball.enums.MessageEnum;
import camp.nextstep.edu.missionutils.Console;


import baseball.dto.NumbersStringDto;

public class NumbersInputView {

    public static NumbersStringDto input() {
        System.out.print(INPUT_NUMBER);


        return new NumbersStringDto(Console.readLine());
    }
}
