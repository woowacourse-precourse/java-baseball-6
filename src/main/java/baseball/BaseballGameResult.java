package baseball;

import java.util.HashMap;
import java.util.Map;

public class BaseballGameResult {
    private final Map<String, Integer> baseballGameResult;
    public BaseballGameResult(ComputerBaseballNumber computerBaseballNumber, UserBaseballNumber userBaseballNumber){
        baseballGameResult = new HashMap<>();
        baseballGameResult.put("strike", 0);
        baseballGameResult.put("ball", 0);
        for(int i = 0; i < userBaseballNumber.size(); i++){
            checkIfInputIsStrikeOrBall(computerBaseballNumber, userBaseballNumber, i);
        }
    }
    private void checkIfInputIsStrikeOrBall(ComputerBaseballNumber computerBaseballNumber, UserBaseballNumber userBaseballNumber, int digit){
        int userInput = userBaseballNumber.get(digit);
        if(userInput == computerBaseballNumber.get(digit)) {
            baseballGameResult.put("strike", baseballGameResult.get("strike") + 1);
        } else if(computerBaseballNumber.contains(userInput)){
            baseballGameResult.put("ball", baseballGameResult.get("ball") + 1);
        }
    }
    public void print(){
        int strikeCount = baseballGameResult.get("strike");
        int ballCount = baseballGameResult.get("ball");
        printStrikeAndBall(strikeCount, ballCount);
    }
    private void printStrikeAndBall(int strikeCount, int ballCount){
        if(strikeCount == 0 && ballCount == 0){
            System.out.println("낫싱");
            return;
        }
        if(strikeCount == 0){
            System.out.println(ballCount + "볼");
            return;
        }
        if(ballCount == 0){
            System.out.println(strikeCount + "스트라이크");
            return;
        }
        if(ballCount > 0 && strikeCount > 0){
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
    }
    public boolean isThreeStrike(){
        return (baseballGameResult.get("strike") == 3);
    }
}
