package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Readline {
    Compare compare = new Compare();

    public List<Integer> ReadPlayerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return compare.CheckInput(input);
    }
}
