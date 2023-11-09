package baseball.Model;

import java.util.List;

public class TotalStrikeBallNum {
    public int totalStrikeBall(List<Integer> computer,List<Integer> userInput){
        int result = 0;
        for(int i = 0; i<userInput.size(); i++){
            if(computer.contains(userInput.get(i))){
                result += 1;
            }
        }
        return result;
    }

}
