package baseball.model;

import java.util.ArrayList;

public class BaseballService {
    public int manageStrike(Computer computer,Player player) {
        int cnt=0;
        ArrayList<Integer> computerNum = computer.getComputer();
        ArrayList<Integer> playerNum = player.getPlayer();
        for (int i=0; i<3; i++) {
            if(playerNum.get(i).equals(computerNum.get(i))){
                cnt+=1;
            }
        }
        if(cnt==0){
            player.flag = true;
        }
        return cnt;
    }
}
