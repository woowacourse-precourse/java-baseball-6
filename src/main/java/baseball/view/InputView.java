package baseball.view;

import baseball.domain.MyNumber;
import baseball.utils.Validator;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    Validator validator = new Validator();

    public void inputNumber(MyNumber myNumber) {
        printInputNumberMessage();
        String inputNumber = Console.readLine();
        validator.validateInputNumber(inputNumber);
        myNumber.setMyNumberList(splitStringToDigits(inputNumber));
    }

    public void printInputNumberMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public boolean inputPlayButton() {
        String playButton = Console.readLine();
        validator.validatePlayButton(playButton);
        return Integer.valueOf(playButton) == 1;
    }

    public List<Integer> splitStringToDigits(String inputNumber) {
        return Arrays.stream(inputNumber.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
