package baseball.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.constvalue.ConstValue.*;

public class InputValue {
    private String userNumbers;
    private String gameRestart;
    private final Validator validator = new Validator();

    public InputValue(){
        this.userNumbers="";
        this.gameRestart="";
    }

    public List<Integer> convertUserNumbers(){
        // 입력 검증
        validator.validateUserNumbers(this.userNumbers);

        // String -> List
        List<Integer> numbers = new ArrayList<>();

        for (char ch : userNumbers.toCharArray()){
            numbers.add(Character.getNumericValue(ch));
        }

        return numbers;
    }

    public boolean convertGameRestart(){
        validator.validateRestart(this.gameRestart);

        boolean userInput = true;

        if (this.gameRestart.equals(STOP)){
            userInput = false;
        }

        return userInput;
    }

    public void getUserNumbersInput() {
        this.userNumbers = Console.readLine();
    }

    public void getGameRestartInput() {
        this.gameRestart = Console.readLine();
    }

}
