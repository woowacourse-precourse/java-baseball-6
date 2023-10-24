package baseball.number;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Answer {

    private static List<Integer> answer;


    public Answer(){
        this.answer = createAnswer();
    }

    private static List<Integer> createAnswer(){
        List<Integer> randomList = new ArrayList<>();
        while(randomList.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!randomList.contains(randomNumber)){
                randomList.add(randomNumber);
            }
        }
        return randomList;
    }

    public Integer getAnswer(int i){
        return answer.get(i);
    }

    public boolean answerContain(Integer i){
        if(answer.contains(i)) return true;
        return false;
    }

}
