package baseball.logic;

import baseball.input.UserInput;
import baseball.output.Message;

import java.util.List;

public class CompareLogic {
    List<Integer> answerNumbers, userNumbers;

    public CompareLogic(List<Integer> answerNumbers, List<Integer> userNumbers) {
        this.answerNumbers = answerNumbers;
        this.userNumbers = userNumbers;
    }

    public boolean isAnswer(){
        int ballCount = countNumberOfBall();
        int strikeCount = countNumberOfStrike();
        if(strikeCount == 3){
            Message.printEndMessage();
            return true;
        }

        String OUTPUT_MESSAGE = "";
        if(ballCount > 0){ OUTPUT_MESSAGE += (ballCount + "볼 "); }
        if(strikeCount > 0){ OUTPUT_MESSAGE += (strikeCount + "스트라이크 "); }
        if(ballCount == 0 && strikeCount == 0){ OUTPUT_MESSAGE += "낫싱"; }

        System.out.println(OUTPUT_MESSAGE);
        return false;
    }

    public int countNumberOfBall(){
        int count = 0;
        for(int i=0; i<3; i++){
            int answerNumber = answerNumbers.get(i);
            int numberIndex = userNumbers.indexOf(answerNumber);

            if(i != numberIndex && numberIndex != -1){
                count ++;
            }
        }
        return count;
    }

    public int countNumberOfStrike(){
        int count = 0;
        for(int i=0; i<3; i++){
            int answerNumber = answerNumbers.get(i);
            int numberIndex = userNumbers.indexOf(answerNumber);

            if(i == numberIndex){
                count ++;
            }
        }
        return count;
    }
}
