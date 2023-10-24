package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


public class Startgame {
    public List<Integer> playernum() {
        System.out.println("숫자를 입력하세요 :");
        List<Integer> playernum = new ArrayList<>();
        String input = Console.readLine();

        for(String number : input.split("")) {
            playernum.add(Integer.parseInt(number));
        }
        exception_Length(input);

        return playernum;
    }

    public void exception_Length(String s) {
        if(s.length() != 3)
            throw new IllegalArgumentException("세자리 수보다 크거나 작음");
    }

}
