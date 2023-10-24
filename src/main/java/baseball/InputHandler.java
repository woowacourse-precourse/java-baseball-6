package baseball;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public List<Integer> inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String number = Console.readLine();
        isValidNumber(number);
        return StringManipulator.strToArrayList(number);
    }

    public boolean choiceEndOrReInput() {
        String choice = Console.readLine();
        isValidEndOrInputChoice(choice);

        if (choice.equals("1")) {
            return false;
        } else if (choice.equals("2")) {
            return true;
        }
        return true;
    }

    private void isValidNumber(String number) {
        if (number.length() != 3) {
            throw new IllegalArgumentException("입력한 값이 3자리가 아닙니다");
        }
        if (!number.matches("^[1-9]*$")) {
            throw new IllegalArgumentException("입력한 값이 숫자가 아닙니다");
        }
        if (StringManipulator.hasDuplicates(number)) {
            throw new IllegalArgumentException("중복된 숫자를 입력하였습니다.");
        }
    }

    private void isValidEndOrInputChoice(String choice){
        if (!choice.equals("1") && !choice.equals("2")){
            throw new IllegalArgumentException("재시작과 종료 선택에 유효한 숫자가 아닙니다.");
        }
    }
}
