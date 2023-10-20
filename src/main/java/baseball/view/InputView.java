package baseball.view;

import baseball.domain.GameNumber;
import baseball.util.Convertor;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    public GameNumber getUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        try {
            List<Integer> inputNumber = Convertor.convertStringToList(input);
            return new GameNumber(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

}
