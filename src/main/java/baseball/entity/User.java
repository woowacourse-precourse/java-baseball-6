package baseball.entity;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
public class User {
    private List<Integer> userNumber = new ArrayList<>();

    public List<Integer> inputNumber(){
        String input = Console.readLine();

        //사용자 입력이 세자리가 아닐 시
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        char[] charArr = input.toCharArray();
        List<Integer> inputList = new ArrayList<>();

        for (char c: charArr) {
            if (Character.isDigit(c)) {
                int number = Character.getNumericValue(c);
                if (number >= 0 && !inputList.contains(number)) {
                    inputList.add(number);
                } else { //1 - 9 사이의 수가 아니거나 중복 입력 시
                    throw new IllegalArgumentException();
                }
            } else {
                throw new IllegalArgumentException();
            }
        }

        if (inputList.size() != 3) {
            throw new IllegalArgumentException();
        }

        return inputList;
    }

}
