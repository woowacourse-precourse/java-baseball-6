package baseball.number;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Answer {

    private List<Integer> answer;


    public Answer(){
        this.answer = createAnswer();
    }

    private List<Integer> createAnswer(){
        List<Integer> randomList = new ArrayList<>();
        while(randomList.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!randomList.contains(randomNumber)){
                randomList.add(randomNumber);
            }
        }
        return randomList;
    }

    public int get(int i){
        return (int)answer.get(i);
    }
}
