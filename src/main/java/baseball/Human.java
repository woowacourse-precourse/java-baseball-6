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
        if(!InputVerify.checkInput(input))
            throw new IllegalArgumentException();

        new_numbers.add(input.charAt(0)-'0');
        new_numbers.add(input.charAt(1)-'0');
        new_numbers.add(input.charAt(2)-'0');

        return new_numbers;
    }
}
