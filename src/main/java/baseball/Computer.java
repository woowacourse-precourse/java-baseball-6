package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private  int length;

    private  Computer(){

    }

    Computer(int length){
        this.length = length;
    }

    public List<Integer> makeAnswer(){
        List<Integer> answer = new ArrayList<>();
        while(answer.size() < length){
            addNumber(answer);
        }
        return answer;
    }

    private void addNumber(List<Integer> answer){
        int number = Randoms.pickNumberInRange(1,9);
        if(!answer.contains(number)){
            answer.add(number);
        }
    }
}
