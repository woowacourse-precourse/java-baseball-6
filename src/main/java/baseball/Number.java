package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Number {
    // int 로 할 경우, ball, strike 판단이 힘듬
    private List<Integer> answer;
    private Number(){}

    /*
    * LazyHolder singleton pattern
    * site : https://javaplant.tistory.com/21
    * */
    public static Number getInstance(){
        return LazyHolder.instance;
    }

    private static class LazyHolder { private static final Number instance = new Number(); }

    public void generateAnswer(){
        answer = new ArrayList<>();
        // first value must in range(1,9)
        answer.add(genNumber(1,9));

        // other values must in range(0,9)
        while(answer.size()< 3){
            int newNumber = genNumber(0,9);
            if(!answer.contains(newNumber)){
                answer.add(newNumber);
            }
        }
    }

    public int genNumber(int first, int last){
        return Randoms.pickNumberInRange(first, last);
    }

    public int checkBall(List<Integer> predict){
        int result = 0;
        for(int i=0; i<answer.size(); i++){
            int answerIsIn = answer.indexOf(predict.get(i));
            if(answerIsIn!= -1 && answerIsIn!= i){
                result+=1;
            }
        }
        return result;
    }

    public int checkStrike(List<Integer> predict){
        int result = 0;
        for(int i=0; i<answer.size(); i++){
            if(answer.get(i).equals(predict.get(i))){
                result+=1;
            }
        }
        return result;
    }

    public List<Integer> checkAnswer(List<Integer> predict){
        int ball = checkBall(predict);
        int strike = checkStrike(predict);
        return new ArrayList<>(
                Stream.of(ball, strike)
                        .collect(Collectors.toList())
        );
    }

    public List<Integer> getAnswer() { return answer; }

    public void setAnswer(List<Integer> answer) { this.answer = answer; }


}
