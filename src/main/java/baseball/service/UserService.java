package baseball.service;

import baseball.Util.Validator;
import baseball.constants.Baseball;
import baseball.constants.ErrorCode;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserService {
    private final Validator validator;

    public UserService(Validator validator) {
        this.validator = validator;
    }

    public List<Integer> getInput() {
        String input = Console.readLine();
        List<Integer> inputList = convertToList(input);
        validator.validateInput(inputList);

        return inputList;
    }

    private List<Integer> convertToList(String input) {
        try {
            return Arrays.stream(input.split(""))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.NOT_NUMERIC.toString());
        }
    }

    public Boolean askCommand() {
        Integer command = validator.validateCommand(Console.readLine());
        return command == Baseball.RESTART.getValue();
    }
}
