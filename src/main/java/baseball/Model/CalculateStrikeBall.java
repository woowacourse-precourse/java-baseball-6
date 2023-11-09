package baseball.Model;

import java.util.List;

public class CalculateStrikeBall {
    public int totalStrikeBall(List<Integer> computer,List<Integer> userInput){
        int total = 0;
        for(int i = 0; i<userInput.size(); i++){
            if(computer.contains(userInput.get(i))){
                total += 1;
            }
        }
        return total;
    }

    public int countStrike(List<Integer> computer,List<Integer> userInput){
        int strike = 0;
        for(int i = 0; i<userInput.size(); i++){
            if(computer.get(i) == userInput.get(i)){
                strike += 1;
            }
        }
        return strike;
    }
}
