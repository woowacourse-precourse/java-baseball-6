package baseball.view;
import camp.nextstep.edu.missionutils.Console;


import baseball.dto.NumbersStringDto;

public class NumbersInputView {

    public static NumbersStringDto input() {
        System.out.print("숫자를 입력해주세요 : ");


        return new NumbersStringDto(Console.readLine());
    }
}
