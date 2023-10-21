package baseball;

import java.util.List;

public class CompareNumber {
    public static int[] checkNumber(List<Integer> computer, List<Integer> player){
        int strike = 0;
        int ball = 0;
        int playerNumber;
        for (int i = 0; i<3; i++){
            playerNumber = player.get(i);
            if (computer.get(i).equals(playerNumber)){
                strike+=1;
                continue;
            }
            if (computer.contains(playerNumber)){
                ball+=1;
            }
        }
        return new int[]{strike,ball};
    }
}