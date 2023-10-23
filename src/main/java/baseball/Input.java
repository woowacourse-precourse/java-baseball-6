package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private List<Integer> inputList;
    private InputManager inputManager;
    private static final int INPUTSIZE = 3;

    public Input() {
        System.out.print("숫자를 입력해주세요 : " );
    }

    protected List<Integer> getUserInput(){
        String input = Console.readLine();
        this.inputManager = new InputManager(input);
        inputManager.validateInput();
        inputList = convertList(input);
        return this.inputList;
    }

    public List<Integer> convertList(String input) {
        List<Integer> userInput = new ArrayList<>();
        for (int i = 0; i < INPUTSIZE; i++) {
            userInput.add(input.charAt(i) - '0');
        }
        return userInput;
    }

}
