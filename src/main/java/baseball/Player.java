package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> playerNum;

    public void inputPlayerNum(){
        System.out.print("숫자를 입력해주세요 : ");

        String input = Console.readLine();

        List<Integer> playerNumber = new ArrayList<>();

        for(String num: input.split("")){
            playerNumber.add(Integer.parseInt(num));
        }

        setPlayerNum(playerNumber);
    }

    public void setPlayerNum(List <Integer> l){
        this.playerNum = l;
    }

    public List<Integer> getPlayerNum(){
        return this.playerNum;
    }
}
