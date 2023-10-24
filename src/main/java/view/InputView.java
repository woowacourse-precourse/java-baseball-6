package view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String GAME_START_MESSAGE ="숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER= "숫자를 입력해주세요: ";
    List<Integer> userInputNumberList = new ArrayList<>();

    public void StartGameMessage() {
        System.out.println(GAME_START_MESSAGE); // 프로그램 시작
    }
    public void InputMessage() {
        System.out.println(INPUT_NUMBER); // 숫자입력 msg
    }

    public List<Integer> InputUserNumber() {
        while (userInputNumberList.size() < 3) {
            System.out.println(INPUT_NUMBER);
            String inputs = ValidateInputNumber(Console.readLine());
            for (int i = 0; i < inputs.length(); i++) {
                char input = inputs.charAt(i);
                if (!userInputNumberList.contains(input - '0')) {
                    userInputNumberList.add(Integer.valueOf(input - '0'));
                }
            }
        }
        return userInputNumberList;
    }

    public  String ValidateInputNumber(String inputs) {
        if (inputs.length() != 3) { // 3자리수 입력 안한 경우
            throw new IllegalArgumentException();
        }
        try { // int로 변경 불가인 경우
            Integer.parseInt(inputs);
        } catch (IllegalArgumentException e){
            throw e;
        }
        return inputs;
    }
}
