package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Readline {
    public List<Integer> ReadPlayerNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> playNumber = new ArrayList<>();
        String input = Console.readLine();

        for(String sliceInput: input.split("")){
            playNumber.add(Integer.parseInt(sliceInput));
        }
        return playNumber;
    }
}
