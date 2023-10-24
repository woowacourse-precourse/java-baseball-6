package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Init_game {
    public List<Integer> player_num() {

        System.out.println("숫자를 입력해주세요 : ");
        List<Integer> player_num = new ArrayList<>();
        String input = Console.readLine();

        for(String number : input.split("")) {
            player_num.add(Integer.parseInt(number));
        }
        exception_Length(input);

        return player_num;
    }

    // IllegalArgumentException
    public void exception_Length(String s){
        if(s.length() != 3) {
            throw new IllegalArgumentException("세자리 수보다 크거나 작음");
        }
    }
}
