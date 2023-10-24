package baseball.view;

import static baseball.util.StringNumToIntegerNumListParser.stringNumToIntegerNumListParser;

import baseball.exception.InputNumbersException;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInputView {
    private List<Integer> userGameNumbers = new ArrayList<>();
    private InputNumbersException inputNumbersException = new InputNumbersException();
    private String userInput;

    public List<Integer> setUserGameNumbers() {
        printQuestion();
        getUserInput();
        checkUserInputException(userInput);
        toIntegerList(userInput);
        return userGameNumbers;
    }

    public void printQuestion() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void getUserInput() {
        userInput = Console.readLine();
    }

    public void checkUserInputException(String userInput) {
        inputNumbersException.checkValidOfUserInput(userInput);
    }

    public void toIntegerList(String userInput) {
        userGameNumbers = stringNumToIntegerNumListParser(userInput);
    }
}