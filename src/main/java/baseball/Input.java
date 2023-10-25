package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public List<Integer> playerNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        String s = Console.readLine();

        if(Integer.parseInt(s)>999 || Integer.parseInt(s)<100) {
            throw new IllegalArgumentException("세자리 수보다 크거나 작음");
        }

        List<Integer> playerNum = new ArrayList<>();
        for(int i=0; i<s.length(); i++) {
            playerNum.add(s.charAt(i) - '0');
        }
        return playerNum;
    }
}
