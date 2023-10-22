package baseball;

import java.util.List;

public class CompareNumber {
    // computer와 player의 리스트를 비교하여 strike와 ball count
    public static int[] checkNumber(List<Integer> computer, List<Integer> player){
        int[] strike_ball={0,0};
        for (int i = 0; i<3; i++){
            int playerNumber = player.get(i);
            if (computer.get(i).equals(playerNumber)){
                strike_ball[0] += 1;
                continue;
            }
            if (computer.contains(playerNumber)){
                strike_ball[1]+=1;
            }
        }
        return strike_ball;
    }
}