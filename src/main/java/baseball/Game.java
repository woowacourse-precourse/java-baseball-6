package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game{
    private final List<Integer> answerList;

    public Game(){
        answerList = getAnswerList();
    }

    public List<Integer> getAnswerList() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public GameResult getResult(List<Integer> userInputList){
        int ball = 0;
        int strike = 0;

        for(int i=0; i<3; i++){
            if(answerList.get(i).equals(userInputList.get(i))){
                strike++;
            }else if(answerList.contains(userInputList.get(i))){
                ball++;
            }
        }
        return new GameResult(ball, strike);
    }
}