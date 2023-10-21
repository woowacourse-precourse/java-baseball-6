package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Computer {
    private List<Integer> randomNumbers;
    public void generateRandNums(){
        List<Integer> randomNumberList = new ArrayList<>();
        while(randomNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            addNumberInList(randomNumberList, randomNumber);
        }
        randomNumbers = randomNumberList;
    }
    private void addNumberInList(List<Integer> randomNumbers, int value) {
        if(!randomNumbers.contains(value)) {
            randomNumbers.add(value);
        }
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
        if(userInput == randomNumbers.get(digit)) {
            baseballResult.put("strike", baseballResult.get("strike") + 1);
        } else if(randomNumbers.contains(userInput)){
            baseballResult.put("ball", baseballResult.get("ball") + 1);
        }
    }
}
