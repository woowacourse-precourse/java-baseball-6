package baseball;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Referee {

    private Printer pr;
    private int length;
    private List<Integer> answer;

    Referee(int length){
        this.length = length;
        this.pr = new Printer();
    }

    private Referee() {

    }

    public void setAnswer(List<Integer> answer){
        this.answer = answer;
    }

    public boolean judge(int input){
        int ball = 0;
        int strike = 0;
        List<Integer> userInput = converttoList(input);
        for(int i = 0 ; i < length; i++){
            int answerDigit = answer.get(i);
            int userInputDigit = userInput.get(i);
            if(answerDigit == userInputDigit){
                strike ++;
            }

            if(answerDigit != userInputDigit && answer.contains(userInputDigit)){
                ball ++;
            }
        }

        if(ball == 0 && strike == 0){
            pr.nothingMessage();
        }

        if(ball == 0 && strike != 0){
            pr.onlyStrikeMessage(strike);
        }

        if(ball!= 0 && strike == 0){
            pr.onlyBallMessage(ball);
        }

        if(ball!=0 && strike !=0){
            pr.ballStirkeMessage(ball, strike);
        }
        return strike == 3;

    }

    private List<Integer> converttoList(int input){
        List<Integer> inputToList = new ArrayList<>(length);
        for(int i = 0 ; i < length ;i++){
            inputToList.add(0,input % 10);
            input /= 10;
        }

        return inputToList;
    }
}
