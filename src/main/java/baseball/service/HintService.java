package baseball.service;

import baseball.view.EndView;
import baseball.view.HintView;
import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class HintService {
    private static String NUMBER_PATTERN = "[1-9]{3}";

    public int ballCnt=0;
    public int strikeCnt=0;
    public int[] answerArray;
    public String inputNumber;

    public HintService(int[] answerArray){
        this.answerArray = answerArray;
    }

    public void getInputNumber(){
        HintView.askInputNumber();
        inputNumber = Console.readLine();
        if(!HintService.isValidNumber(inputNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean isValidNumber(String inputNumber){
        return Pattern.matches(NUMBER_PATTERN, inputNumber)
                && inputNumber.charAt(0) != inputNumber.charAt(1)
                && inputNumber.charAt(1) != inputNumber.charAt(2)
                && inputNumber.charAt(0) != inputNumber.charAt(2);
    }

    public void printHint(){
        countHintNumber();
        if(ballCnt>0 && strikeCnt>0) {
            HintView.printBallAndStrikeHint(ballCnt, strikeCnt);
        }
        else if(ballCnt>0) {
            HintView.printBallHint(ballCnt);
        }
        else if(strikeCnt>0) {
            HintView.printStrikeHint(strikeCnt);
        }
        else {
            HintView.printNothingHint();
        }

        if(strikeCnt==3) EndView.printNumberCorrect();
    }

    public void countHintNumber(){

        for(int i=0; i<3; i++){
            int N = inputNumber.charAt(i)-'0';
            if(N==answerArray[0] || N==answerArray[1] || N==answerArray[2]){
                if(N == answerArray[i]) strikeCnt++;
                else ballCnt++;
            }
        }
    }

    public boolean isCorrect(){
        return strikeCnt == 3;
    }
}
