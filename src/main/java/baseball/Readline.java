package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Readline {
    public List<Integer> ReadPlayerNumber(){
        System.out.print("숫자를 입력해주세요 : ");

        List<Integer> playNumber = new ArrayList<>();
        String input = Console.readLine();

        int checkinput = Integer.parseInt(input);
        if(checkinput < 100 || checkinput > 999){
            throw new IllegalArgumentException("잘못된 값 입력 (3자리가 아닌 숫자)");
        }
        for(String sliceInput: input.split("")){
            playNumber.add(Integer.parseInt(sliceInput));
        }
        if(playNumber.get(0) == playNumber.get(1) || playNumber.get(1) == playNumber.get(2) || playNumber.get(0) == playNumber.get(2)){
            throw new IllegalArgumentException("잘못된 값 입력 (서로 다른 숫자가 아닌 3자리 숫자)");
        }
        return playNumber;
    }
}
