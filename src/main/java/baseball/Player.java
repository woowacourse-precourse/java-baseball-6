package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    public static final int TRUE_NUMBER = 1;

    private Validate validate = Validate.getInstance();
    ;

    /**
     * 사용자에게 서로 다른 숫자 3개를 입력 문자, 서로 같은 숫자 경우 IllegalArgumentException
     */
    public List<Integer> getInput() throws IllegalArgumentException {
        String input = Console.readLine();
        return getInput(input);
    }

    public List<Integer> getInput(String input) throws IllegalArgumentException {
        String[] inputSplit = input.split("");
        validate.validate(inputSplit);

        List<Integer> inputNumbers = new ArrayList<>();
        for (String s : inputSplit) {
            inputNumbers.add(Integer.parseInt(s));
        }

        checkDuplicationNumber(inputNumbers);
        return inputNumbers;
    }

    private void checkDuplicationNumber(List<Integer> inputNumbers) {
        Set<Integer> inputNumbersSet = new HashSet<>(inputNumbers);
        validate.validate(inputNumbersSet);
    }

    /**
     * 사용자에게 재시작 여부를 1(재시작), 2(종료) 1, 2 이외의 숫자를 입력한 경우 IllegalArgumentException
     */
    public boolean getRestart() throws IllegalArgumentException {
        String input = Console.readLine();
        return getRestart(input);
    }

    public boolean getRestart(String input) throws IllegalArgumentException {
        validate.validate(input);
        int inputNumber = Integer.parseInt(input);
        validate.validate(inputNumber);
        if (inputNumber == TRUE_NUMBER) {
            return true;
        } else {
            return false;
        }
    }

}
