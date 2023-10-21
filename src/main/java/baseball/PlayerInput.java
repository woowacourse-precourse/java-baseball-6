package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class PlayerInput {
    List<Integer> inputNumber;

    public PlayerInput(){
        String input = Console.readLine();
        String[] inputs = input.split("");

        List<Integer> numbers = new ArrayList<>();

        for (String str : inputs){
            int num = Integer.parseInt(str);
            numbers.add(num);
        }

        if (inputs.length == 3) {
            this.inputNumber = numbers;
        }else{
            throw new IllegalArgumentException();
        }
    }
}
