package baseball;

import java.util.ArrayList;

public class GameProcessor {


    public int[] getCompareTwoAnswerResult(ArrayList<Integer> playerAnswer, ArrayList<Integer> computerAnswer) {
        int[] result = new int[2];
        int playerOrder = 0;
        for(Integer playerValue : playerAnswer){
            int computerOrder = 0;
            for(Integer computerValue : computerAnswer){
                if(playerValue==computerValue&&playerOrder==computerOrder)
                    result[1]++;
                if(playerValue==computerValue&&playerOrder!=computerOrder)
                    result[0]++;
                computerOrder++;
            }
            playerOrder++;
        }

        return result;
    }



}
