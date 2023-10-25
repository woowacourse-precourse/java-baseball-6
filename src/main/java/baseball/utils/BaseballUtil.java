package baseball.utils;

import java.util.ArrayList;
import java.util.Collections;

public class BaseballUtil {

    public static ArrayList<Integer> splitNumberToList(int playerNum){
        ArrayList<Integer> playerNumbers = new ArrayList<>();

        while(playerNum > 0){
            if(!playerNumbers.contains(playerNum %10)){
                playerNumbers.add(playerNum %10);
            }
            playerNum /=10;
        }
        Collections.reverse(playerNumbers);
        //System.out.println("++++" + playerNumbers);
        return playerNumbers;
    }

    //Strike
    public static int equalBetweenStrike(ArrayList<Integer> computerNumbers, ArrayList<Integer> playerNumbers){
        int strikeCnt = 0;
        for(int num_i=0; num_i<playerNumbers.size(); num_i++){
            if(playerNumbers.get(num_i).equals(computerNumbers.get(num_i))){
                strikeCnt++;
            }
        }
        return strikeCnt;
    }

    //ball
    public static int equalBetweenBall(ArrayList<Integer> computerNumbers, ArrayList<Integer> playerNumbers){
        int ballCnt = 0;

        for(int num_i=0; num_i<playerNumbers.size(); num_i++){
            if(playerNumbers.contains(computerNumbers.get(num_i))){
                if(!playerNumbers.get(num_i).equals(computerNumbers.get(num_i))){
                    ballCnt++;
                }
            }
        }

        return ballCnt;
    }
}
