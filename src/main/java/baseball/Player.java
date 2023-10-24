package baseball;

import camp.nextstep.edu.missionutils.Console;


import java.util.ArrayList;
import java.util.List;

public class Player {
    public List<Integer> playerNumber(){
        List<Integer> player = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        for(int i =0; i<input.length(); i++){
            char c = input.charAt(i);
            player.add(c -'0');
        }
        return player;
    }
}
