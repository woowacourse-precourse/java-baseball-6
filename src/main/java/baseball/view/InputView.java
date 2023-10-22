package baseball.view;

import baseball.domain.MyNumber;
import baseball.utils.Validator;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_NUMBER_SPLIT_TO_DIGIT_REGEX = "";
    private static final String GAME_RESTART_VALUE = "1";

    Validator validator = new Validator();

    public void inputNumber(MyNumber myNumber) {
        printInputNumberMessage();
        String inputNumber = Console.readLine();
        validator.validateInputNumber(inputNumber);
        myNumber.setMyNumberList(splitStringToDigits(inputNumber));
    }

    public void printInputNumberMessage() {
        System.out.print(INPUT_NUMBER_MESSAGE);
    }

    public boolean inputPlayButton() {
        String playButton = Console.readLine();
        validator.validatePlayButton(playButton);
        return playButton.equals(GAME_RESTART_VALUE);
    }

    public List<Integer> splitStringToDigits(String inputNumber) {
        return Arrays.stream(inputNumber.split(INPUT_NUMBER_SPLIT_TO_DIGIT_REGEX))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
