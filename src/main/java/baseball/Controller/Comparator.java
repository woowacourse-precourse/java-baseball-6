package baseball.Controller;

import java.util.ArrayList;
import java.util.HashSet;

public class Comparator {
    public boolean isNothing(ArrayList<Integer> computerNumber, ArrayList<Integer> playerInput){
            HashSet<Integer> set = new HashSet<>(computerNumber);
            for (int num : playerInput) {
                if (set.contains(num)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEndGame(ArrayList<Integer> computerNumber, ArrayList<Integer> playerInput){
            for (int i = 0; i < computerNumber.size(); i++) {
                if(!computerNumber.get(i).equals(playerInput.get(i)))
                    return false;
            }
            return true;
        }

        public int countStrikes(ArrayList<Integer> computerNumber, ArrayList<Integer> playerInput){
            int strikeCount=0;
            for (int i = 0; i < computerNumber.size(); i++) {
                if(computerNumber.get(i).equals(playerInput.get(i)))
                    strikeCount++;
            }
            return strikeCount;
        }

        public int countBalls(ArrayList<Integer> computerNumber, ArrayList<Integer> playerInput){
            int ballCount = 0;
            for(int i = 0; i < computerNumber.size(); i++) {
                for(int j = 0; j < playerInput.size(); j++) {
                    if(i != j && computerNumber.get(i).equals(playerInput.get(j)))
                        ballCount++;
                    }
            }
            return ballCount;
         }


    }

