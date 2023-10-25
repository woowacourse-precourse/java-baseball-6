package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public List<Integer> getNumbers() {
        List<Integer> numberList = new ArrayList<>();
        System.out.println("숫자를 입력해주세요 : ");
        String inputNumber = Console.readLine();
        if(isValidateInput(inputNumber)) {
            numberList = changeToList(inputNumber);
        }
        return numberList;
    }
}