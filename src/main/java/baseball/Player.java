package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Player {
    public List<Integer> getNumbers() {
        List<Integer> numberList = new ArrayList<>();
        System.out.println("숫자를 입력해주세요 : ");
        String inputNumber = Console.readLine();
        if(isValidateInput(inputNumber)) {
            numberList = stringToList(inputNumber);
        }
        return numberList;
    }

    private List<Integer> stringToList(String inputNumber) {
        List<Integer> numberList = new ArrayList<>();
        for(int i = 0; i < inputNumber.length(); i++) {
            numberList.add(Integer.parseInt(String.valueOf(inputNumber.charAt(i))));
        }
        return numberList;
    }

    private boolean isValidateInput(String inputNumber) {
        if(!isLengthThree(inputNumber)) {
            throw new IllegalArgumentException("3자리 숫자를 입력해야 합니다.");
        }
        if(!isNumber(inputNumber)) {
            throw new IllegalArgumentException("1부터 9까지의 자연수를 입력해야 합니다.");
        }
        if(!isAllDifferent(inputNumber)) {
            throw new IllegalArgumentException("중복되지 않는 숫자를 입력해야 합니다.");
        }

        return true;
    }

    private boolean isAllDifferent(String inputNumber) {
        LinkedHashSet<Integer> numberSet = new LinkedHashSet<>();
        for(int i = 0; i < inputNumber.length(); i++) {
            numberSet.add(Integer.parseInt(String.valueOf(inputNumber.charAt(i))));
        }
        if(numberSet.size() != 3) {
            return false;
        }
        return true;
    }

    private boolean isNumber(String inputNumber) {
        for(int i = 0; i < inputNumber.length(); i++) {
            if(inputNumber.charAt(i) < '1' || inputNumber.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    private boolean isLengthThree(String inputNumber) {
        return inputNumber.length() == 3;
    }
}