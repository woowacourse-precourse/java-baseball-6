package baseball;

import java.util.List;

public class CompareNumber {
    public static int[] checkNumber(List<Integer> computer, List<Integer> player){
        int[] strike_ball = new int[2];

        for(int i = 0; i<3; i++){
            for (int j = 0; j<3; j++){
                if (player.get(i).equals(computer.get(j))){
                    if (i==j){
                        strike_ball[0]+=1;
                        break;
                    }
                    strike_ball[1]+=1;
                    break;
                }
            }
        }
        return strike_ball;
    }
}
