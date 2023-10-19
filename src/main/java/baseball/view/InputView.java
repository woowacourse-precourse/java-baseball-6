package baseball.view;

import baseball.util.TypeConvertor;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    public List<Integer> getInputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return TypeConvertor.stringToIntergerList(input);
    }
}
