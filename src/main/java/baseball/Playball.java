package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
public class Playball {
    public List<Integer> PlayersNumbersList() {

        System.out.println("숫자를 입력해주세요 : ");
        List<Integer> player_num_List = new ArrayList<>();
        String input  = Console.readLine();

        for(String number : input.split("")) {
            player_num_List.add(Integer.parseInt(number));
        }
        exception_Length(input);

        return player_num_List;
    }

    public void exception_Length(String a){
        if(a.length() != 3) {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다 : 세자리수로 입력해주십시오.");
        }
    }
}
