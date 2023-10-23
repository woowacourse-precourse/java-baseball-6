package baseball;
import baseball.GenerateRandomNumber;
import converter.Converter;

import java.util.List;

public class BaseballGameService {
    boolean allStrike = false;
    GenerateRandomNumber generateRandomNumber = new GenerateRandomNumber();
    Converter converter = new Converter();
    public boolean baseballGameServiceStart(String input){
        List<Integer> computerNumber=generateRandomNumber.generateRandomNumber();
        List<Integer> userInputList = converter.stringToIntList(input);
        int ball= countBall(computerNumber,userInputList);
        return false;
    }
    public int countBall(List computerNumber, List userInputList){
        int ballCount =0 ;
        for(int i=0; i<computerNumber.size(); i++){
            if(isBall(i,computerNumber,userInputList)){
                ballCount++;
            }
        }
        return ballCount;
    }
    public boolean isBall(int digit, List computerNumber, List userInput){
        for(int index=0; index<userInput.size(); index++){
            if(digit==index){
                continue;
            }
            if(userInput.get(index).equals(computerNumber.get(digit))){
                return true;
            }
        }
        return false;
    }
}
