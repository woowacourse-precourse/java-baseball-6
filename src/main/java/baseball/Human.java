package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Human extends Player{
    public List<Integer> setInput() {
        List<Integer> new_numbers = new ArrayList<>();
        String input;

        System.out.print("숫자를 입력해주세요 : ");
        input = Console.readLine();
        if(!checkInput(input))
            throw new IllegalArgumentException();

        new_numbers.add(input.charAt(0)-'0');
        new_numbers.add(input.charAt(1)-'0');
        new_numbers.add(input.charAt(2)-'0');

        return new_numbers;

    }
    private boolean checkInput(String input) {
        boolean[] checkedNumber = new boolean[10];
        if(input.length() != 3)
            return false;

        for(int i=0; i<3; i++) {
            if( '9' < input.charAt(i) || input.charAt(i) < '1')
                return false;
            if(checkedNumber[input.charAt(i)-'0'])
                return false;
            checkedNumber[input.charAt(i)-'0'] = true;
        }
        return true;
    }
}
