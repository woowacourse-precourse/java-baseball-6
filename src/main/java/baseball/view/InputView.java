package baseball.view;

import baseball.util.Conversion;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import baseball.exception.InputException;

public class InputView {
    public ArrayList<Integer> numberInput() {
        System.out.print("숫자를 입력해주세요 :");
        String input = Console.readLine();
        InputException.validateInput(input);
        return Conversion.stringToArrayList(input);
    }

    public Integer restartInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        InputException.validateRestartInput(input);
        return Integer.parseInt(input);
    }
}
