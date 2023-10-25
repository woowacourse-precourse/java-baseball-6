package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> playerNum;

    List<Integer> getPlayerNum(){
        return this.playerNum;
    }

    void inputPlayerNum(){
        System.out.print("숫자를 입력해주세요 : ");

        String input = Console.readLine();

        List<Integer> playerNumber = new ArrayList<>();

        for(String num: input.split("")){
            playerNumber.add(Integer.parseInt(num));
        }

        this.playerNum = playerNumber;
    }
}
