package baseball;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Computer {
    private ComputerBaseballNumber computerBaseballNumber;
    public void generateRandNums(){
        computerBaseballNumber = new ComputerBaseballNumber();
    }
    public Map<String, Integer> getBaseballResult(List<Integer> userInputNumbers){
        Map<String, Integer> baseballResult = new HashMap<>();
        baseballResult.put("strike", 0);
        baseballResult.put("ball", 0);
        for(int i = 0; i < userInputNumbers.size(); i++){
            checkIfInputIsStrikeOrBall(userInputNumbers, i, baseballResult);
        }
        return baseballResult;
    }
    private void checkIfInputIsStrikeOrBall(List<Integer> userInputNumbers, int digit, Map<String, Integer> baseballResult){
        int userInput = userInputNumbers.get(digit);
        if(userInput == computerBaseballNumber.get(digit)) {
            baseballResult.put("strike", baseballResult.get("strike") + 1);
        } else if(computerBaseballNumber.contains(userInput)){
            baseballResult.put("ball", baseballResult.get("ball") + 1);
        }
    }
}
