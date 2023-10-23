package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
public class Computer {
    private final List<Integer> answer;

    public Computer(){
        answer = new ArrayList<>();
        generateUniqueNumbers();
    }

    private void generateUniqueNumbers(){
        while(answer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!answer.contains(randomNumber)){
                answer.add(randomNumber);
            }
        }
    }

    public List<Integer> getComputerNums(){
        return this.answer;
    }
}
