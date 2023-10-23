package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private List<Integer> inputList;
    private InputManager inputManager;
    private static final int ORIGINCOUNT = 3;

    public Input() {
        System.out.print("숫자를 입력해주세요 : " );
    }

    protected void printGameStartMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

//    protected List<Integer> getUserInput(){
//        String input = Console.readLine();
////        this.inputManager = new InputManager(input);
////        inputManager.validateInput();
////        inputList = convertList(input);
////        return this.inputList;
//    }

    public List<Integer> convertList(String input) {
        List<Integer> userInput = new ArrayList<>();
        for (int i = 0; i < ORIGINCOUNT; i++) {
            userInput.add(input.charAt(i) - '0');
        }
        return userInput;
    }

}
