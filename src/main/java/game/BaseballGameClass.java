package game;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BaseballGameClass implements Game{

    @Override
    public List<Integer> gameInit() {
        List<Integer> RandomAnswerGenerated = new ArrayList<>();
        while(RandomAnswerGenerated.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!RandomAnswerGenerated.contains(randomNumber)){
                RandomAnswerGenerated.add(randomNumber);
            }
        }
        return RandomAnswerGenerated;
    }


    @Override
    public void gamePlay() {

    }

    @Override
    public void gameExit() {

    }
}
