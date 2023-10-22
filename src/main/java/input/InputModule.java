package input;

import camp.nextstep.edu.missionutils.Console;
import validate.GameInputValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputModule {
    private List<Integer> inputList;
    private GameInputValidator gameInputValidator;
    private int inputInt;

    public InputModule() {
        inputList = new ArrayList<>();
        gameInputValidator = new GameInputValidator();
        inputInt = 0;
    }

    public List<Integer> getInputList() {
        return new ArrayList<>(inputList);
    }
    public void setInputList(){
        String input =  Console.readLine();
        gameInputValidator.validate(input);
        this.inputList = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int getInputInt() {
        return inputInt;
    }

    public void setInputInt() {
        this.inputInt = Integer.parseInt(Console.readLine());
    }
}