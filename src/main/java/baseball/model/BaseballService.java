package baseball.model;

import java.util.ArrayList;

public class BaseballService {
    public int manageStrike(Computer computer, Player player) {
        int cnt=0;
        ArrayList<Integer> computerNum = computer.getComputer();
        ArrayList<Integer> playerNum = player.getPlayer();
        for (int i=0; i<3; i++) {
            if(playerNum.get(i).equals(computerNum.get(i))){
                cnt+=1;
            }
        }
        if(cnt==3){
            player.flag = true;
        }
        return cnt;
    }

    public int manageBall(Computer computer, Player player){
        int cnt=0;
        ArrayList<Integer> computerNum = computer.getComputer();
        ArrayList<Integer> playerNum = player.getPlayer();
        for (int i=0; i<3; i++){
            int playerIdxNum = playerNum.get(i);
            int computerIdxNum = computerNum.get(i);
            if((playerIdxNum!=computerIdxNum)&&(computerNum.contains(playerIdxNum))){
                cnt+=1;
            }
        }
        return cnt;
    } // 낫싱은 output에서 출력
}
