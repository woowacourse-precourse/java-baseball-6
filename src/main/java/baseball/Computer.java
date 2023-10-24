package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
public class Computer {
    private List<Integer> answer;

    public List<Integer> load(){
        answer = new ArrayList<>();
        generateUniqueNumbers();
        return getComputerNums();
    }

    private void generateUniqueNumbers(){
        while(answer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!answer.contains(randomNumber)){
                answer.add(randomNumber);
            }
        }
    }

    private List<Integer> getComputerNums(){
        return this.answer;
    }
}
