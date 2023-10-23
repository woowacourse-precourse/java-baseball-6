package baseball;
import converter.Converter;

import java.util.List;

import static baseball.Application.NUMBER_LENGTH;

public class BaseballGameService {
    boolean allStrike = false;
    Converter converter = new Converter();
    public boolean baseballGameServiceStart(String input, List<Integer> computerNumber){
        List<Integer> userInputList = converter.stringToIntList(input);
        int ball = countBall(computerNumber, userInputList);
        int strike = countStrike(computerNumber, userInputList);
        if (strike == NUMBER_LENGTH) {
            return false;
        }
        if(ball> 0 && strike< 1){
            System.out.printf("%d볼%n", ball);
            return true;
        }
        if(ball> 0 && strike> 0) {
            System.out.printf("%d볼 %d스트라이크%n",ball,strike);
            return true;
        }
        if(ball< 0 && strike> 0 ){
            System.out.printf("%d스트라이크%n",strike);
            return true;
        }
        return true;
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
    public int countStrike(List computerNumber, List userInput){
        int strike = 0;
        for(int i=0; i<computerNumber.size() ; i++){
            if(isStrike(i, computerNumber, userInput)){
                strike++;
            }
        }
        return strike;
    }
    public boolean isStrike(int digit, List computerNumber, List userInput){
        if(computerNumber.get(digit).equals(userInput.get(digit))){
            return true;
        }
        return false;
    }

}
