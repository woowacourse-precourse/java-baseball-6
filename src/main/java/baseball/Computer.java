package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> thinking;

    public Computer(){
    }
    public void think(){
        thinking =new ArrayList<>();
        thinkNumbers();
    }
    private void thinkNumbers(){
        while(thinking.size()<3){
            thinkNumber();
        }
    }
    private void thinkNumber(){
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!thinking.contains(randomNumber)) {
            thinking.add(randomNumber);
        }
    }
    public int countStrike(GuessNumber guessNumber){
        int retVal=0;
        String guess = guessNumber.getGuess();
        for(int i=0;i<3;i++){
            int guessNum=guess.charAt(i) - '0';
            retVal += (guessNum==thinking.get(i))?1:0;
        }
        return retVal;
    }
    public int countContains(GuessNumber guessNumber){
        int ret=0;
        String guess = guessNumber.getGuess();
        for (int i=0;i<3;i++){
            int guessNum = guess.charAt(i)-'0';
            ret += thinking.contains(guessNum)?1:0;
        }
        return ret;
    }
}
